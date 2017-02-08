package com.mjolnir.stabhawk;

import android.app.Application;


import com.mjolnir.stabhawk.Injection.DaggerDataComponent;
import com.mjolnir.stabhawk.Injection.DataComponent;
import com.mjolnir.stabhawk.Injection.DataModule;


/**
 * Created by samuel_chordas on 2/6/17.
 */

public class StabHawkApplication extends Application{

    private static StabHawkApplication app;

    DataComponent dataComponent;

    public static StabHawkApplication getApp(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;

        initDataComponent();

        dataComponent.inject(this);
    }

    private void initDataComponent(){
        dataComponent = DaggerDataComponent.builder()
                .dataModule(new DataModule(this))
                .build();
    }

    public DataComponent getDataComponent(){
        return dataComponent;
    }
}