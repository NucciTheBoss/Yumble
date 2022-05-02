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

    private LinkedList<Recipe> favoritesList = new LinkedList<>();
    private LinkedList<Recipe> dislikeList = new LinkedList<>();
    private LinkedList<Recipe> uploadList = new LinkedList<>();

}
