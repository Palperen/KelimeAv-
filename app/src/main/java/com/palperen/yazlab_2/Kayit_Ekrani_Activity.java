package com.palperen.yazlab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.palperen.yazlab_2.seviye_1.Seviye_1_1_Activity;


public class Kayit_Ekrani_Activity extends AppCompatActivity {
    private Button kayitBasla;
    private Button kayitGeri;
    private EditText kullaniciAdi;
    public Oyuncu oyuncu;
    public Veritabani veritabani;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ekrani);
        kayitBasla=findViewById(R.id.kayitBasla);
        kullaniciAdi=findViewById(R.id.kullaniciAdi);
        kayitGeri=findViewById(R.id.kayitGeri);
        kayitBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                oyuncu = new Oyuncu(kullaniciAdi.getText().toString());
                oyuncu.setOyuncuPuan(0);
                veritabani =new Veritabani(Kayit_Ekrani_Activity.this);
                veritabani.veriEkle(kullaniciAdi.getText().toString());
                Intent kayitToseviye_1_1 = new Intent(Kayit_Ekrani_Activity.this, Seviye_1_1_Activity.class);
                kayitToseviye_1_1.putExtra("oyuncuName", oyuncu.getOyuncuAd());
                startActivity(kayitToseviye_1_1);
            }
        });
        kayitGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kayitTogiris = new Intent(Kayit_Ekrani_Activity.this,Giris_Ekrani_Activity.class);
                startActivity(kayitTogiris);
            }
        });
    }
}
