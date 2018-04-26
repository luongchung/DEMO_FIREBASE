package com.app.luongchung.demo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.luongchung.Static.Data;
import com.app.luongchung.model.Chat;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean load=false;
    Button btn1,btn2,btn3,btn4;
    DatabaseReference mDatabase;
    static ArrayList<Chat> arrChat;
    Data dataT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
        new GetDT().execute();
    }
    private void addEvent() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(load){
                    Intent intent = new Intent(MainActivity.this,listHoaHoc.class);
                    intent.putExtra("Loai",1);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Xin chờ, đang tải dữ liệu...", Toast.LENGTH_LONG).show();
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(load){
                    Intent intent = new Intent(MainActivity.this,listHoaHoc.class);
                    intent.putExtra("Loai",2);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Xin chờ, đang tải dữ liệu...", Toast.LENGTH_LONG).show();
                }

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(load){
                    Intent intent = new Intent(MainActivity.this,listHoaHoc.class);
                    intent.putExtra("Loai",3);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Xin chờ, đang tải dữ liệu...", Toast.LENGTH_LONG).show();
                }

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(load){
                    Intent intent = new Intent(MainActivity.this,listHoaHoc.class);
                    intent.putExtra("Loai",4);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Xin chờ, đang tải dữ liệu...", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    private void addControls() {
        arrChat=new ArrayList<>();
        btn1=findViewById(R.id.btnSXSon);
        btn2=findViewById(R.id.btnDetMay);
        btn3=findViewById(R.id.btnMucIn);
        btn4=findViewById(R.id.btnTruSau);
    }
    class GetDT extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            layDuLieu();
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    private void layDuLieu() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
       // mDatabase.child("Chat").push().setValue(new Chat());
        DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
        final DatabaseReference ref2;
        ref2 = ref1.child("Chat");
        ref2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    Chat user = singleSnapshot.getValue(Chat.class);
                    arrChat.add(user);
                }
                dataT=new Data(arrChat);
                load=true;
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
