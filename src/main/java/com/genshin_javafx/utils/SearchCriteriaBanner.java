package com.genshin_javafx.utils;

import java.time.LocalDate;

public class SearchCriteriaBanner {
    private static String name;
    private static LocalDate dateStart;
    private static LocalDate dateEnd;
    private static String version;
    private static String character5;
    private static String character4_1;
    private static String character4_2;
    private static String character4_3;

    //gettery
    public static String getName() {
        return name;
    }

    public static LocalDate getDateStart() {
        return dateStart;
    }

    public static LocalDate getDateEnd() {
        return dateEnd;
    }

    public static String getVersion() {
        return version;
    }

    public static String getCharacter5() {
        return character5;
    }

    public static String getCharacter4_1() {
        return character4_1;
    }

    public static String getCharacter4_2() {
        return character4_2;
    }

    public static String getCharacter4_3() {
        return character4_3;
    }

    //settery

    public static void setName(String name) {
        SearchCriteriaBanner.name = name;
    }

    public static void setDateStart(LocalDate dateStart) {
        SearchCriteriaBanner.dateStart = dateStart;
    }

    public static void setDateEnd(LocalDate dateEnd) {
        SearchCriteriaBanner.dateEnd = dateEnd;
    }

    public static void setVersion(String version) {
        SearchCriteriaBanner.version = version;
    }

    public static void setCharacter5(String character5) {
        SearchCriteriaBanner.character5 = character5;
    }

    public static void setCharacter4_1(String character4_1) {
        SearchCriteriaBanner.character4_1 = character4_1;
    }

    public static void setCharacter4_2(String character4_2) {
        SearchCriteriaBanner.character4_2 = character4_2;
    }

    public static void setCharacter4_3(String character4_3) {
        SearchCriteriaBanner.character4_3 = character4_3;
    }
}
