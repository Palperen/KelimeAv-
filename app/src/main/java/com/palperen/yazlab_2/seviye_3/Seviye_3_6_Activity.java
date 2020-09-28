package com.palperen.yazlab_2.seviye_3;
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

public class Seviye_3_6_Activity extends AppCompatActivity {
    private Chronometer kronometre;
    private Button button,button2,button3,button4,button5,button6,gonder_1_1,karistir_1_1,geri;
    private TextView text_1_1,text_badire_A,text_badire_B,text_badire_D,text_badire_I,text_badire_R,text_badire_E
            ,text_derbi_E,text_derbi_R,text_derbi_B,text_derbi_I
            ,text_darbe_D,text_darbe_A,text_darbe_R,text_darbe_E
            ,text_debi_D,text_debi_B,text_debi_I
            ,text_deri_E,text_deri_R,text_deri_I
            ,text_irade_R,text_irade_A,text_irade_D,text_irade_E;
    private int yanlis_cevap;
    private int dogru_cevap;
    private boolean button_c=false;
    private boolean button2_c=false;
    private boolean button3_c=false;
    private boolean button4_c=false;
    private boolean button5_c=false;
    private boolean button6_c=false;
    private boolean iskelime1=false;
    private boolean iskelime2=false;
    private boolean iskelime3=false;
    private boolean iskelime4=false;
    private boolean iskelime5=false;
    private boolean iskelime6=false;
    private String cevap_1_1="";
    private String kelime1="BADİRE";
    private String kelime2="DERBİ";
    private String kelime3="DARBE";
    private String kelime4="DEBİ";
    private String kelime5="DERİ";
    private String kelime6="İRADE";
    private List<String> harfler_1_1 = Arrays.asList("B", "A", "D", "İ" ,"R" ,"E");
    private long time;
    private int puan;
    Veritabani veritabani =new Veritabani(Seviye_3_6_Activity.this);
    String name;
    int gelenPuan;
    int totalPuan;





    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviye_3_6);
        Intent gelenOyuncuName=getIntent();
        name= (String) gelenOyuncuName.getSerializableExtra("oyuncuName");
        gelenPuan=(int)gelenOyuncuName.getSerializableExtra("puan");
        kronometre=findViewById(R.id.kronometre);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        gonder_1_1=findViewById(R.id.gonder_1_1);
        karistir_1_1=findViewById(R.id.karistir_1_1);
        geri=findViewById(R.id.geri);
        text_1_1=findViewById(R.id.seviye_1_text);
        text_badire_B=findViewById(R.id.text_badire_B);
        text_badire_A=findViewById(R.id.text_badire_A);
        text_badire_D=findViewById(R.id.text_badire_D);
        text_badire_I=findViewById(R.id.text_badire_I);
        text_badire_R=findViewById(R.id.text_badire_R);
        text_badire_E=findViewById(R.id.text_badire_E);
        text_derbi_E=findViewById(R.id.text_derbi_E);
        text_derbi_R=findViewById(R.id.text_derbi_R);
        text_derbi_B=findViewById(R.id.text_derbi_B);
        text_derbi_I=findViewById(R.id.text_derbi_I);
        text_darbe_D=findViewById(R.id.text_darbe_D);
        text_darbe_A=findViewById(R.id.text_darbe_A);
        text_darbe_R=findViewById(R.id.text_darbe_R);
        text_darbe_E=findViewById(R.id.text_darbe_E);
        text_debi_D=findViewById(R.id.text_debi_D);
        text_debi_B=findViewById(R.id.text_debi_B);
        text_debi_I=findViewById(R.id.text_debi_I);
        text_deri_E=findViewById(R.id.text_deri_E);
        text_deri_R=findViewById(R.id.text_deri_R);
        text_deri_I=findViewById(R.id.text_deri_I);
        text_irade_R=findViewById(R.id.text_irade_R);
        text_irade_A=findViewById(R.id.text_irade_A);
        text_irade_D=findViewById(R.id.text_irade_D);
        text_irade_E=findViewById(R.id.text_irade_E);
        yanlis_cevap=0;
        dogru_cevap=0;
        Collections.shuffle(harfler_1_1);
        button.setText(harfler_1_1.get(0));
        button2.setText(harfler_1_1.get(1));
        button3.setText(harfler_1_1.get(2));
        button4.setText(harfler_1_1.get(3));
        button5.setText(harfler_1_1.get(4));
        button6.setText(harfler_1_1.get(5));
        kronometre.start();
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geri_3_6togiris=new Intent(Seviye_3_6_Activity.this, Giris_Ekrani_Activity.class);
                startActivity(geri_3_6togiris);
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
        });button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button5_c==false){
                    cevap_1_1 = cevap_1_1 +button5.getText();
                    text_1_1.setText(cevap_1_1);
                    button5_c=true;
                }
            }
        });button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button6_c==false){
                    cevap_1_1 = cevap_1_1 +button6.getText();
                    text_1_1.setText(cevap_1_1);
                    button6_c=true;
                }
            }
        });
        gonder_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((cevap_1_1.equalsIgnoreCase(kelime1))&&(iskelime1==false)){
                    text_badire_B.setText("B");
                    text_badire_A.setText("A");
                    text_badire_D.setText("D");
                    text_badire_I.setText("İ");
                    text_badire_R.setText("R");
                    text_badire_E.setText("E");
                    iskelime1=true;
                    dogru_cevap++;
                }else if ((cevap_1_1.equalsIgnoreCase(kelime2))&&(iskelime2==false)){
                    text_badire_D.setText("D");
                    text_derbi_E.setText("E");
                    text_derbi_R.setText("R");
                    text_derbi_B.setText("B");
                    text_derbi_I.setText("İ");
                    iskelime2=true;
                    dogru_cevap++;
                }else if ((cevap_1_1.equalsIgnoreCase(kelime3))&&(iskelime3==false)){
                    text_darbe_D.setText("D");
                    text_darbe_A.setText("A");
                    text_darbe_R.setText("R");
                    text_derbi_B.setText("B");
                    text_darbe_E.setText("E");
                    iskelime3=true;
                    dogru_cevap++;
                }else if ((cevap_1_1.equalsIgnoreCase(kelime4))&&(iskelime4==false)){
                    text_debi_D.setText("D");
                    text_badire_E.setText("E");
                    text_debi_B.setText("B");
                    text_debi_I.setText("İ");
                    iskelime4=true;
                    dogru_cevap++;
                }else if ((cevap_1_1.equalsIgnoreCase(kelime5))&&(iskelime5==false)){
                    text_darbe_D.setText("D");
                    text_deri_E.setText("E");
                    text_deri_R.setText("R");
                    text_deri_I.setText("İ");
                    iskelime5=true;
                    dogru_cevap++;
                }else if ((cevap_1_1.equalsIgnoreCase(kelime6))&&(iskelime6==false)){
                    text_debi_I.setText("İ");
                    text_irade_R.setText("R");
                    text_irade_A.setText("A");
                    text_irade_D.setText("D");
                    text_irade_E.setText("E");
                    iskelime6=true;
                    dogru_cevap++;
                }
                else{
                    yanlis_cevap++;
                }
                if (dogru_cevap==6){
                    kronometre.stop();
                    time=SystemClock.elapsedRealtime()-kronometre.getBase();
                    puan=(int)(100-((time/1000)*yanlis_cevap));
                    totalPuan=puan+gelenPuan;
                    veritabani.puanUpdate(name,(totalPuan));
                    Intent geri_3_6tofinish=new Intent(Seviye_3_6_Activity.this, Giris_Ekrani_Activity.class);
                    startActivity(geri_3_6tofinish);
                }
                button_c=false;
                button2_c=false;
                button3_c=false;
                button4_c=false;
                button5_c=false;
                button6_c=false;
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
                button5.setText(harfler_1_1.get(4));
                button6.setText(harfler_1_1.get(5));
            }
        });



    }

}
