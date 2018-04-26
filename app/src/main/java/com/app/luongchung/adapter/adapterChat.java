package com.app.luongchung.adapter;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;


import com.app.luongchung.demo.ChitietChat;
import com.app.luongchung.demo.R;
import com.app.luongchung.model.Chat;
import java.util.ArrayList;
public class adapterChat extends ArrayAdapter<Chat> {
    Activity context;
    int resource;
    ArrayList<Chat> objects;
    public adapterChat(@NonNull Activity context, int resource, @NonNull ArrayList<Chat> objects) {
        super(context, resource, objects);
        this.context=context;
        this.objects=objects;
        this.resource=resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource, null);
        TextView txtTenChat=row.findViewById(R.id.txtTenChat);
        final Chat chat=objects.get(position);
        txtTenChat.setText(chat.getTenChat());
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,ChitietChat.class);
                intent.putExtra("id",chat.getId());
                context.getApplication().startActivity(intent);
            }
        });
        return row;
    }


}


