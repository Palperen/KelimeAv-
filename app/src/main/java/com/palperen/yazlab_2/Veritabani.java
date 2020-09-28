package com.palperen.yazlab_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {
    private static final String tableName="Oyuncular";
    private static final String databaseName="VeriTabani";
    private static final int databaseVersion=1;
    private static final String oyuncuAdi="OyuncuAdı";
    private static final String oyuncuPuan="OyuncuPuan";

    public Veritabani(@Nullable Context context) {
        super(context, databaseName, null, databaseVersion);
    }
    SQLiteDatabase sqLiteDatabase;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tableName+" (id INTEGER PRIMARY KEY AUTOINCREMENT,"+oyuncuAdi+" TEXT,"+oyuncuPuan+" INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE İF EXISTS "+tableName);
        this.onCreate(db);
    }
    public void veriEkle(String ad){
        int puan=0;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(oyuncuAdi,ad.trim());
        cv.put(oyuncuPuan,puan);
        long r=db.insert(tableName,null,cv);
        if(r>-1)
            Log.i("tag","İşlem Başarılı");
        else
            Log.e("tag","İşlem Başarısız");
        db.close();
    } public void puanUpdate(String ad,int puan){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        //cv.put(oyuncuAdi,ad.trim());
        cv.put(oyuncuPuan,puan);
        db.update(tableName, cv, "OyuncuAdı=?",new String[]{ad});
       /* long r=db.insert(tableName,null,cv);
        if(r>-1)
            Log.i("tag","İşlem Başarılı");
        else
            Log.e("tag","İşlem Başarısız");*/
        db.close();
    }

    public List<String> veriListele(){
        List<String> veriler=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        String[] sutunlar={oyuncuAdi,oyuncuPuan};
        Cursor cr=db.query(tableName,sutunlar,null,null,null,null,oyuncuPuan+" DESC");
        while(cr.moveToNext()){
            veriler.add(cr.getString(0)+"-"+cr.getString(1));
        }
        return veriler;
    }
}
