package com.example.shikher.bloodcell.Utils;

/**
 * Created by shikher on 30/6/17.
 */

public class DataGenerator {

    public DataGenerator(String s, String s1, String s2) {
    }

    public DataGenerator(String text1, String text2) {

    }
    public static String getBloodBank(int i)
    {
        String title[] = {"BLOODBANK1","BLOODDBANK2","BLOODDBANK3","BLOODDBANK4","BLOODDBANK5","BLOODDBANK5",
                "BLOODDBANK6", "BLOODDBANK7", "BLOODDBANK8", "BLOODDBANK9"};
        return title[i];
    }
    public static String getBloodBankPhone(int i)
    {
        String title[] = {"1234567890","1234567890","1234567890","1234567890","1234567890","1234567890",
                "1234567890", "1234567890", "1234567890", "1234567890"};
        return title[i];
    }
    public static String getBloodBankPlace(int i)
    {
        String title[] = {"City , District","City , District","City , District","City , District","City , District","City , District",
                "City , District", "City , District", "City , District", "City , District"};
        return title[i];
    }

}