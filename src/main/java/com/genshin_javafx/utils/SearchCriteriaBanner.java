package com.genshin_javafx.utils;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class SearchCriteriaBanner {
    private static String name;
    private static LocalDate dateStart;
    private static LocalDate dateEnd;
    private static LocalDate dateBetween;
    private static String version;
    private static String character5;
    private static String character4_1;
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
    public static LocalDate getDateBetween() {
        return dateBetween;
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
    public static void setDateBetween(LocalDate dateBetween) {
        SearchCriteriaBanner.dateBetween = dateBetween;
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
    public static Date asDate(LocalDate localDate){
       return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
}