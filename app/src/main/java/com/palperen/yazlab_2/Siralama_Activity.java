package com.palperen.yazlab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Siralama_Activity extends AppCompatActivity {
    private ListView kullaniciListe;
    private Button siralamaGeri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siralama);
        kullaniciListe=findViewById(R.id.kullaniciListe);
        Veritabani veritabanı=new Veritabani(Siralama_Activity.this);
        List<String> Veriler =veritabanı.veriListele();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Siralama_Activity.this,android.R.layout.activity_list_item,android.R.id.text1,Veriler);
        kullaniciListe.setAdapter(adapter);
        siralamaGeri=findViewById(R.id.siralamaGeri);
        siralamaGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siralamaTogiris = new Intent(Siralama_Activity.this,Giris_Ekrani_Activity.class);
                startActivity(siralamaTogiris);
            }
        });
    }
}
