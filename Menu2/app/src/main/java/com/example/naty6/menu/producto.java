package com.example.naty6.menu;

public class producto {
    int photo;
    String nameProduct;
    String price;
    int amount;

    public producto(int photo,String nameProduct,String price){
        this.photo=photo;
        this.nameProduct=nameProduct;
        this.price=price;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
