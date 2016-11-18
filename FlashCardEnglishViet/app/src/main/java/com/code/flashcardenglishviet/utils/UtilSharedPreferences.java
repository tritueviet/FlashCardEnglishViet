package com.code.flashcardenglishviet.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import com.code.flashcardenglishviet.control.Controller;

public class UtilSharedPreferences {
	public static final String SAVE_DATABASE_BOOLEAN ="SAVE_DATABASE_BOOLEAN";
	public static final String AUTO_SPEAK_BOOLEAN ="AUTO_SPEAK_BOOLEAN";
	public static final String SPEAK_ONLINE_BOOLEAN ="SPEAK_ONLINE_BOOLEAN";
	public static final String SERVICE_TRANSLATE_BOOLEAN ="SERVICE_TRANSLATE_BOOLEAN";
	public static final String RUN_SERVICE_BOOLEAN ="RUN_SERVICE_BOOLEAN";
	public static final String DONT_DISPLAY_NEXT_BOOLEAN ="DONT_DISPLAY_NEXT_BOOLEAN";

	private static SharedPreferences pref = null;

	public static void saveConfig() {

		pref = PreferenceManager.getDefaultSharedPreferences(Controller.getActivitySave());
		Editor editor = pref.edit();
//		editor.putString("contactMe", Var.contactMe);
//		editor.putString("tabSelect", Var.tabShowDefault+"");
//		editor.putString("regIdGCM", Var.regIdGCM);
//		editor.putBoolean("autoOffDialogNumber", Var.isAutoNumberDialog);
//		editor.putBoolean("autoOffDialogString", Var.isAutoStringDialog);
		editor.commit();
	}

	public static void loadConfig() {

		pref = PreferenceManager.getDefaultSharedPreferences(Controller.getActivitySave());
//		Var.contactMe = pref.getString("contactMe", "");
//		Var.tabShowDefault = Integer.parseInt(pref.getString("tabSelect", "1"));
//		Var.regIdGCM = pref.getString("regIdGCM", "");
//		Var.isAutoNumberDialog=pref.getBoolean("autoOffDialogNumber",false);
//		Var.isAutoStringDialog=pref.getBoolean("autoOffDialogString",false);
		
	}
	public static String loadString(String name, String defaul) {
		pref = PreferenceManager.getDefaultSharedPreferences(Controller.getActivitySave());
		return pref.getString(name, defaul);
	}
	public static int loadInt(String name, int defaul) {
		pref = PreferenceManager.getDefaultSharedPreferences(Controller.getActivitySave());
		return pref.getInt(name, defaul);
	}
	public static boolean loadBoolean(String name, boolean defaul) {
		pref = PreferenceManager.getDefaultSharedPreferences(Controller.getActivitySave());
		return pref.getBoolean(name, defaul);
	}
	public static boolean loadBoolean(String name, boolean defaul, Context mContext) {
		pref = PreferenceManager.getDefaultSharedPreferences(mContext);
		return pref.getBoolean(name, defaul);
	}
	public static float loadFloat(String name, float defaul) {
		pref = PreferenceManager.getDefaultSharedPreferences(Controller.getActivitySave());
		return pref.getFloat(name, defaul);
	}
	public static void saveString(String value,String key) {
		pref = PreferenceManager.getDefaultSharedPreferences(Controller.getActivitySave());
		Editor editor = pref.edit();
		editor.putString(key, value);
		editor.commit();
	}
	public static void saveInt(int value,String key) {
		pref = PreferenceManager.getDefaultSharedPreferences(Controller.getActivitySave());
		Editor editor = pref.edit();
		editor.putInt(key, value);
		editor.commit();
	}
	public static void saveBoolean(boolean value,String key) {
		pref = PreferenceManager.getDefaultSharedPreferences(Controller.getActivitySave());
		Editor editor = pref.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
	public static void saveFloat(float value,String key) {
		pref = PreferenceManager.getDefaultSharedPreferences(Controller.getActivitySave());
		Editor editor = pref.edit();
		editor.putFloat(key, value);
		editor.commit();
	}
}
