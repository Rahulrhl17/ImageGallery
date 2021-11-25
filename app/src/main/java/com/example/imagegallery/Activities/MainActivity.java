package com.example.imagegallery.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.imagegallery.APIService.GetImageService;
import com.example.imagegallery.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    boolean doubleBackToExitPressedOnce = false;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.aboutmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,About.class);
        startActivity(intent);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            moveTaskToBack(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();
            }
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(getApplicationContext(), "Press again to close the App", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 3000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();

        recyclerView = findViewById(R.id.imagelist);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        getImageList();
    }


    private void getImageList(){
        GetImageService getImageService = new GetImageService(this);
        getImageService.getImage();
    }
}