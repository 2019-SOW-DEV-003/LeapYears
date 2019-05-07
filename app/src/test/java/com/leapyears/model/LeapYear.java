package com.leapyears.model;

class LeapYear {

    private static final int JULIAN_CALANDER_START = 1582;
    private static final int HUNDRED = 100;
    private static final int FOUR_HUNDRES = 400;
    private static final int FOUR = 4;

    boolean isLeapYear(int year) {
        if(isPreJulianYear(year)){
            return false;
        } else if(isSpecialLeapYear(year)){
            return true;
        } else if(isSpecialNormalYear(year)){
            return false;
        } else
            return isLeap(year);
    }

    private boolean isLeap(int year) {
        return isMultipleOf(year, FOUR) && !(isMultipleOf(year, HUNDRED));
    }

    private boolean isSpecialNormalYear(int year) {
        return isMultipleOf(year, HUNDRED) && !(isMultipleOf(year, FOUR_HUNDRES));
    }

    private boolean isPreJulianYear(int year) {
        return year < JULIAN_CALANDER_START;
    }

    private boolean isSpecialLeapYear(int year) {
        return isMultipleOf(year, 400);
    }

    private boolean isMultipleOf(int year, int i) {
        return year % i == 0;
    }
}
