package id.ac.amikom.a0060students.wahyudi.filemku;

import android.database.sqlite.SQLiteDatabase;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
    private ImageButton notification;


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

        image = f.getImgPoster();

        notification = (ImageButton) findViewById(R.id.notif);

        imgPoster=(ImageView) findViewById(R.id.coverFilem);
        Glide.with(getApplicationContext())
                .load(f.getImgPoster()).override(600,600).into(imgPoster);

        Log.d("",f.getImgPoster());
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into favorit(judul, tgl, ringkasan, image) values('" +
                        txtjudul.getText().toString() + "','" +
                        txttayang.getText().toString() + "','" +
                        txtRingkasan.getText().toString() + "','" +
                        image + "')");
                String toast = getString(R.string.toastberhasil);
                Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
                showNotif();
            }
        });



    }
    private void showNotif() {
        NotificationManager notificationManager;

        Intent mIntent = new Intent(this, FilemDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fromnotif", "notif");
        mIntent.putExtras(bundle);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setColor(getResources().getColor(R.color.colorAccent));
        builder.setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.favorite_i)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.favorite_i))
                .setTicker("Filem Favorit di tambahkan ")
                .setAutoCancel(true)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(Color.RED, 3000, 3000)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setContentTitle("Filemku")
                .setContentText("Filem Favorit telah di tambahkan ");

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(115, builder.build());


    }
}
