package com.downloadit.darkdreamer.downloadit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class home_page extends AppCompatActivity {

    ListView items;
    int[] pic=new int[]{R.drawable.instagram,R.drawable.facebook,R.drawable.songs};
    String[] names=new String[]{"INSTAGRAM","FACEBOOK","SONGS"};
    homePageAdapter adapter;
    FloatingActionButton floatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        reqPer();
        items=findViewById(R.id.list_item);
        adapter=new homePageAdapter(this,names,pic);
        items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = String.valueOf(adapter.getItemName(position));
                Toast.makeText(home_page.this, name, Toast.LENGTH_LONG).show();
                try {
                    Class path = Class.forName("com.downloadit.darkdreamer.downloadit."+name);
                    Intent intent=new Intent(home_page.this,path);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(home_page.this,"ERROR:"+e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

        floatingActionButton = findViewById(R.id.contactus);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(home_page.this,ContactUS.class);
                startActivity(i);
            }
        });
        items.setAdapter(adapter);

    }


    public void reqPer(){
        String[] permissions=new String[]{Manifest.permission.INTERNET,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION};
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            requestPermissions(permissions,1001);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1001:
                for(int gres:grantResults){
                    gres=PackageManager.PERMISSION_GRANTED;
                }
                break;
            default:
                break;
        }
    }
}
