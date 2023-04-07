package com.h2;

public class Utilities {

    public static long getLongValue(String in){
        try {
            return Long.parseLong(in);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(in + " cannot be converted into a 'long' value. Exiting program.");
        }
    }

    public static int getIntValue(String in){
        try {
            return Integer.parseInt(in);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(in + " cannot be converted into a 'int' value. Exiting program.");
        }
    }

    public static float getFloatValue(String in){
        try {
            return Float.parseFloat(in);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(in + " cannot be converted into a 'float' value. Exiting program.");
        }
    }
}
