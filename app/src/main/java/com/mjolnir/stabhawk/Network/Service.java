package com.mjolnir.stabhawk.Network;

import com.mjolnir.stabhawk.Data.YQLResponse;


import retrofit2.Result;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by samuel_chordas on 2/6/17.
 */


public interface Service {

    @GET("yql?format=json&callback=")
    Observable<YQLResponse> getData(
            @Query("q") String symbol,
            @Query("env") String env
    );
}
