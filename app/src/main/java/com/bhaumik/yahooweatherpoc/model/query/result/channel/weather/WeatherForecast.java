package com.bhaumik.yahooweatherpoc.model.query.result.channel.weather;

/**
 * Created by bhaumik on 9/27/17.
 */

public class WeatherForecast {

    private String code;
    private String date; // "27 Sep 2017"
    private String day; // "Wed"
    private String high;
    private String low;
    private String text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "code='" + code + '\'' +
                ", date='" + date + '\'' +
                ", day='" + day + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
