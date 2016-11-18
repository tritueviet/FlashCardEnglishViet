package com.code.flashcardenglishviet.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.code.flashcardenglishviet.R;
import com.code.flashcardenglishviet.control.Controller;

public class ViewAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_about);
        Controller.setActivitySave(ViewAbout.this);
//        new UtilsAds().addAds();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAbout);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setBackgroundColor(getResources().getColor(R.color.xanhActionbar));
    }

    @Override
    protected void onResume() {
        Controller.setActivitySave(ViewAbout.this);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.empty_menu, menu);
        return true;
    }
}
