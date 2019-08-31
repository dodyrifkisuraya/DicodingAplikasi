package com.dorizu.dicoding;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    //deklarasi variabel
    private RecyclerView rvKelas;
    private ArrayList<KelasDicoding> cardlist ;

//    //custom method untuk menampilkan menu profil di actionbar
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.profilku, menu);
//        return true;
//    }
//    //custom method klik menu untuk pindah layout
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.profil:
//                Intent pindahProfil = new Intent(this, DetailProfil.class);
//                startActivity(pindahProfil);
//                return true;
//        }
//        return false;
//    }
    //custom method tampilan utama(Home) aplikasi
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.logo);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CircleImageView btnProfil = (CircleImageView) findViewById(R.id.btnProfil);
        btnProfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent pindahProfil = new Intent(MainActivity.this, DetailProfil.class);
                startActivity(pindahProfil);
            }
        });

        rvKelas = (RecyclerView) findViewById(R.id.rv_kelas);
        rvKelas.setHasFixedSize(true);

        cardlist = new ArrayList<>();
        cardlist.addAll(KelasData.getListData());
        showCardView();
    }

    //method tampilkan recycleView
    private void showCardView() {
        rvKelas.setLayoutManager(new LinearLayoutManager(this)); //set posisi view di rvKelas
        CardViewKelasAdapter listCardAdapter = new CardViewKelasAdapter(this); //buat turunan kelas adapter
        listCardAdapter.setListKelas(cardlist); // masukan cardlist ke adapter
        rvKelas.setAdapter(listCardAdapter); // pasang adapter ke layout xml-> rvKelas
    }

}
