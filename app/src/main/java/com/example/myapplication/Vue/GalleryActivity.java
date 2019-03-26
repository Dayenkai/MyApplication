package com.example.myapplication.Vue;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.Sandwich;
import com.example.myapplication.R;
import com.google.gson.Gson;

public class GalleryActivity extends AppCompatActivity {
    private static  final   String  image_name = "image_name";
    private static  final   String  image_url = "image_url";

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate started.");
    }

    private void getIncomingEvent(){
        if(getIntent().hasExtra(image_name) && getIntent().hasExtra(image_url)){
            String img_name = getIntent().getStringExtra(image_name);
            String img_url = getIntent().getStringExtra(image_url);
            Log.d(TAG, "getIncomingEvent: "+"Le nom de l'image est "+image_name);
            setImage(img_name, img_url);
        }
       // String sessionId= getIntent().getStringExtra((Constants.KEY))

    }

    private void setImage(String imageUrl, String imageName){

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);
        ImageView image = findViewById(R.id.imageView);
        /*Gson gson = new Gson();
        String jeej = getIntent().getStringExtra("image_name");
        Sandwich miam = gson.fromJson(jeej, Sandwich.class);
        name.setText(jeej);*/
        Glide.with(this)
                .load(imageUrl)
                .into(image);
    }
}
