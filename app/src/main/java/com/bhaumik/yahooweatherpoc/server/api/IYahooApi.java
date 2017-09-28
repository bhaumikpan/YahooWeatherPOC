package com.bhaumik.yahooweatherpoc.server.api;

import com.bhaumik.yahooweatherpoc.server.util.YahooResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by bhaumik on 9/27/17.
 */

public interface IYahooApi {

    // /v1/public/yql?q=select * from geo.places where text="walnut creek, ca"

    @GET("/v1/public/yql")
    Call<YahooResponse> queryYahoo(@Query("q") String query, @Query("format") String format);

}
