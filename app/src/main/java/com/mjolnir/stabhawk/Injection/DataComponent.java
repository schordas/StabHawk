package com.mjolnir.stabhawk.Injection;

import com.mjolnir.stabhawk.Network.StockData;
import com.mjolnir.stabhawk.StabHawkApplication;
import com.mjolnir.stabhawk.StockViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by samuel_chordas on 2/6/17.
 */

@Singleton
@Component(modules = {DataModule.class})

public interface DataComponent {

    void inject(StabHawkApplication stabHawkAppliation);

    void inject(StockData stockData);

    void inject(StockViewModel stockViewModel);

}
