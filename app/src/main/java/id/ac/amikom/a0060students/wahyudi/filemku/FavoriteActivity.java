package id.ac.amikom.a0060students.wahyudi.filemku;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by JamesAndrew on 12/31/2018.
 */

public class FavoriteActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    public String[] judul;
    public String[] ringkasan;
    public String[] image;
    ListView simpleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);

        dbHelper = new DataHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM favorit",null);
        judul = new String[cursor.getCount()];
        ringkasan = new String[cursor.getCount()];
        image = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            judul[cc] = cursor.getString(1).toString();
            ringkasan[cc] = cursor.getString(3).toString();
            image[cc] = cursor.getString(4).toString();
        }
        Log.d("Data", "onCreate: " + judul + ringkasan + image);
        simpleList = (ListView) findViewById(R.id.rv_category);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), judul,ringkasan,image);
        simpleList.setAdapter(customAdapter);
    }


}
