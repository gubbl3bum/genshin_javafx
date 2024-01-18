package com.genshin_javafx.utils;
public class SearchCriteriaCharacter {
    private static String name;
    private static String element;
    private static String region;
    private static String gender;
    private static String age;
    private static String weapon;
    private static String quality;

        //gettery
    public static String getName() {
        return name;
    }

    public static String getElement() {
        return element;
    }

    public static String getRegion() {
        return region;
    }

    public static String getGender() {
        return gender;
    }
    public static String getAge() {
        return age;
    }

    public static String getWeapon() {
        return weapon;
    }

    public static String  getQuality() {
        return quality;
    }
        //settery

    public static void setName(String name) {
        SearchCriteriaCharacter.name = name;
    }

    public static void setElement(String element) {
        SearchCriteriaCharacter.element = element;
    }

    public static void setRegion(String region) {
        SearchCriteriaCharacter.region = region;
    }

    public static void setGender(String gender) {
        SearchCriteriaCharacter.gender = gender;
    }
    public static void setAge(String age) {
        SearchCriteriaCharacter.age = age;
    }

    public static void setWeapon(String weapon) {
        SearchCriteriaCharacter.weapon = weapon;
    }

    public static void setQuality(String quality) {
        SearchCriteriaCharacter.quality = quality;
    }
}