package com.dorizu.dicoding;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class DetailProfil extends AppCompatActivity {
    //tampilkan xml profil aja
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);

        ImageView btnBack = (ImageView) findViewById(R.id.back);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent backHome = new Intent(DetailProfil.this, MainActivity.class);
                startActivity(backHome);
            }
        });
    }
}
