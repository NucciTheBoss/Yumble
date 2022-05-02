package com.hcdd340.yumble.data;

import java.util.LinkedList;

public class ProfileManager {
    private final static String DEBUG_TAG = "PROFILE_MANAGER";

    // Begin Singleton declaration
    private static ProfileManager profileManager = null;

    private ProfileManager() {}

    public static ProfileManager getInstance() {
        if (profileManager == null) {
            profileManager = new ProfileManager();
        }

        return profileManager;
    }
    // End Singleton declaration

    private final LinkedList<Recipe> favoritesList = new LinkedList<>();
    private final LinkedList<Recipe> dislikeList = new LinkedList<>();
    private final LinkedList<Recipe> uploadList = new LinkedList<>();
    private final LinkedList<Recipe> favoritesByOtherList = new LinkedList<>();

    public void addFavorite(Recipe recipe) {
        favoritesList.add(recipe);
    }

    public int getFavoriteSize() {
        return favoritesList.size();
    }

    public void addDislike(Recipe recipe) {
        dislikeList.add(recipe);
    }

    public int getDislikeSize() {
        return dislikeList.size();
    }

    public void addUpload(Recipe recipe) {
        uploadList.add(recipe);
    }

    public int getUploadSize() {
        return uploadList.size();
    }

    public void addOthersFavorite(Recipe recipe) {
        favoritesByOtherList.add(recipe);
    }

    public int getFavoritesByOtherSize() {
        return favoritesByOtherList.size();
    }
}
