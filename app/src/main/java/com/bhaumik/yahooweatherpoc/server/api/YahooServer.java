package com.bhaumik.yahooweatherpoc.server.api;

import android.util.Log;

import com.bhaumik.yahooweatherpoc.model.Query;
import com.bhaumik.yahooweatherpoc.model.query.result.Channel;
import com.bhaumik.yahooweatherpoc.model.query.result.channel.Weather;
import com.bhaumik.yahooweatherpoc.server.util.YahooResponse;
import com.bhaumik.yahooweatherpoc.server.util.YahooRetrofit;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by bhaumik on 9/27/17.
 */

public class YahooServer {
    private static YahooServer instance = new YahooServer();

    public static YahooServer getInstance() {
        return instance;
    }

    private YahooServer() {}

    public void getWeather(final String requestLocation, final IServerCallBack callBack){

        String query =  "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"" + requestLocation + "\")";

        Call<YahooResponse> call = YahooRetrofit.getInstance().getYahooApi().queryYahoo(query, "json");
        Log.d("BMK", ""+call.request().toString());
        call.enqueue(new Callback<YahooResponse>() {
            @Override
            public void onResponse(Call<YahooResponse> call, retrofit2.Response<YahooResponse> response) {
                Channel requestChannel = null ;
                if(response.isSuccessful() && response.body() != null){
                  //  Log.d("BMK", "WEATHER NOW "+response.body().getQuery().getResults().getChannel().getDescription());
                    if(response.body().getQuery() != null){
                        requestChannel = response.body().getQuery().getResults().getChannel();
                    }
                }
                callBack.WeatherCallback(response.isSuccessful(), requestLocation,  requestChannel, null);
            }

            @Override
            public void onFailure(Call<YahooResponse> call, Throwable t) {
                callBack.WeatherCallback(false, requestLocation, null, t.getMessage());
            }
        });
    }

    public interface IServerCallBack{
        void WeatherCallback(boolean success, String requestLocation, Channel channel, String errorMessage);
    }

}
