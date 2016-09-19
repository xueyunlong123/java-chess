package com.xyl.bean;

/**
 * Created by ${Xueyunlong} on 2016/9/7.
 */
public class Cart {
    private int id ;
    private int uid;
    private float price;
    private float totalprice;
    private int counts;
    private int bid;
    private String title;
    private String face;

   /* public Cart(int id, int uid, float price, float totalprice, int counts, int bid, String title, String face) {
        this.id = id;
        this.uid = uid;
        this.price = price;
        this.title=title;
        this.totalprice = totalprice;
        this.counts = counts;
        this.bid = bid;
        this.face =face;
    }
*/
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }
}
