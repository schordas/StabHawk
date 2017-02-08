package com.mjolnir.stabhawk.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjolnir.stabhawk.Data.Quote;
import com.mjolnir.stabhawk.R;
import com.mjolnir.stabhawk.Data.YQLResponse;

import java.util.ArrayList;

/**
 * Created by samuel_chordas on 2/6/17.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;

    private ArrayList<Quote> data = new ArrayList<>();

    public Adapter(Context context){
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stock, parent,
                false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MainViewHolder) holder).bind(context, data.get(position));
        Log.i(Adapter.class.getSimpleName(), "Symbol: " + data.get(position).getSymbol());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addItems(ArrayList<Quote> quotes){
        data.addAll(quotes);
        notifyDataSetChanged();
    }

    public void swapItems(ArrayList<Quote> quotes){
        data.clear();
        data.addAll(quotes);
        notifyDataSetChanged();
    }

    public Quote getItem(int position){
        return data.get(position);
    }
}
