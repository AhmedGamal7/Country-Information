package com.start.countyinformation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;
import com.start.countyinformation.model.Currency;
import com.start.countyinformation.model.Language;
import com.start.countyinformation.model.Model;

public class DetailActivity extends AppCompatActivity {

    ImageView iv_flag;
    TextView tv_name, tv_alpha3Code, tv_capital, tv_nativeName, tv_region, tv_subRegion, tv_nativeLanguage, tv_currencyName, tv_currencySymbol, tv_population, tv_callingCodes, tv_timezones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Model country = getIntent().getParcelableExtra("Country");


        iv_flag = findViewById(R.id.iv_flag);
        GlideToVectorYou
                .init()
                .with(this)
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
                .load(Uri.parse(country.getFlag()), iv_flag);

        iv_flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MapsActivity.class);
                intent.putExtra("Name", country.getName());
                intent.putExtra("Lat", (Double) country.getLatlng().get(0));
                intent.putExtra("Log", (Double) country.getLatlng().get(1));
                startActivity(intent);
            }
        });

        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(country.getName());

        tv_alpha3Code = findViewById(R.id.tv_alpha3Code);
        tv_alpha3Code.setText(country.getAlpha3Code());

        tv_capital = findViewById(R.id.tv_capital);
        tv_capital.setText(country.getCapital());

        tv_nativeName = findViewById(R.id.tv_nativeName);
        tv_nativeName.setText(country.getNativeName());

        tv_region = findViewById(R.id.tv_region);
        tv_region.setText(country.getRegion());

        tv_subRegion = findViewById(R.id.tv_sub_region);
        tv_subRegion.setText(country.getSubregion());

        //set language
        tv_nativeLanguage = findViewById(R.id.tv_nativeLanguage);
        String languages = "";
        if (country.getLanguages() != null) {
            if (country.getLanguages().size() > 1) {
                for (Language item : country.getLanguages()) {
                    languages += item.getName() + " / ";
                }
            } else {
                languages = country.getLanguages().get(0).getName();
            }

            tv_nativeLanguage.setText(languages);
        }

        //set currency
        tv_currencyName = findViewById(R.id.tv_currencyName);
        tv_currencySymbol = findViewById(R.id.tv_currencySymbol);
        String currencies = "";
        String symbols = "";
        if (country.getCurrencies() != null) {
            if (country.getCurrencies().size() > 1) {
                for (Currency item : country.getCurrencies()) {
                    currencies += item.getName() + " / ";
                    symbols += item.getSymbol() + " / ";
                }
            } else {
                currencies = country.getCurrencies().get(0).getName();
                symbols = country.getCurrencies().get(0).getSymbol();
            }
            tv_currencyName.setText(currencies);
            tv_currencySymbol.setText(symbols);
        }


        tv_population = findViewById(R.id.tv_population);
        tv_population.setText(country.getPopulation() + "m");

        tv_callingCodes = findViewById(R.id.tv_callingCodes);
        String callingCodes = "";
        if (country.getCallingCodes() != null) {
            if (country.getCallingCodes().size() > 1) {
                for (String item : country.getCallingCodes()) {
                    callingCodes += item + " / ";
                }
            } else {
                callingCodes = country.getCallingCodes().get(0) + "";
            }
            tv_callingCodes.setText(callingCodes);
        }


        tv_timezones = findViewById(R.id.tv_timezones);
        String timeZones = "";
        if (country.getTimezones() != null) {
            if (country.getTimezones().size() > 1) {
                for (String item : country.getTimezones()) {
                    timeZones += item + " / ";
                }
            } else {
                timeZones = country.getTimezones().get(0) + "";
            }
            tv_timezones.setText(timeZones);
        }


    }
}