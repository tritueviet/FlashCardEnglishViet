package com.code.flashcardenglishviet.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.code.flashcardenglishviet.control.Controller;
import com.code.flashcardenglishviet.model.Word;

/**
 * Created by Wall on 11/5/2015.
 */


public class UtilsSqlLiteDbHelper extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_PATH = "/data/data/";
    // Database Name
    private static String DATABASE_NAME = "allvoca.db";
    // Contacts table name
    private static final String TABLE_WORD = "Vocas";
    private static final String TABLE_VOCABULARY = "vocabulary";
    private static final String TABLE_CAMPAIGN = "campaign";
    private SQLiteDatabase db;
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "word";
    private static final String KEY_CONTENT = "content";

    Context mContext;

    public UtilsSqlLiteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
//        this.getReadableDatabase();
        DATABASE_PATH = "/data/data/" + mContext.getPackageName() + "/databases";
//        Log.e("app", "->>>: " + DATABASE_PATH);
    }
//    public boolean insertDataWord(Word word) {
//        SQLiteDatabase database = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("content", word.getContent());
//        values.put("word", word.getWord());
//        database.insert(TABLE_WORD, null, values);
//        return true;
//    }
//    public boolean updateDataWord(Word word) {
//        SQLiteDatabase database = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("content", word.getContent());
//        values.put("word", word.getWord());
//        database.update(TABLE_WORD, values, "word" + " = ?", new String[]{word.getWord()});
//        return true;
//    }
    public boolean updateLearnedTopic(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("learned", 1);
        database.update(TABLE_VOCABULARY, values, "id" + " = ?", new String[]{id+""});
        return true;
    }
//--------------------------------------------------------------------------------------------------
    public boolean updateResultUser(int id, String result) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("result", result);
        database.update(TABLE_CAMPAIGN, values, "id" + " = ?", new String[]{id+""});
        return true;
    }
    public boolean updateIsFight(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("isFight", 1);
        database.update(TABLE_CAMPAIGN, values, "id" + " = ?", new String[]{id+""});
        return true;
    }
    public boolean clearIsFight(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("isFight", 0);
        database.update(TABLE_CAMPAIGN, values, "id" + " = ?", new String[]{id+""});
        return true;
    }
    public ArrayList<Word> getListWord(){
        Controller.log("-----------run getListWord ------------");
        ArrayList<Word> list=new ArrayList<Word>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql="SELECT * FROM Vocas";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Word word = new Word();
                word.setId(cursor.getString(0));
                word.setTen(cursor.getString(1));
                word.setDanhVan(cursor.getString(2));
                word.setTuLoai(cursor.getString(3));
                try {
                    String s = fuck.decodeText(cursor.getString(4));
                    word.setAudio(s);
                } catch (Exception e){
                }
                try {
                    String s = fuck.decodeText(cursor.getString(5));
                    word.setAnh(s);
                } catch (Exception e){
                }
                word.setNghia(cursor.getString(6));
                try {
                    String s = fuck.decodeText(cursor.getString(7));
                    word.setViDu(s);
                } catch (Exception e){
                }
                try {
                    word.setDungKhiNao(cursor.getString(8));
                } catch (Exception e){
                }
                list.add(word);
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
            cursor= null;
            db= null;
            System.gc();
        }
        Controller.log("size getListWord: "+list.size());
        return list;
    }
//--------------------------------------------------------------------------------------------------
//    public Word getDataWord(String name) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_WORD, new String[]{KEY_ID,
//                        KEY_NAME, KEY_CONTENT}, KEY_NAME + "=?",
//                new String[]{name}, null, null, null, null);
//        if (cursor != null && cursor.moveToFirst()) {
//            Word word = new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
//            word.xuat();
//            cursor.close();
//            db.close();
//            return word;
//        }
//        return null;
//    }
//    public Word getDataWord2(String name) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String sql="SELECT * FROM en_vi_basic where word =?";
//        Cursor cursor = db.rawQuery(sql, new String[] { name });
//
//        if (cursor != null && cursor.moveToFirst()) {
//            Word word = new Word(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
//            word.xuat();
//            cursor.close();
//            db.close();
//            return word;
//        }
//        return null;
//    }
    public ArrayList<String> getListWord(String name){
        ArrayList<String> list=new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql="SELECT word FROM en_vi_basic where word like '%"+name+"%'";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
            cursor= null;
            db= null;
        }

        return list;
    }
    public ArrayList<String> getAllWord(){
        ArrayList<String> list=new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql="SELECT word FROM en_vi_basic";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                // Toast.makeText(ViewMainActivity.this,
                // "Number Table => " + cursor.getCount() + "",
                // Toast.LENGTH_LONG).show();
                list.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
            cursor= null;
            db= null;
        }

        return list;
    }
//    public ArrayList<WordVocabulary> getAllTopicWithID(int id){
//        ArrayList<WordVocabulary> list=new ArrayList<WordVocabulary>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql="SELECT * FROM vocabulary WHERE topicId="+id;
//        Cursor cursor = db.rawQuery(sql, null);
//
//        if (cursor.moveToFirst()) {
//            while (!cursor.isAfterLast()) {
//                WordVocabulary wordVocabulary= new WordVocabulary(0);
//                wordVocabulary.setId(cursor.getInt(0));
//                wordVocabulary.setTopicId(id);
//                wordVocabulary.setWord(cursor.getString(1));
//                wordVocabulary.setPronounce(cursor.getString(2));
//                wordVocabulary.setLearned(cursor.getInt(3));
//                wordVocabulary.setTranslation(cursor.getString(4));
//                wordVocabulary.setExample(cursor.getString(5));
//                list.add(wordVocabulary);
//                cursor.moveToNext();
//            }
//        }
//
//        return list;
//    }
    public ArrayList<String> getAllGrammar(){
        ArrayList<String> list=new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql="SELECT title FROM theory";
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                // Toast.makeText(ViewMainActivity.this,
                // "Number Table => " + cursor.getCount() + "",
                // Toast.LENGTH_LONG).show();
                list.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
            cursor= null;
            db= null;
        }

        return list;
    }
    public boolean CopyDataBaseFromAsset() {
        try {
            String outputFileName = DATABASE_PATH + "/" + DATABASE_NAME;
//            Log.e("output file", outputFileName);

            File checkExists = new File(outputFileName);
            if (!checkExists.exists()) {
                InputStream in = mContext.getAssets().open("db/" + DATABASE_NAME);
//                Log.e("sample", "Starting copying");
                File databaseFile = new File(DATABASE_PATH);
                // check if databases folder exists, if not create one and its subfolders
                if (!databaseFile.exists()) {
                    databaseFile.mkdir();
                }

                OutputStream out = new FileOutputStream(outputFileName);

                byte[] buffer = new byte[1024];
                int length;

                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
//                Log.e("sample", "Completed");
                databaseFile = null;
                out.flush();
                out.close();
                in.close();
                return true;
            } else {
//                Log.e("sample", "dacopy");
            }
        } catch (Exception e) {
//            Log.e("sample", "loi");
            e.printStackTrace();
        }

        return false;
    }


//    public boolean openDataBase() {
//        try {
//            String path = DATABASE_PATH + "/" + DATABASE_NAME;
//            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
//            return true;
//        } catch (Exception e) {
//        }
//        return false;
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
}
