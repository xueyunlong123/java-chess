package com.xyl.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by ${Xueyunlong} on 2016/9/8.
 */
public class Order {
    private int id;
    private int uid;

    public Timestamp getBuydate() {
        return buydate;
    }

    public void setBuydate(Timestamp buydate) {
        this.buydate = buydate;
    }

    private java.sql.Timestamp buydate;



    private float totalprice;
    private String receiver;
    private String rphone;
    private String raddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }





    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getRphone() {
        return rphone;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress;
    }
}
