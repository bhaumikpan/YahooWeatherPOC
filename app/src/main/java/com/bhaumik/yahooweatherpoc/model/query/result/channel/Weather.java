package com.bhaumik.yahooweatherpoc.model.query.result.channel;

import com.bhaumik.yahooweatherpoc.model.query.result.channel.weather.WeatherCondition;
import com.bhaumik.yahooweatherpoc.model.query.result.channel.weather.WeatherForecast;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by bhaumik on 9/27/17.
 */

public class Weather {

    private String title;
    private String lat;
    @SerializedName("long") // cannot use long as variable name, reserved keyword
    private String longitude;
    private String link;
    private String pubDate; //"Wed, 27 Sep 2017 10:00 PM PDT"

    private WeatherCondition condition;
    private ArrayList<WeatherForecast> forecast;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public WeatherCondition getCondition() {
        return condition;
    }

    public void setCondition(WeatherCondition condition) {
        this.condition = condition;
    }

    public ArrayList<WeatherForecast> getForecast() {
        return forecast;
    }

    public void setForecast(ArrayList<WeatherForecast> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "title='" + title + '\'' +
                ", lat='" + lat + '\'' +
                ", longitude='" + longitude + '\'' +
                ", link='" + link + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", condition=" + condition +
                ", forecast=" + forecast +
                '}';
    }
}
