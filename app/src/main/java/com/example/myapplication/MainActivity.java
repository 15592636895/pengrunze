package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] province=new String[]{"江西省","湖南省","福建省","浙江省","广东省"};
    String[][] city=new String[][]{{"南昌市","赣州市","九江市","上饶市","吉安市"},
    {"长沙市","株洲市","湘潭市","岳阳市","杭州市"},
            {"福州市","厦门市","泉州市","龙岩市","建瓯市"},
            {"海宁市","温州市","金华市","义乌市","杭州市"},
            {"广州市","中山市","珠海市","东莞市","佛山市"}};
    RadioButton rbFemale,rbMale;
    CheckBox cbFilm,cbSports,cbTraval,cbGame;
    TextView tvOrigin;
    ListView lv_province, lv_city;
    Context context;
    ConstraintLayout layout;
    int pPosition,cPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         context = this;
        Button btSubmit=findViewById(R.id.bt_submit);
        rbFemale=findViewById(R.id.rb_feaml);
        rbMale=findViewById(R.id.rb_male);
        cbFilm=findViewById(R.id.cb_film);
        cbSports=findViewById(R.id.cb_sports);
        cbTraval=findViewById(R.id.cb_traval);
        cbGame=findViewById(R.id.cb_game);
        layout=findViewById(R.id.layout);
        tvOrigin=findViewById(R.id.tv_origin);
        tvOrigin.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (lv_province!=null)
                    layout.removeView(lv_province);
                lv_province=new ListView(context);
                lv_province.setId(R.id.id_province);
                ArrayAdapter padapter=new ArrayAdapter(context,android.R.layout.simple_expandable_list_item_1,province);
                lv_province.setAdapter(padapter);
                layout.addView(lv_province);
                setPosition(lv_province.getId(),tvOrigin.getId()).applyTo(layout);
                lv_province.setOnItemClickListener(new ProvinListener());
                return true;
            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gender=(rbMale.isChecked()?"男":"女");
                String hobby=(cbFilm.isChecked()?cbFilm.getText().toString():"")+
                        (cbSports.isChecked()?cbSports.getText().toString():"")+
                        (cbTraval.isChecked()?cbTraval.getText().toString():"")+
                        (cbGame.isChecked()?cbGame.getText().toString():"");
                Toast.makeText(MainActivity.this,"性别："+
                        gender+"爱好："+hobby,Toast.LENGTH_LONG).show();

            }
        });
    }
    public ConstraintSet setPosition(int startId,int endID){
     ConstraintSet conSet=new ConstraintSet();
     conSet.constrainWidth(startId,250);
     conSet.constrainHeight(startId,600);
     conSet.connect(startId,ConstraintSet.LEFT,endID,ConstraintSet.RIGHT,0);
     conSet.connect(startId,ConstraintSet.TOP,endID,ConstraintSet.TOP,-10);
     return conSet;

    }
    class ProvinListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?>adapterView, View view, int i, long l) {
            pPosition=i;
            if (lv_city!=null)
                layout.removeView(lv_city);
            lv_city=new ListView(context);
            lv_city.setId(R.id.id_city);
            ArrayAdapter padapter=new ArrayAdapter(context,android.R.layout.simple_list_item_1,city[i]);
            lv_city.setAdapter(padapter);
            layout.removeView(lv_province);
            layout.addView(lv_city);
            setPosition(lv_city.getId(),tvOrigin.getId()).applyTo(layout);
            lv_city.setOnItemClickListener(new CityListener());

        }
    }
    class CityListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            cPosition=i;
            if (lv_city!=null)
                layout.removeView(lv_city);
            tvOrigin.setText(province[pPosition]+city[pPosition][cPosition]);

        }
    }
}