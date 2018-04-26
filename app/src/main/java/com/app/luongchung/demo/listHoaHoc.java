package com.app.luongchung.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.app.luongchung.Static.Data;
import com.app.luongchung.adapter.adapterChat;
import com.app.luongchung.model.Chat;
import java.util.ArrayList;
public class listHoaHoc extends AppCompatActivity {
    ArrayList<Chat> arrChat;
    ListView lvDS;
    adapterChat adapterC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hoa_hoc);
        addControl();
    }
    private void addControl() {
        Intent intent=getIntent();
        arrChat=new ArrayList<>();
        lvDS=findViewById(R.id.lvDS);
        DTLoad(intent.getIntExtra("Loai",1));
        adapterC= new adapterChat(listHoaHoc.this,R.layout.item,arrChat);
        lvDS.setAdapter(adapterC);

    }
    private void DTLoad(int i){
        Data data =new Data();
        for(Chat k :data.getData()){
            if(k.getIdLoai()==i){
                arrChat.add(k);
            }
        }
    }
}
