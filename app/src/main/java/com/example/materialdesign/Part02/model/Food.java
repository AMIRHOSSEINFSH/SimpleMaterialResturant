package com.example.materialdesign.Part02.model;

public class Food {

    private String name,description,price,ration,count,link_img;

    public String getName() {
        return name;
    }

    public Food(String name, String description, String price, String ration, String count, String link_img) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.ration = ration;
        this.count = count;
        this.link_img = link_img;
    }

    public Food(String name, String price, String ration, String count, String link_img) {
        this.name = name;
        this.price = price;
        this.ration = ration;
        this.count = count;
        this.link_img = link_img;
    }

    public Food(String name, String link_img) {
        this.name = name;
        this.link_img = link_img;
    }

    public Food(String name) {
        this.name = name;
    }

    public Food() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRation() {
        return ration;
    }

    public void setRation(String ration) {
        this.ration = ration;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getLink_img() {
        return link_img;
    }

    public void setLink_img(String link_img) {
        this.link_img = link_img;
    }
}
