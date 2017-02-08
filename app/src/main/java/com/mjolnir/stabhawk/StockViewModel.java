package com.mjolnir.stabhawk;

import android.util.Log;

import com.mjolnir.stabhawk.Data.Quote;
import com.mjolnir.stabhawk.Data.YQLResponse;
import com.mjolnir.stabhawk.Network.StockData;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by samuel_chordas on 2/6/17.
 */

public class StockViewModel {

    @Inject
    StockData stockData;

    StockView stockView;

    public StockViewModel(StockView stockView){
        this.stockView = stockView;

        StabHawkApplication.getApp().getDataComponent().inject(this);
    }

    public interface StockView {
        void getData(ArrayList<Quote> data);
    }

    public void networkCall(String symbol){
        stockData.getStockData(symbol)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> {
                    Log.e(StockViewModel.class.getSimpleName(),
                            "Slow down, Wolfie. Something went wrong getting your stocks " + throwable.getMessage());
                })
                .subscribe(yqlResponse -> {
                    stockView.getData(yqlResponse.getQuery().getResults().getQuote());
                });
    }
}
