package com.palperen.yazlab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Giris_Ekrani_Activity extends AppCompatActivity {
    private Button girisOyna;
    private Button girisSiralama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);
        girisOyna=findViewById(R.id.girisOyna);
        girisSiralama=findViewById(R.id.girisSiralama);
        girisOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent girisTokayit = new Intent(Giris_Ekrani_Activity.this, Kayit_Ekrani_Activity.class);
                startActivity(girisTokayit);
            }
        });
        girisSiralama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent girisToSiralama = new Intent(Giris_Ekrani_Activity.this,Siralama_Activity.class);
                startActivity(girisToSiralama);
            }
        });
    }
}
