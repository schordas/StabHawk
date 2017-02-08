package com.mjolnir.stabhawk.Data;

import android.os.Parcel;
import android.os.Parcelable;

import com.mjolnir.stabhawk.Data.Query;

import java.util.ArrayList;

/**
 * Created by samuel_chordas on 2/6/17.
 */

public class YQLResponse {
    Query query;

    public Query getQuery(){
        return query;
    }


}
