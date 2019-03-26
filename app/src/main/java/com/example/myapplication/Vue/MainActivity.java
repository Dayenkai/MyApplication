package com.example.myapplication.Vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Controller.MyAdapter;
import com.example.myapplication.Controller.SandwichController;
import com.example.myapplication.Model.Sandwich;
import com.example.myapplication.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TOTAL_COUNT = "total_count";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SandwichController  controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new SandwichController(this, this);
        controller.onCreate();
        recyclerView = findViewById(R.id.my_recycler_view);
        /*LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter(this, controller.listSandwich);
        recyclerView.setAdapter(mAdapter);
        /*TonAdapter adapter = new tonAdapter();
        recyclerView.setAdapter(adapter);*/

        /*if (controller.listSandwich == null)
            System.exit(0);*/
        //mAdapter = new MyAdapter(this, controller.listSandwich);
        //recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //recyclerView.setAdapter(mAdapter);
        /*layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // specify an adapter (see also next example)
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);
        //showList(controller.listSandwich);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView

        /*MyAdapter adapter = new MyAdapter(this, controller.listSandwich);
        recyclerView.setAdapter(adapter);
        recyclerView.set*/
        /*ImageView button = findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*
                I want when I press the button
                The items are called
             */
               // Toast myToast = Toast.makeText(this, controller.listSandwich.get(1).getProvenance(), Toast.LENGTH_SHORT);
                //myToast.show();
                //showCountTextView.setText(controller.listSandwich.get(1).getProvenance());
                //Toast myToast = Toast.makeText(this, "Hello Toast!",
                //        Toast.LENGTH_SHORT);
                //myToast.show();
                /*controller.listSandwich.get(1).getName();
                controller.listSandwich.get(1).getPrix();
                controller.listSandwich.get(1).getProvenance();
*/
                // do whatever you want with them

            //}
        //});
    }

    /*public void second(View view) {

        ImageView button = findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*
                I want when I press the button
                The items are called
             */
          //      TextView tvSSID = (TextView) findViewById(R.id.textViewSSID);
            //    tvSSID.setText(controller.listSandwich.get(0).getProvenance());
                /*shops.get(1).getWood();
                shops.get(1).getMetal();*/

                // do whatever you want with them

            //}

        //});
        //showCountTextView.setText("lol");
        /*TextView randomView = (TextView)
                findViewById(R.id.textview_random);

        TextView headingView = (TextView)
                findViewById(R.id.textview_label);*/
        /*TextView showCountTextView =
                (TextView) findViewById(R.id.textView);*/
        //Toast myToast = Toast.makeText(this,  controller.listSandwich.get(1).getProvenance(),
          //      Toast.LENGTH_SHORT);
        //myToast.show();
        /*Intent randomIntent = new Intent(this, SecondActivity.class);
        startActivity(randomIntent);*/

        /*int count = getIntent().getIntExtra(TOTAL_COUNT, 0);

        Random random = new Random();
        int randomInt = 0;
        if (count > 0) {
            randomInt = random.nextInt(count);

        }
        randomView.setText(Integer.toString(randomInt));
        headingView.setText(getString(R.string.random_heading, count));*/

    ///}


   /* public void showList(List<Sandwich> listSandwiches)
    {
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // specify an adapter (see also next example)
        recyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter(this, listSandwiches);
        recyclerView.setAdapter(mAdapter);
    }*/

    public void toastMe(View view){
        // Toast myToast = Toast.makeText(this, message, duration);
        Toast myToast = Toast.makeText(this,  controller.listSandwich.get(3).getProvenance(),
                Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void countMe (View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textView);
        String countString = showCountTextView.getText().toString();
        Integer count = Integer.parseInt(countString);
        count++;
        showCountTextView.setText(count.toString());
    }
    public void subMe (View view) {

        TextView showCountTextView =
                (TextView) findViewById(R.id.textView);
        String countString = showCountTextView.getText().toString();
        Integer count = Integer.parseInt(countString);
        count--;
        showCountTextView.setText(count.toString());
    }

        public void randomMe(View view)
    {
        Intent randomIntent = new Intent(this, SecondActivity.class);
        TextView showCountTextView =
                (TextView) findViewById(R.id.textView);
        String countString = showCountTextView.getText().toString();
        Integer count = Integer.parseInt(countString);
        randomIntent.putExtra(TOTAL_COUNT, count);
        startActivity(randomIntent);
    }
    /*public void launchSecondActivity(View view)
    {
        Intent randomIntent = new Intent(this, SecondActivity.class);
        TextView showCountTextView =
                (TextView) findViewById(R.id.textView);
        String countString = showCountTextView.getText().toString();
    }*/
}
