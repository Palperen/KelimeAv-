package com.palperen.yazlab_2.seviye_1;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.palperen.yazlab_2.Giris_Ekrani_Activity;
import com.palperen.yazlab_2.R;
import com.palperen.yazlab_2.Veritabani;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Seviye_1_1_Activity extends AppCompatActivity {
    private Chronometer kronometre;
    private Button button,button2,button3,button4,gonder_1_1,karistir_1_1,geri;
    private TextView text_1_1,textS,textA,textL;
    private int yanlis_cevap;
    private int i=0;
    private boolean button_c=false;
    private boolean button2_c=false;
    private boolean button3_c=false;
    private boolean button4_c=false;
    private String cevap_1_1="";
    private String kelime1="SAL";
    private List<String> harfler_1_1 = Arrays.asList("S", "A", "L", "B");
    private long time;
    private int puan;
    Veritabani veritabani =new Veritabani(Seviye_1_1_Activity.this);
    String name;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye_1_1);
        Intent gelenOyuncuName=getIntent();
        name= (String) gelenOyuncuName.getSerializableExtra("oyuncuName");
        kronometre=findViewById(R.id.kronometre);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        gonder_1_1=findViewById(R.id.gonder_1_1);
        karistir_1_1=findViewById(R.id.karistir_1_1);
        geri=findViewById(R.id.geri);
        text_1_1=findViewById(R.id.seviye_1_text);
        textS=findViewById(R.id.textS);
        textA=findViewById(R.id.textA);
        textL=findViewById(R.id.textL);
        yanlis_cevap=0;
        Collections.shuffle(harfler_1_1);
        button.setText(harfler_1_1.get(0));
        button2.setText(harfler_1_1.get(1));
        button3.setText(harfler_1_1.get(2));
        button4.setText(harfler_1_1.get(3));
        kronometre.start();
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geri_2_1togiris=new Intent(Seviye_1_1_Activity.this, Giris_Ekrani_Activity.class);
                startActivity(geri_2_1togiris);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button_c==false){
                    cevap_1_1 = cevap_1_1 +button.getText();
                    text_1_1.setText(cevap_1_1);
                    button_c=true;
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button2_c==false){
                    cevap_1_1 = cevap_1_1 +button2.getText();
                    text_1_1.setText(cevap_1_1);
                    button2_c=true;
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button3_c==false){
                    cevap_1_1 = cevap_1_1 +button3.getText();
                    text_1_1.setText(cevap_1_1);
                    button3_c=true;
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button4_c==false){
                    cevap_1_1 = cevap_1_1 +button4.getText();
                    text_1_1.setText(cevap_1_1);
                    button4_c=true;
                }
            }
        });
        gonder_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cevap_1_1.equalsIgnoreCase(kelime1)){
                    textS.setText("S");
                    textA.setText("A");
                    textL.setText("L");
                    kronometre.stop();
                    time=SystemClock.elapsedRealtime()-kronometre.getBase();
                    puan=(int)(100-((time/1000)*yanlis_cevap));
                    veritabani.puanUpdate(name,puan);
                    Intent seviye_1_1To1_2 = new Intent(Seviye_1_1_Activity.this, Seviye_1_2_Activity.class);
                    seviye_1_1To1_2.putExtra("oyuncuName",name);
                    seviye_1_1To1_2.putExtra("puan",puan);
                    startActivity(seviye_1_1To1_2);
                }else{
                    yanlis_cevap++;
                }
                button_c=false;
                button2_c=false;
                button3_c=false;
                button4_c=false;
                cevap_1_1 ="";
                text_1_1.setText("");
            }
        });
        karistir_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(harfler_1_1);
                button.setText(harfler_1_1.get(0));
                button2.setText(harfler_1_1.get(1));
                button3.setText(harfler_1_1.get(2));
                button4.setText(harfler_1_1.get(3));
            }
        });



    }

}
