package com.xyl.bean;

/**
 * Created by ${Xueyunlong} on 2016/9/8.
 */
public class OrderDetail {
    private int id;
    private int oid;
    private int bid;
    private int counts;

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    private float buyprice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }



    public float getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(float buyprice) {
        this.buyprice = buyprice;
    }
}
