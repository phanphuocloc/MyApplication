package e.acer.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Time extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TimeTable";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "TimeTable";
    private static final String ID = "_id";
    private static final String ghichu = "Ghi_chu";
    private static final String gio = "Gio";
    private static final String ngay_thang_nam = "date";

    ;

    public Time(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = " create table " + TABLE_NAME +
                "("+
                ID + " integer primary key autoincrement, " +
                ghichu + " text, " +
                gio + " text, " +
                ngay_thang_nam + " text, " +

                ")";
        sqLiteDatabase.execSQL(sql);
        ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }


    public void taotime(String ghichu, String gio, String ngay_thang_nam){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues noidung = new ContentValues();
        noidung.put(ghichu, String.valueOf(ghichu));
        noidung.put(gio, String.valueOf(gio));
        noidung.put(ngay_thang_nam, String.valueOf(ngay_thang_nam));

        String nullColumHack = null;
        db.insert(TABLE_NAME, nullColumHack, noidung);
    }
    public Cursor getAllTime(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor con_tro = db.rawQuery("select * from " + TABLE_NAME, null);
        return con_tro;
    }
    public boolean xoatime(String gio){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ngay_thang_nam + " = " +"'"+gio+"'",null)>0;
    }
    public  boolean suatime(String ghichu, String gio, String ngay_thang_nam){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues noidung = new ContentValues();
        noidung.put(ghichu, String.valueOf(ghichu));
        noidung.put(gio, String.valueOf(gio));
        noidung.put(ngay_thang_nam, String.valueOf(ngay_thang_nam));


        return db.update(TABLE_NAME,noidung,ngay_thang_nam+ " = " +"'"+gio+"'",null)>0;
    }

    public Time(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

}
