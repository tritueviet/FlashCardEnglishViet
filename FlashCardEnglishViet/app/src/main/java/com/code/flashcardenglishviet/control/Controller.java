package com.code.flashcardenglishviet.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.code.flashcardenglishviet.view.MainActivity;
import com.code.flashcardenglishviet.view.ViewAbout;
import com.code.flashcardenglishviet.view.ViewHelp;
import com.code.flashcardenglishviet.view.ViewSettings;


public class Controller {

    private static Controller controller = null;
    private static Activity activitySave = null;

    public static Controller getInstance() {
        if (controller == null) {
            return new Controller();
        }
        return controller;
    }

    public void showMainActivity() {
        log("--run-- main");
        Intent intent = new Intent(getActivitySave(), MainActivity.class);
        getActivitySave().startActivity(intent);
    }
    public void showAbout() {
        Intent intent = new Intent(getActivitySave(), ViewAbout.class);
        getActivitySave().startActivity(intent);
    }

    public void showHelp() {
        Intent intent = new Intent(getActivitySave(), ViewHelp.class);
        getActivitySave().startActivity(intent);
    }
    public void showSettings() {
        Intent intent = new Intent(getActivitySave(), ViewSettings.class);
        getActivitySave().startActivity(intent);
    }
    public void exitApp() {
        getActivitySave().moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

    }

    public static void log(String txt) {
        android.util.Log.v("log app: ", txt);
    }

    public static Activity getActivitySave() {
        return activitySave;
    }

    public static void setActivitySave(Activity activitySave) {
        Controller.activitySave = activitySave;
    }

    public static void toast(String s) {
        Toast.makeText(getActivitySave(),s,Toast.LENGTH_SHORT).show();
    }
    public static void toast2(int id) {
        Toast.makeText(getActivitySave(),getActivitySave().getResources().getString(id),Toast.LENGTH_SHORT).show();
    }
}
