package net.pachattiere.thedesserthero;

import java.math.BigInteger;

/**
 * Created by Yohann on 28/01/2015.
 */

public class Utils {
    public static String formatCalories(BigInteger calories) {
        if(calories.toString().length() <= 3)
            return calories.toString();
        else {
            String reste;

            if(calories.toString().length() < 6)
                reste = calories.toString().substring(3, calories.toString().length());
            else
                reste = calories.toString().substring(3, 6);

            return calories.toString().substring(0, 3) + "," + reste;
        }
    }

    public static String formatUnite(BigInteger calories) {
        String[] unites = {"Cal", "kCal", "MCal", "GCal", "TCal", "PCal", "ECal", "ZCal", "YCal"};

        int puissance3 = ((calories.toString().length()-1) / 3);

        if(puissance3 < unites.length)
            return unites[puissance3];
        else
            return "10^" + puissance3 + " Cal";
    }

}

