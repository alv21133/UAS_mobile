package id.ac.amikom.a0060students.wahyudi.filemku;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardFilemAdapter extends RecyclerView.Adapter<CardFilemAdapter.CardViewHolder> {

    private ArrayList<Filem> filems;
    private Context context;

    public CardFilemAdapter(Context context){
        this.context = context;
    }
    public ArrayList<Filem> getFilems() {
        return filems;
    }

    public void setMovies(ArrayList<Filem> filems) {
        this.filems = filems;
    }
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.daftar_filem, viewGroup, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int i) {
        final Filem m = getFilems().get(i);

        Glide.with(context)
                .load(m.getImgPoster())
                .override(350, 350)
                .into(cardViewHolder.imgPoster);

        cardViewHolder.txtJudul.setText(m.getTxtJudul());
        String Ringkasan = m.getTxtRingkasan();
        if(Ringkasan.length() >= 100){
            Ringkasan = m.getTxtRingkasan().substring(0, 100) + "... ";
        }
        cardViewHolder.txtRingkasan.setText(Ringkasan);

        cardViewHolder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FilemDetailActivity.class);
                intent.putExtra("M" ,m);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getFilems().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPoster;
        TextView txtJudul, txtRingkasan;
        Button btnDetail;

        public CardViewHolder(View view) {
            super(view);
            imgPoster = (ImageView)itemView.findViewById(R.id.imgPoster);
           txtJudul = (TextView)itemView.findViewById(R.id.txtJudul);
            txtRingkasan = (TextView)itemView.findViewById(R.id.txtRingkasan);
            btnDetail = (Button)itemView.findViewById(R.id.btnDetail);

        }
    }

}
