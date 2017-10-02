package com.bhaumik.yahooweatherpoc.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bhaumik.yahooweatherpoc.R;
import com.bhaumik.yahooweatherpoc.model.query.result.Channel;
import com.bhaumik.yahooweatherpoc.model.query.result.channel.Weather;
import com.bhaumik.yahooweatherpoc.server.api.YahooServer;

/**
 * Created by bhaumik on 10/1/17.
 */

public class WeatherFragment  extends Fragment {

    public static final String WEATHER_CITY = "city";
    private String displayCity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        displayCity = getArguments().getString(WEATHER_CITY, "");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onResume() {
        super.onResume();
        loadWeather(displayCity);
    }

    private void loadWeather(String displayCity) {
        YahooServer.getInstance().getWeather(displayCity, new YahooServer.IServerCallBack() {
            @Override
            public void WeatherCallback(boolean success, String requestLocation, Channel channel, String errorMessage) {
                if(success){
                    if(channel != null){
                        displayWeather(channel);
                    }
                }
            }
        });
    }

    private void displayWeather(Channel channel) {
        Weather weather = channel.getItem();
        TextView textview = getView().findViewById(R.id.section_label);
        String text = weather.getTitle() + " \n "+ weather.getCondition().getText() + " Current temp:  " +weather.getCondition().getTemp();
        textview.setText(text);
    }
}
