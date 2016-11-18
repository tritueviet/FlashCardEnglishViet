package com.code.flashcardenglishviet.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.code.flashcardenglishviet.R;
import com.code.flashcardenglishviet.control.Controller;

public class ViewHelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_help);
        Controller.setActivitySave(ViewHelp.this);
//        new UtilsAds().addAds();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarHelp);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setBackgroundColor(getResources().getColor(R.color.xanhActionbar));
    }

    @Override
    protected void onResume() {
        Controller.setActivitySave(ViewHelp.this);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.empty_menu, menu);
        return true;
    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id) {
//            case R.id.action_settings:
//                Controller.getInstance().showSettings();
//                return true;
//            case R.id.help:
//                Controller.getInstance().showHelp();
//                return true;
//            case R.id.about:
//                Controller.getInstance().showAbout();
//                return true;
//            case R.id.exit:
//                Controller.getInstance().exitApp();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
