package com.dorizu.dicoding;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class CardViewKelasAdapter extends RecyclerView.Adapter<CardViewKelasAdapter.CardViewHolder> {

    //deklarasi variabel
    private ArrayList<KelasDicoding> listKelas;
    private Context context;

    //deklarasi bahwa value dari variabel context menyesuaikan kontext yg ada di parameter fungsi CardViewKelasAdapter
    public CardViewKelasAdapter(Context context){this.context = context;}

    //deklaasi arraylist buat tampung data kelas
    public ArrayList<KelasDicoding> getListKelas(){ return listKelas; }

    // fungsi memasukan list
    public void setListKelas(ArrayList<KelasDicoding> listKelas){this.listKelas = listKelas;}

    // buat fungsi holder yg dimasukan ke layout xml
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_kelas,viewGroup, false);
        return new CardViewHolder(view);
    }

    // pasang ke holder
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int posisi) {
        //buat turunan kelas untuk ambil list beserta posisinya
        final KelasDicoding kelasini = getListKelas().get(posisi);
        //ambil data dari KelasData.class kemudian di set ke holdernya
        Glide.with(context)
                .load(kelasini.getThumnail())
                .apply(new RequestOptions().override(350,550))
                .into(cardViewHolder.imgThumnail);
        cardViewHolder.tvNama.setText(kelasini.getNama());
        cardViewHolder.tvPenyusun.setText("Penyusun : "+kelasini.getPenyusun());
        cardViewHolder.tvThumnailDiskripsi.setText(kelasini.getThumnailDiskripsi());
        cardViewHolder.tvBiaya.setText(kelasini.getBiaya());
        cardViewHolder.kelas = kelasini;
    }

    // fungsi ambil ukuran banyaknya list
    @Override
    public int getItemCount() {
        return getListKelas().size();
    }

    // deklarasi Holder tiap list data kelas
    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgThumnail;
        TextView tvNama, tvPenyusun, tvThumnailDiskripsi, tvBiaya;
        CardView btnDetail;
        KelasDicoding kelas;

        public CardViewHolder(View itemView) {
            super(itemView);
            imgThumnail = (ImageView) itemView.findViewById(R.id.img_thumnail);
            tvNama =(TextView) itemView.findViewById(R.id.tv_namaKelas);
            tvPenyusun =(TextView)  itemView.findViewById(R.id.tv_penyusun);
            tvThumnailDiskripsi =(TextView)  itemView.findViewById(R.id.tv_Thumnail_diskripsi);
            tvBiaya =(TextView)  itemView.findViewById(R.id.tv_biaya);
            btnDetail = (CardView) itemView.findViewById(R.id.cardview);
            btnDetail.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Intent bawaData = new Intent(context, DetailKelas.class);
            bawaData.putExtra("key", kelas);
            context.startActivity(bawaData);
        }
    }
}
