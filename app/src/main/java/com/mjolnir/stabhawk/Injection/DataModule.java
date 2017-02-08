package com.mjolnir.stabhawk.Injection;

import android.app.Application;


import com.mjolnir.stabhawk.Network.Service;
import com.mjolnir.stabhawk.Network.StockData;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * Created by samuel_chordas on 2/6/17.
 */

@Module
public class DataModule {
    Application mApplication;

    public static final String BASE_URL = "https://query.yahooapis.com/v1/public/";

    public DataModule(Application application){
        mApplication = application;
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient().newBuilder().build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
         return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    public Service provideStockService(Retrofit retrofit){
        return retrofit.create(Service.class);
    }

    @Provides
    public StockData provideStockData(){return new StockData();}
}
