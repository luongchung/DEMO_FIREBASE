package com.app.luongchung.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.luongchung.demo.R;
import com.app.luongchung.model.Anh;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapterRcCamera2 extends RecyclerView.Adapter<adapterRcCamera2.RcCameraViewModel> {

    public ArrayList<Anh> getArrCamera() {
        return arrCamera;
    }

    public void setArrCamera(ArrayList<Anh> arrCamera) {
        this.arrCamera = arrCamera;
    }

    private ArrayList<Anh> arrCamera;
    private Activity tv;
    int k;
    public adapterRcCamera2(ArrayList<Anh> arrCamera, Activity tv) {
        this.arrCamera = arrCamera;
        this.tv=tv;
    }

    @Override
    public RcCameraViewModel onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_anh2,null);
        return new RcCameraViewModel(view);
    }

    @Override
    public void onBindViewHolder(RcCameraViewModel holder, int position) {
        Anh camera =arrCamera.get(position);

        Glide.with(tv)
                .load(camera.getUrlAnh())
                .into(holder.anhCamera);
    }

    @Override
    public int getItemCount() {
        return arrCamera.size();
    }
    class RcCameraViewModel extends RecyclerView.ViewHolder{
        ImageView anhCamera;
        public RcCameraViewModel(View itemView) {
            super(itemView);
            anhCamera = (ImageView) itemView.findViewById(R.id.img_anh);

        }
    }
}
