package com.stockify.stocksearch.util;

public class DataTypeUtil {

    public static String nonNullString(String s){
        if(s ==null){
            return "";
        }
        return s;

    }

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

}
