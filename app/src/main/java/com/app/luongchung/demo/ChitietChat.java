package com.app.luongchung.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.luongchung.Static.Data;
import com.app.luongchung.adapter.adapterRcCamera;
import com.app.luongchung.adapter.adapterRcCamera2;
import com.app.luongchung.model.Anh;
import com.app.luongchung.model.Chat;
import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ChitietChat extends AppCompatActivity {
    TextView txtTenChat,txtCTHH,txtMaSoCAS,txtMaUN,txtTinhNguyHiemChay,txtNhietDoTuBatChay,txtNhietDoTuChopChay,txtChienThuatChuaChay;
    Intent intent;
    String id="";
    ArrayList<Anh> arrAnh1,ArrAnh2;
    RecyclerView rcv1,rcv2;
    adapterRcCamera2 adapterRc;
    Button btnNFS,btnSHB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitiet_chat);
        intent=getIntent();
        id=intent.getStringExtra("id");
        addControls();
        addEvents();

    }

    private void addEvents() {
        btnSHB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ChitietChat.this,listImage.class);
                startActivityForResult(intent,1996);
            }
        });
        btnNFS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ChitietChat.this,listImage.class);
                startActivityForResult(intent,1997);
            }
        });
    }

    private void addControls() {
        txtTenChat=findViewById(R.id.txtTenChat);
        txtCTHH=findViewById(R.id.txtCTHH);
        txtMaSoCAS=findViewById(R.id.txtMaSoCAS);
        txtMaUN=findViewById(R.id.txtMasoUN);

        btnNFS=findViewById(R.id.btnNFPA);
        btnSHB=findViewById(R.id.btnGHS);

        txtTinhNguyHiemChay=findViewById(R.id.txtTinhNguyHiemChay);
        txtNhietDoTuBatChay=findViewById(R.id.txtNhietDotuBocChay);
        txtNhietDoTuChopChay=findViewById(R.id.txtNhietDotuChopChay);
        txtChienThuatChuaChay=findViewById(R.id.txtChienThuatChuaChay);
        Data data =new Data();
        for(Chat chat:data.getData()){
            if(chat.getId().equals(id)){
                txtTenChat.setText(chat.getTenChat());
                txtCTHH.setText("Công thức hóa học: "+chat.getCongThucHoaHoc());
                txtMaSoCAS.setText("Mã số CAS: "+chat.getMaSoCAS());
                txtMaUN.setText("Mã UN: "+chat.getMaUN());
                txtTinhNguyHiemChay.setText("Tính nguy hiểm cháy: "+chat.getTinhNguyHiemChay());
                txtNhietDoTuBatChay.setText("Nhiệt độ tự bắt cháy: "+chat.getNhietDoTuBatChay());
                txtNhietDoTuChopChay.setText("Nhiệt độ tự chớp cháy: "+chat.getNhietDoDopChay());
                txtChienThuatChuaChay.setText(chat.getChienThuatChuaChay());
            }
        }



        rcv1 =(RecyclerView)findViewById(R.id.rc_nfpa);
        arrAnh1 =new ArrayList<>();
        arrAnh1.add(new Anh("http://icons.iconarchive.com/icons/graphicloads/100-flat/256/home-icon.png"));
        arrAnh1.add(new Anh("http://icons.iconarchive.com/icons/graphicloads/100-flat/256/home-icon.png"));
        arrAnh1.add(new Anh("http://icons.iconarchive.com/icons/graphicloads/100-flat/256/home-icon.png"));



        adapterRc=new adapterRcCamera2(arrAnh1,this);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rcv1.setLayoutManager(manager);
        rcv1.setAdapter(adapterRc);





    }
}
