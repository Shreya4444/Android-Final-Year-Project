package com.technotalkative.beproject.Education.m_DataObject;

/**
 * Created by ADMIN on 25/04/2017.
 */

public class Try {
    int id;
    String email,imageUrl;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        System.out.println("ID HERE IS" +id);
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
