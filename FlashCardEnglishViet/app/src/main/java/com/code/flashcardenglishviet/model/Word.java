/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.flashcardenglishviet.model;

import java.io.Serializable;

/**
 *
 * @author sev_user
 */
public class Word implements Serializable{
    private String id;
    private String ten;
    private String danhVan;
    private String tuLoai;
    private String audio;
    private String anh;
    private String nghia;
    private String viDu;
    private String dungKhiNao;

    public Word() {
    }
    public void print() {
        System.out.println(""+id+" "+ten+" "+danhVan+" "+tuLoai+" "+audio+" "+anh+" "+nghia+" "+viDu+" "+dungKhiNao);

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDanhVan() {
        return danhVan;
    }

    public void setDanhVan(String danhVan) {
        this.danhVan = danhVan;
    }

    public String getTuLoai() {
        return tuLoai;
    }

    public void setTuLoai(String tuLoai) {
        this.tuLoai = tuLoai;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }

    public String getViDu() {
        return viDu;
    }

    public void setViDu(String viDu) {
        this.viDu = viDu;
    }

    public String getDungKhiNao() {
        return dungKhiNao;
    }

    public void setDungKhiNao(String dungKhiNao) {
        this.dungKhiNao = dungKhiNao;
    }
    
}
