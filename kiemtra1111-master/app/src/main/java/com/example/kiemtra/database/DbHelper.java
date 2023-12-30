package com.example.kiemtra.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "QLSanPham", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SanPham(MaSP INTEGER PRIMARY KEY AUTOINCREMENT, " + "TenSP TEXT, GiaTien REAL, Image TEXT)";
        db.execSQL(sql);
        String data = "INSERT INTO SanPham VALUES(1, 'Rau Salad', '13777', 'https://i-giadinh.vnecdn.net/2021/10/13/saladtron-1634096027-8296-1634096305.jpg')," +
                "(2, 'Pasta', '33000', 'https://www.advrider.com/wp-content/uploads/2021/03/20210303_160517-1200x1137.jpg')," +
                "(3, 'Pizza ', '61000', 'https://wallpaperaccess.com/full/2237015.jpg')";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(db);
        }
    }
}
