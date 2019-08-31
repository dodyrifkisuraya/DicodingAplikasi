package com.dorizu.dicoding;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailKelas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_kelas);
        //buat objek turunan kelas untuk mengambil intent
        final KelasDicoding kelasTangkap = getIntent().getParcelableExtra("key");

        //buat koneksi variabel dgn id di layout xml
        ImageView imgThumnail = (ImageView) findViewById(R.id.img_thumnail);
        TextView tvNama =(TextView) findViewById(R.id.tv_namaKelas);
        TextView tvPenyusun =(TextView)  findViewById(R.id.tv_penyusun);
        TextView tvBiaya =(TextView)  findViewById(R.id.tv_biaya);
        TextView tvDetailDiskripsi = (TextView) findViewById(R.id.tv_detailDiskripsi);
        ImageView imgDiskripsi = (ImageView) findViewById(R.id.img_detail);
        Button btnDaftar = (Button) findViewById(R.id.btn_daftar);
        ImageView btnBack = (ImageView) findViewById(R.id.back);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent backHome = new Intent(DetailKelas.this, MainActivity.class);
                startActivity(backHome);
            }
        });

        //fungsi klik pada button
        btnDaftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailKelas.this, "Berhasil Daftar Kelas "+kelasTangkap.getNama(),Toast.LENGTH_SHORT).show();
            }
        });

        //ambil data dari objek data kelasTangkap untuk di pasang di variabel yg terkoneksi ke xml
        Glide.with(this)
                .load(kelasTangkap.getThumnail())
                .apply(new RequestOptions().override(350, 550))
                .into(imgThumnail);
        Glide.with(this)
                .load(kelasTangkap.getPhotodiskripsi())
                .apply(new RequestOptions().override(350, 550))
                .into(imgDiskripsi);
        tvNama.setText(kelasTangkap.getNama());
        tvPenyusun.setText("Disusun Oleh : " + kelasTangkap.getPenyusun());
        tvBiaya.setText(kelasTangkap.getBiaya());
        tvDetailDiskripsi.setText(kelasTangkap.getDiskripsi());

    }
}
