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

public class Seviye_1_2_Activity extends AppCompatActivity {
    private Chronometer kronometre;
    private Button button_1_2,button2_1_2,button3_1_2,button4_1_2,gonder_1_2,karistir_1_2,geri;
    private TextView text_1_2,text_sal_S,textA_1_2,text_sal_L,text_bal_L,text_bal_B;
    private int yanlis_cevap;
    private int dogru_cevap;
    private int i=0;
    private boolean button_1_2_c=false;
    private boolean button2_1_2_c=false;
    private boolean button3_1_2_c=false;
    private boolean button4_1_2_c=false;
    private boolean iskelime1=false;
    private boolean iskelime2=false;
    private String cevap_1_2="";
    private String kelime1="SAL";
    private String kelime2="BAL";
    private List<String> harfler_1_2 = Arrays.asList("S", "A", "L", "B");
    private int puan;
    private long time;
    Veritabani veritabani =new Veritabani(Seviye_1_2_Activity.this);
    String name;
    int gelenPuan;
    int totalPuan;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye_1_2);
        Intent gelenOyuncuName=getIntent();
        name= (String) gelenOyuncuName.getSerializableExtra("oyuncuName");
        gelenPuan=(int)gelenOyuncuName.getSerializableExtra("puan");
        kronometre=findViewById(R.id.kronometre);
        button_1_2=findViewById(R.id.button_1_2);
        button2_1_2=findViewById(R.id.button2_1_2);
        button3_1_2=findViewById(R.id.button3_1_2);
        button4_1_2=findViewById(R.id.button4_1_2);
        gonder_1_2=findViewById(R.id.gonder1_2);
        karistir_1_2=findViewById(R.id.karistir1_2);
        geri=findViewById(R.id.geri);
        text_1_2=findViewById(R.id.seviye_2_text);
        text_sal_S=findViewById(R.id.text_sal_S);
        text_sal_L=findViewById(R.id.text_sal_L);
        textA_1_2=findViewById(R.id.textA_1_2);
        text_bal_B=findViewById(R.id.text_bal_B);
        text_bal_L=findViewById(R.id.text_bal_L);
        yanlis_cevap=0;
        dogru_cevap=0;
        Collections.shuffle(harfler_1_2);
        button_1_2.setText(harfler_1_2.get(0));
        button2_1_2.setText(harfler_1_2.get(1));
        button3_1_2.setText(harfler_1_2.get(2));
        button4_1_2.setText(harfler_1_2.get(3));
        kronometre.start();
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geri_2_1togiris=new Intent(Seviye_1_2_Activity.this, Giris_Ekrani_Activity.class);
                startActivity(geri_2_1togiris);
            }
        });
        button_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button_1_2_c==false){
                    cevap_1_2 = cevap_1_2 +button_1_2.getText();
                    text_1_2.setText(cevap_1_2);
                    button_1_2_c=true;
                }
            }
        });
        button2_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button2_1_2_c==false){
                    cevap_1_2 = cevap_1_2 +button2_1_2.getText();
                    text_1_2.setText(cevap_1_2);
                    button2_1_2_c=true;
                }
            }
        });
        button3_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button3_1_2_c==false){
                    cevap_1_2 = cevap_1_2 +button3_1_2.getText();
                    text_1_2.setText(cevap_1_2);
                    button3_1_2_c=true;
                }
            }
        });
        button4_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button4_1_2_c==false){
                    cevap_1_2 = cevap_1_2 +button4_1_2.getText();
                    text_1_2.setText(cevap_1_2);
                    button4_1_2_c=true;
                }
            }
        });
        gonder_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((cevap_1_2.equalsIgnoreCase(kelime1))&&(iskelime1==false)){
                    text_sal_S.setText("S");
                    textA_1_2.setText("A");
                    text_sal_L.setText("L");
                    iskelime1=true;
                    dogru_cevap++;
                }else if ((cevap_1_2.equalsIgnoreCase(kelime2))&&(iskelime2==false)){
                    text_bal_B.setText("B");
                    textA_1_2.setText("A");
                    text_bal_L.setText("L");
                    iskelime2=true;
                    dogru_cevap++;
                }
                else{
                    yanlis_cevap++;
                }
                if (dogru_cevap==2){
                    kronometre.stop();
                    time= SystemClock.elapsedRealtime()-kronometre.getBase();
                    puan=(int)(100-((time/1000)*yanlis_cevap));
                    totalPuan=puan+gelenPuan;
                    veritabani.puanUpdate(name,(totalPuan));
                    Intent seviye_1_2To1_3 = new Intent(Seviye_1_2_Activity.this,Seviye_1_3_Activity.class);
                    seviye_1_2To1_3.putExtra("oyuncuName",name);
                    seviye_1_2To1_3.putExtra("puan",totalPuan);
                    startActivity(seviye_1_2To1_3);
                }
                button_1_2_c=false;
                button2_1_2_c=false;
                button3_1_2_c=false;
                button4_1_2_c=false;
                cevap_1_2 ="";
                text_1_2.setText("");
            }
        });
        karistir_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(harfler_1_2);
                button_1_2.setText(harfler_1_2.get(0));
                button2_1_2.setText(harfler_1_2.get(1));
                button3_1_2.setText(harfler_1_2.get(2));
                button4_1_2.setText(harfler_1_2.get(3));
            }
        });



    }

}
