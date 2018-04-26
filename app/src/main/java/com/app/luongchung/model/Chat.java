package com.app.luongchung.model;

import java.util.ArrayList;

public class Chat {
    private String id;
    private int idLoai;

    public int getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }

    private String tenChat;
    private String congThucHoaHoc;
    private String maSoCAS;
    private String maUN;
    private String urlNFPA;
    private String tinhNguyHiemChay;
    private String nhietDoTuBatChay;
    private String nhietDoDopChay;
    private String chienThuatChuaChay;

    public Chat() {

    }

    public Chat(String id,int idLoai, String tenChat, String congThucHoaHoc, String maSoCAS, String maUN, String urlNFPA, String tinhNguyHiemChay, String nhietDoTuBatChay, String nhietDoDopChay, String chienThuatChuaChay) {
        this.id = id;
        this.idLoai=idLoai;
        this.tenChat = tenChat;
        this.congThucHoaHoc = congThucHoaHoc;
        this.maSoCAS = maSoCAS;
        this.maUN = maUN;
        this.urlNFPA = urlNFPA;
        this.tinhNguyHiemChay = tinhNguyHiemChay;
        this.nhietDoTuBatChay = nhietDoTuBatChay;
        this.nhietDoDopChay = nhietDoDopChay;
        this.chienThuatChuaChay = chienThuatChuaChay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenChat() {
        return tenChat;
    }

    public void setTenChat(String tenChat) {
        this.tenChat = tenChat;
    }

    public String getCongThucHoaHoc() {
        return congThucHoaHoc;
    }

    public void setCongThucHoaHoc(String congThucHoaHoc) {
        this.congThucHoaHoc = congThucHoaHoc;
    }

    public String getMaSoCAS() {
        return maSoCAS;
    }

    public void setMaSoCAS(String maSoCAS) {
        this.maSoCAS = maSoCAS;
    }

    public String getMaUN() {
        return maUN;
    }

    public void setMaUN(String maUN) {
        this.maUN = maUN;
    }

    public String getUrlNFPA() {
        return urlNFPA;
    }

    public void setUrlNFPA(String urlNFPA) {
        this.urlNFPA = urlNFPA;
    }


    public String getTinhNguyHiemChay() {
        return tinhNguyHiemChay;
    }

    public void setTinhNguyHiemChay(String tinhNguyHiemChay) {
        this.tinhNguyHiemChay = tinhNguyHiemChay;
    }

    public String getNhietDoTuBatChay() {
        return nhietDoTuBatChay;
    }

    public void setNhietDoTuBatChay(String nhietDoTuBatChay) {
        this.nhietDoTuBatChay = nhietDoTuBatChay;
    }

    public String getNhietDoDopChay() {
        return nhietDoDopChay;
    }

    public void setNhietDoDopChay(String nhietDoDopChay) {
        this.nhietDoDopChay = nhietDoDopChay;
    }

    public String getChienThuatChuaChay() {
        return chienThuatChuaChay;
    }

    public void setChienThuatChuaChay(String chienThuatChuaChay) {
        this.chienThuatChuaChay = chienThuatChuaChay;
    }
}
