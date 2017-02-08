package com.mjolnir.stabhawk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mjolnir.stabhawk.Data.Quote;
import com.mjolnir.stabhawk.Data.YQLResponse;
import com.mjolnir.stabhawk.RecyclerView.Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements StockViewModel.StockView{

    private Adapter adapter;
    private RecyclerView recyclerView;

    private ArrayList<Quote> quotes = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        initRecyclerView();

        StockViewModel stockViewModel;
        stockViewModel = new StockViewModel(this);

        stockViewModel.networkCall(getResources().getString(R.string.YQL) + " " +
                "(\"YHOO\",\"AAPL\",\"GOOG\",\"MSFT\")");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.addItems(quotes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initRecyclerView(){
        adapter = new Adapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    public void getData(ArrayList<Quote> quotes){
        this.quotes = quotes;
        adapter.swapItems(quotes);
    }
}
