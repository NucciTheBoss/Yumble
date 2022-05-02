package com.hcdd340.yumble.data;

import java.util.LinkedList;

public class Profile {
    private int id;
    private String name;
    private String passCode;
    private LinkedList<Recipe> favoritesList = new LinkedList<>();
    private LinkedList<Recipe> dislikeList = new LinkedList<>();
    private LinkedList<Recipe> uploadList = new LinkedList<>();

    public Profile(int id, String name, String passCode, LinkedList<Recipe> favoritesList, LinkedList<Recipe> dislikeList, LinkedList<Recipe> uploadList) {
        this.id = id;
        this.name = name;
        this.passCode = passCode;
        this.favoritesList = favoritesList;
        this.dislikeList = dislikeList;
        this.uploadList = uploadList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public LinkedList<Recipe> getFavoritesList() {
        return favoritesList;
    }

    public void setFavoritesList(LinkedList<Recipe> favoritesList) {
        this.favoritesList = favoritesList;
    }

    public LinkedList<Recipe> getDislikeList() {
        return dislikeList;
    }

    public void setDislikeList(LinkedList<Recipe> dislikeList) {
        this.dislikeList = dislikeList;
    }

    public LinkedList<Recipe> getUploadList() {
        return uploadList;
    }

    public void setUploadList(LinkedList<Recipe> uploadList) {
        this.uploadList = uploadList;
    }
}
