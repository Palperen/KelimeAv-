package com.palperen.yazlab_2.seviye_2;
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

public class Seviye_2_4_Activity extends AppCompatActivity {
    private Chronometer kronometre;
    private Button button,button2,button3,button4,gonder_1_1,karistir_1_1,geri;
    private TextView text_1_1,text_saki_S,text_saki_A,text_saki_K,text_saki_I,text_kas_A,text_kas_S,text_asi_A,text_asi_I,text_aksi_A,text_aksi_K,text_aksi_S;
    private int yanlis_cevap;
    private int dogru_cevap;
    private boolean button_c=false;
    private boolean button2_c=false;
    private boolean button3_c=false;
    private boolean button4_c=false;
    private boolean iskelime1=false;
    private boolean iskelime2=false;
    private boolean iskelime3=false;
    private boolean iskelime4=false;
    private String cevap_1_1="";
    private String kelime1="SAKİ";
    private String kelime2="KAS";
    private String kelime3="ASİ";
    private String kelime4="AKSİ";
    private List<String> harfler_1_1 = Arrays.asList("S", "A", "K", "İ");
    private long time;
    private int puan;
    Veritabani veritabani =new Veritabani(Seviye_2_4_Activity.this);
    String name;
    int gelenPuan;
    int totalPuan;





    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye_2_4);
        Intent gelenOyuncuName=getIntent();
        name= (String) gelenOyuncuName.getSerializableExtra("oyuncuName");
        gelenPuan=(int)gelenOyuncuName.getSerializableExtra("puan");
        kronometre=findViewById(R.id.kronometre);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        gonder_1_1=findViewById(R.id.gonder_1_1);
        karistir_1_1=findViewById(R.id.karistir_1_1);
        geri=findViewById(R.id.geri);
        text_1_1=findViewById(R.id.seviye_1_text);
        text_saki_S=findViewById(R.id.text_saki_S);
        text_saki_A=findViewById(R.id.text_saki_A);
        text_saki_K=findViewById(R.id.text_saki_K);
        text_saki_I=findViewById(R.id.text_saki_I);
        text_kas_A=findViewById(R.id.text_kas_A);
        text_kas_S=findViewById(R.id.text_kas_S);
        text_asi_A=findViewById(R.id.text_asi_A);
        text_asi_I=findViewById(R.id.text_asi_I);
        text_aksi_A=findViewById(R.id.text_aksi_A);
        text_aksi_K=findViewById(R.id.text_aksi_K);
        text_aksi_S=findViewById(R.id.text_aksi_S);
        yanlis_cevap=0;
        dogru_cevap=0;
        Collections.shuffle(harfler_1_1);
        button.setText(harfler_1_1.get(0));
        button2.setText(harfler_1_1.get(1));
        button3.setText(harfler_1_1.get(2));
        button4.setText(harfler_1_1.get(3));
        kronometre.start();
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geri_2_4togiris=new Intent(Seviye_2_4_Activity.this, Giris_Ekrani_Activity.class);
                startActivity(geri_2_4togiris);
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
                if ((cevap_1_1.equalsIgnoreCase(kelime1))&&(iskelime1==false)){
                    text_saki_S.setText("S");
                    text_saki_A.setText("A");
                    text_saki_K.setText("K");
                    text_saki_I.setText("İ");
                    iskelime1=true;
                    dogru_cevap++;

                }else if ((cevap_1_1.equalsIgnoreCase(kelime2))&&(iskelime2==false)){
                    text_saki_K.setText("K");
                    text_kas_A.setText("A");
                    text_kas_S.setText("S");
                    iskelime2=true;
                    dogru_cevap++;
                }else if ((cevap_1_1.equalsIgnoreCase(kelime3))&&(iskelime3==false)){
                    text_asi_A.setText("A");
                    text_saki_S.setText("S");
                    text_asi_I.setText("İ");
                    iskelime3=true;
                    dogru_cevap++;
                }else if ((cevap_1_1.equalsIgnoreCase(kelime4))&&(iskelime4==false)){
                    text_aksi_A.setText("A");
                    text_aksi_K.setText("K");
                    text_aksi_S.setText("S");
                    text_saki_I.setText("İ");
                    iskelime4=true;
                    dogru_cevap++;
                }
                else{
                    yanlis_cevap++;
                }
                if (dogru_cevap==4){
                    kronometre.stop();
                    time=SystemClock.elapsedRealtime()-kronometre.getBase();
                    puan=(int)(100-((time/1000)*yanlis_cevap));
                    totalPuan=puan+gelenPuan;
                    veritabani.puanUpdate(name,totalPuan);
                    Intent seviye_2_4To2_5 = new Intent(Seviye_2_4_Activity.this,Seviye_2_5_Activity.class);
                    seviye_2_4To2_5.putExtra("oyuncuName",name);
                    seviye_2_4To2_5.putExtra("puan",totalPuan);
                    startActivity(seviye_2_4To2_5);
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
