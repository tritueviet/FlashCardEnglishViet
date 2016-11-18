package com.code.flashcardenglishviet;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.code.flashcardenglishviet.control.Controller;
import com.code.flashcardenglishviet.utils.UtilSharedPreferences;
import com.code.flashcardenglishviet.utils.UtilsSqlLiteDbHelper;
import com.code.flashcardenglishviet.utils.Var;
import com.code.flashcardenglishviet.utils.fuck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sev_user on 11/18/2016.
 */

public class LoadingScreen extends AppCompatActivity {
    private Context mContext;
    public static final int SDK_VERSION = Build.VERSION.SDK_INT;
    private static final int PEMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);
        mContext = this;
        Controller.setActivitySave(LoadingScreen.this);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();
        fuck.b[4] = 108;
        if (checkPermission() == false) {
            run();
        }
    }

    public void run() {
        new Downloader().execute();
    }

    public boolean checkPermission() {
        if (SDK_VERSION < 23) {
            return false;
        }
        List<String> permissionList = new ArrayList(Arrays.asList(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE));
        if (PackageManager.PERMISSION_GRANTED == checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            permissionList.remove(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (PackageManager.PERMISSION_GRANTED == checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            permissionList.remove(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (permissionList.size() > 0) {
            requestPermissions(permissionList.toArray(new String[permissionList.size()]), PEMISSION_REQUEST_CODE);
            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PEMISSION_REQUEST_CODE) {
            if (grantResults != null) {
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(mContext, "Permission: " + permissions[i] + " is denied", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        }
        run();
    }

    class Downloader extends AsyncTask<String, Boolean, Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        /**
         * Getting product details in background thread
         */
        protected Boolean doInBackground(String... params) {
            UtilsSqlLiteDbHelper utilsSqlLiteDbHelper = new UtilsSqlLiteDbHelper(Controller.getActivitySave());
            boolean copy = UtilSharedPreferences.loadBoolean(UtilSharedPreferences.SAVE_DATABASE_BOOLEAN, false);
            if (copy == false) {
                if (!utilsSqlLiteDbHelper.CopyDataBaseFromAsset()) {
                    UtilSharedPreferences.saveBoolean(false, UtilSharedPreferences.SAVE_DATABASE_BOOLEAN);
                    return false;
                }
            }
            UtilSharedPreferences.saveBoolean(true, UtilSharedPreferences.SAVE_DATABASE_BOOLEAN);
            Var.listWord = utilsSqlLiteDbHelper.getListWord();
            return true;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * *
         */
        protected void onPostExecute(Boolean kq) {
            if (kq == false) {
                finish();
            } else {
                Controller.getInstance().showMainActivity();
                finish();
            }
        }

    }
}
