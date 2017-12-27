package com.technotalkative.beproject.Education.m_DataObject;

/**
 * Created by ADMIN on 03/04/2017.
 */

public class Spacecraft{
    int id;
    String name,email;
    String imageUrl,imageUrl2,imageUrl3,imageUrl4;
    String uname,website,phoneno,amount,address;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        System.out.println("ID HERE IS" +id);
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getUname(){ return uname;}
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAddress(){ return address;}
    public void setAddress(String address) {
        this.address = address;
    }
    public String getWebsite(){ return website;}
    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoneno(){ return phoneno;}
    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
    public String getAmount(){ return amount;}
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }
    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public String getImageUrl3() {
        return imageUrl3;
    }
    public void setImageUrl3(String imageUrl3) {
        this.imageUrl3 = imageUrl3;
    }

    public String getImageUrl4() {
        return imageUrl4;
    }
    public void setImageUrl4(String imageUrl4) {
        this.imageUrl4 = imageUrl4;
    }
}