package com.example.myapplication.Controller;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.myapplication.Model.Sandwich;
import com.example.myapplication.R;
import com.example.myapplication.Vue.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SandwichController {

    private MainActivity view;
    private Context context;
    public List<Sandwich>   listSandwich;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public SandwichController(MainActivity mainActivity, Context context)
    {
        this.view = mainActivity;
        this.context = context;
    }

    public void showList(List<Sandwich> listSandwiches)
    {
        // use a linear layout manager
        //layoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(layoutManager);
        // specify an adapter (see also next example)
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView = recyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter(context, listSandwiches);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public void onCreate() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //On crée un objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/Dayenkai/sandwich/master/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //On crée notre instance de notre RestAPI Pokemon.
        RestSandwichApi restApi = retrofit.create(RestSandwichApi.class);


        Call<RestSandwichResponse> call = restApi.getAllSandwich();

        call.enqueue(new Callback<RestSandwichResponse>() {
            @Override
            public void onResponse(Call<RestSandwichResponse> call, Response<RestSandwichResponse> response) {
                RestSandwichResponse restFireEmblemResponse = response.body();
                listSandwich = restFireEmblemResponse.getSandwiches();
                showList(listSandwich);
                //System.exit(0);
            }

            @Override
            public void onFailure(Call<RestSandwichResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });

    }
}
