package id.ac.amikom.a0060students.wahyudi.filemku;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class FilemDetailActivity extends AppCompatActivity {

    private TextView txtjudul;
    private TextView txtRingkasan;
    private  TextView txttayang;
    private ImageView imgPoster;
    DataHelper dbHelper;
    private Button favorite;
    private String image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filemdetailactivity);
        dbHelper = new DataHelper(this);


        Filem  f = (Filem) getIntent().getSerializableExtra("M");
        txtjudul=(TextView) findViewById(R.id.txtDetailJudul);
        txtjudul.setText(f.getTxtJudul());
        txtRingkasan= findViewById(R.id.txtRingkasanAll);
        txtRingkasan=(TextView)findViewById(R.id.txtRingkasanAll);
        txtRingkasan.setText(f.getTxtRingkasan());
        txttayang=(TextView) findViewById(R.id.txtdatatayang);
        txttayang.setText(f.gettayang());
        favorite = (Button) findViewById(R.id.favorit);
        image = f.getImgPoster();


        imgPoster=(ImageView) findViewById(R.id.coverFilem);
        Glide.with(getApplicationContext())
                .load(f.getImgPoster()).override(350,350).into(imgPoster);

        Log.d("",f.getImgPoster());

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into favorit(judul, tgl, ringkasan, image) values('" +
                        txtjudul.getText().toString() + "','" +
                        txttayang.getText().toString() + "','" +
                        txtRingkasan.getText().toString() + "','" +
                        image + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
            }
        });
    }
}
