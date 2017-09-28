package com.bhaumik.yahooweatherpoc.server.util;

import com.bhaumik.yahooweatherpoc.server.api.IYahooApi;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bhaumik on 9/27/17.
 */

public class YahooRetrofit {

    private YahooRetrofit() {}
    private static YahooRetrofit instance = new YahooRetrofit();
    private static Retrofit builder =  new YahooRetrofitBuilder().getInstance();

    public static YahooRetrofit getInstance(){
        if(instance == null || builder == null){
            instance = new YahooRetrofit();
            builder = new YahooRetrofitBuilder().getInstance();
        }

        return instance;
    }

    public IYahooApi getYahooApi(){
        return  builder.create(IYahooApi.class);
    }

    private static class YahooRetrofitBuilder{

        private  Retrofit retrofitInstance ;

        private YahooRetrofitBuilder() {}

        Retrofit getInstance() {
            if(retrofitInstance == null){
                retrofitInstance = new Retrofit.Builder()
                        .baseUrl("http://query.yahooapis.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofitInstance;
        }
    }
}
