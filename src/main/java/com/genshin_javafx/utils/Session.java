package com.genshin_javafx.utils;
public class Session {
    private static String  currentUser;
    public static void initialize() {
        setCurrentUser("guest");
    }
    public static void setCurrentUser(String user) {
        currentUser = user;
    }

    public static String getCurrentUser() {
        return currentUser;
    }
}
