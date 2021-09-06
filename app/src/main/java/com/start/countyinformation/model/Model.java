
package com.start.countyinformation.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.start.countyinformation.model.converter.CurrencyConverter;
import com.start.countyinformation.model.converter.LanguageConverter;
import com.start.countyinformation.model.converter.LatLngConverter;
import com.start.countyinformation.model.converter.RegionalBlocConverter;
import com.start.countyinformation.model.converter.StringToListConverter;
import com.start.countyinformation.model.converter.TopLevelDomainConverter;
import com.start.countyinformation.model.converter.TranslationsConverter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Entity(tableName = "Country")
@Generated("jsonschema2pojo")
public class Model implements Parcelable {
    public Model() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("topLevelDomain")
    @Expose
    @TypeConverters({TopLevelDomainConverter.class})
    private List<Object> topLevelDomain = null;
    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;
    @SerializedName("alpha3Code")
    @Expose
    private String alpha3Code;
    @SerializedName("callingCodes")
    @Expose
    @TypeConverters({StringToListConverter.class})
    private List<String> callingCodes = null;
    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("altSpellings")
    @Expose
    @TypeConverters({StringToListConverter.class})
    private List<String> altSpellings = null;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("subregion")
    @Expose
    private String subregion;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("latlng")
    @Expose
    @TypeConverters({LatLngConverter.class})
    private List<Double> latlng = null;
    @SerializedName("demonym")
    @Expose
    private String demonym;
    @SerializedName("area")
    @Expose
    private Double area;
    @SerializedName("gini")
    @Expose
    private Double gini;
    @SerializedName("timezones")
    @Expose
    @TypeConverters({StringToListConverter.class})
    private List<String> timezones = null;
    @SerializedName("borders")
    @Expose
    @TypeConverters({StringToListConverter.class})
    private List<String> borders = null;
    @SerializedName("nativeName")
    @Expose
    private String nativeName;
    @SerializedName("numericCode")
    @Expose
    private String numericCode;

    @SerializedName("currencies")
    @Expose
    @TypeConverters({CurrencyConverter.class})
    private List<Currency> currencies = null;

    @SerializedName("languages")
    @Expose
    @TypeConverters({LanguageConverter.class})
    private List<Language> languages = null;

    @SerializedName("translations")
    @Expose
    @TypeConverters({TranslationsConverter.class})
    private Translations translations;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("regionalBlocs")
    @Expose
    @TypeConverters({RegionalBlocConverter.class})
    private List<RegionalBloc> regionalBlocs = null;
    @SerializedName("cioc")
    @Expose
    private String cioc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List<Object> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getGini() {
        return gini;
    }

    public void setGini(Double gini) {
        this.gini = gini;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public Translations getTranslations() {
        return translations;
    }

    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<RegionalBloc> getRegionalBlocs() {
        return regionalBlocs;
    }

    public void setRegionalBlocs(List<RegionalBloc> regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }


    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public Model(Parcel in) {
        try {
            languages = new ArrayList<Language>();
            in.readTypedList(languages, Language.CREATOR);
            name = in.readString();
            alpha2Code = in.readString();
            alpha3Code = in.readString();
            capital = in.readString();
            region = in.readString();
            subregion = in.readString();
            demonym = in.readString();
            nativeName = in.readString();
            cioc = in.readString();
            flag = in.readString();
            numericCode = in.readString();
            id = in.readInt();
            population = in.readInt();
            area = in.readDouble();
            gini = in.readDouble();
            callingCodes = new ArrayList<>();
            in.readStringList(callingCodes);
            timezones = new ArrayList<>();
            in.readStringList(timezones);
            borders = new ArrayList<>();
            in.readStringList(borders);
            altSpellings = new ArrayList<>();
            in.readStringList(altSpellings);
            //translation

            latlng = new ArrayList<Double>();
            in.readList(latlng, Double.class.getClassLoader());

            topLevelDomain = new ArrayList<Object>();
            in.readList(topLevelDomain, Object.class.getClassLoader());

            regionalBlocs = new ArrayList<>();
            in.readTypedList(regionalBlocs, RegionalBloc.CREATOR);

            currencies = new ArrayList<Currency>();
            in.readTypedList(currencies, Currency.CREATOR);

        } catch (Exception exception) {
            Log.i("Read", exception.getMessage());
        }

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        try {
            dest.writeTypedList(languages);
            dest.writeString(name);
            dest.writeString(alpha2Code);
            dest.writeString(alpha3Code);
            dest.writeString(capital);
            dest.writeString(region);
            dest.writeString(subregion);
            dest.writeString(demonym);
            dest.writeString(nativeName);
            dest.writeString(cioc);
            dest.writeString(flag);
            dest.writeString(numericCode);
            dest.writeInt(id);
            dest.writeInt(population);
            if (area != null) {
                dest.writeDouble(area);
            } else {
                dest.writeDouble(0);
            }
            if (gini != null) {
                dest.writeDouble(gini);
            } else {
                dest.writeDouble(0);
            }

            dest.writeStringList(callingCodes);
            dest.writeStringList(timezones);
            dest.writeStringList(borders);
            dest.writeStringList(altSpellings);
            //dest.writeValue(translations);
            dest.writeList(latlng);
            dest.writeList(topLevelDomain);
            dest.writeTypedList(regionalBlocs);
            dest.writeTypedList(currencies);
        } catch (Exception exception) {
            Log.i("Write", exception.getMessage());
        }


    }
}
