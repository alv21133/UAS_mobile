package id.ac.amikom.a0060students.wahyudi.filemku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FilemDetailActivity extends AppCompatActivity {

    private TextView txtjudul;
    private TextView txtRingkasan;
    private  TextView txttayang;
    private ImageView imgPoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filemdetailactivity);


        Filem  f = (Filem) getIntent().getSerializableExtra("M");
        txtjudul=(TextView) findViewById(R.id.txtDetailJudul);
        txtjudul.setText(f.getTxtJudul());
        txtRingkasan=(TextView)findViewById(R.id.txtRingkasanAll);
        txtRingkasan=(TextView)findViewById(R.id.txtRingkasanAll);
        txtRingkasan.setText(f.getTxtRingkasan());
        txttayang=(TextView) findViewById(R.id.txtdatatayang);
        txttayang.setText(f.gettayang());

        imgPoster=(ImageView) findViewById(R.id.coverFilem);
        Glide.with(getApplicationContext())
                .load(f.getImgPoster()).override(350,350).into(imgPoster);

        Log.d("",f.getImgPoster());

    }
}
