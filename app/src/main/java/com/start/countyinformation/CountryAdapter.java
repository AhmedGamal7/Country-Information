package com.start.countyinformation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;
import com.start.countyinformation.model.Model;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> implements Filterable {

    List<Model> list, searchList;
    Context context;
    int layout = 1;

    public CountryAdapter(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
        this.searchList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Log.i("Ax", list.get(position).getCurrencies().get(0).getName());
        holder.mTextView.setText(list.get(position).getName());
        String image_url = list.get(position).getFlag();
        GlideToVectorYou
                .init()
                .with(context)
                .withListener(new GlideToVectorYouListener() {
                    @Override
                    public void onLoadFailed() {
                        //Toast.makeText(context, "Load failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResourceReady() {
                        //Toast.makeText(context, "Image ready", Toast.LENGTH_SHORT).show();
                    }
                })
                .load(Uri.parse(image_url), holder.mImageView);

        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout == 1) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("Country", list.get(position));
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context,
                            Pair.create(holder.mImageView, "flagTransition"),
                            Pair.create(holder.mTextView, "nameTransition"));
                    context.startActivity(intent, options.toBundle());
                } else {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("Country", list.get(position));
                    context.startActivity(intent);

                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Model> list) {
        this.list = list;
        this.searchList = list;
        notifyDataSetChanged();
    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Model> filteredList = new ArrayList();
            if (constraint == null) {
                list = searchList;
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Model item : searchList) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
                list = filteredList;
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = list;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list = (List<Model>) results.values;
            notifyDataSetChanged();
        }
    };

    public void setLayout(int i) {
        this.layout = i;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;
        LinearLayout mContainer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.mTextView);
            mImageView = itemView.findViewById(R.id.mImageView);
            mContainer = itemView.findViewById(R.id.mContainer);
        }

    }


}


