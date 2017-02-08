package com.mjolnir.stabhawk.Network;


import com.mjolnir.stabhawk.StabHawkApplication;
import com.mjolnir.stabhawk.Data.YQLResponse;

import javax.inject.Inject;

import retrofit2.Result;
import rx.Observable;

/**
 * Created by samuel_chordas on 2/6/17.
 */

public class StockData {

    String env = "store://datatables.org/alltableswithkeys";

    @Inject
    Service service;

    public StockData(){
        StabHawkApplication.getApp().getDataComponent().inject(this);
    }

    public Observable<YQLResponse> getStockData(String symbol){
        return service.getData(symbol, env);
    }
}
