package com.mjolnir.stabhawk.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mjolnir.stabhawk.Data.Quote;
import com.mjolnir.stabhawk.R;
import com.mjolnir.stabhawk.Data.YQLResponse;

/**
 * Created by samuel_chordas on 2/6/17.
 */

public class MainViewHolder extends RecyclerView.ViewHolder {

    LinearLayout stockItem;
    TextView symbol;
    TextView bid;

    public MainViewHolder(View view){
        super(view);
        stockItem = (LinearLayout) view.findViewById(R.id.item_stock);
        symbol = (TextView) view.findViewById(R.id.symbol);
        bid = (TextView) view.findViewById(R.id.bid);
    }

    public void bind(Context context, Quote quote){
        symbol.setText(quote.getSymbol());
        bid.setText(quote.getLastTradePriceOnly());
    }

}
