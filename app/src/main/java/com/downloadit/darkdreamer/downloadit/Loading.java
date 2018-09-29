package com.downloadit.darkdreamer.downloadit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Loading extends AppCompatActivity {

    TextView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        loading=findViewById(R.id.loading);
        loading.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Loading.this,home_page.class);
                startActivity(i);
            }
        },2000);
    }
}
