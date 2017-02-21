package com.xiangsong.meituan.model;

/**
 * Created by xiangsong on 2016/11/5.
 */

public class Food {
    private int imgResource;
    private String title;
    private String amount;
    private String price;

    public Food() {
    }

    public Food(int imgResource, String title, String amount, String price) {
        this.imgResource = imgResource;
        this.title = title;
        this.amount = amount;
        this.price = price;
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
}
