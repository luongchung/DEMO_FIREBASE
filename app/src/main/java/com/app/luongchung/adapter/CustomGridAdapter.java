package com.app.luongchung.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.app.luongchung.demo.R;
import com.app.luongchung.model.Anh;
import com.app.luongchung.model.UploadInfo;
import com.bumptech.glide.Glide;

import java.util.List;

    public class CustomGridAdapter  extends BaseAdapter {

        private List<Anh> listData;
        private LayoutInflater layoutInflater;
        private Context context;

        public CustomGridAdapter(Context aContext,  List<Anh> listData) {
            this.context = aContext;
            this.listData = listData;
            layoutInflater = LayoutInflater.from(aContext);
        }

        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        convertView = layoutInflater.inflate(R.layout.item_anh, null);
        holder = new ViewHolder();
        holder.flagView = (ImageView) convertView.findViewById(R.id.img_anh);
        convertView.setTag(holder);
        Anh country = this.listData.get(position);
        Glide.with(context)
                .load(country.getUrlAnh())
                .into(holder.flagView);


            return convertView;
        }

        // Tìm ID của Image ứng với tên của ảnh (Trong thư mục mipmap).
        public int getMipmapResIdByName(String resName)  {
            String pkgName = context.getPackageName();

            // Trả về 0 nếu không tìm thấy.
            int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
            Log.i("CustomGridView", "Res Name: "+ resName+"==> Res ID = "+ resID);
            return resID;
        }

        static class ViewHolder {
            ImageView flagView;
        }

}
