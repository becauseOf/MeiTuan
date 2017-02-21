package com.xiangsong.meituan.model;

/**
 * Created by xiangsong on 2016/11/5.
 */

public class Shop {
    private int imgResource;
    private String title;
    private String amount;
    private String price;
    private String distance;

    public Shop() {
    }

    public Shop(int imgResource, String title, String amount, String price, String distance) {
        this.imgResource = imgResource;
        this.title = title;
        this.amount = amount;
        this.price = price;
        this.distance = distance;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
