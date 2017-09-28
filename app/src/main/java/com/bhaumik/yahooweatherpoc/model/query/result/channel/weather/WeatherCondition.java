package com.bhaumik.yahooweatherpoc.model.query.result.channel.weather;

/**
 * Created by bhaumik on 9/27/17.
 */

public class WeatherCondition {

    private String code;
    private String date;
    private String temp;
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

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "WeatherCondition{" +
                "code='" + code + '\'' +
                ", date='" + date + '\'' +
                ", temp='" + temp + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
