package com.app.luongchung.Static;

import com.app.luongchung.model.Chat;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Chat> arrData;
    public  Data(ArrayList<Chat> arrData) {
        this.arrData = arrData;
    }
    public ArrayList<Chat> getData(){
        return this.arrData;
    }

    public Data() {
    }
}
