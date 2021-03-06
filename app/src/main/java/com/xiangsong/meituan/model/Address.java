package com.xiangsong.meituan.model;

/**
 * Created by xiangsong on 2016/11/5.
 */

public class Address {
    private String title;
    private String name;
    private String phone;

    public Address() {
    }

    public Address(String title, String name, String phone) {
        this.title = title;
        this.name = name;
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
