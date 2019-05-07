package com.leapyears.model;

public class LeapYear {

    private static final int JULIAN_CALANDER_START = 1582;
    private static final int HUNDRED = 100;
    private static final int FOUR_HUNDRES = 400;
    private static final int FOUR = 4;

    public boolean isLeapYear(int year) {
        return !isPreJulianYear(year) && (isLeap(year) || isSpecialLeapYear(year)) && !isSpecialNormalYear(year);
    }

    public boolean isPreJulianYear(int year) {
        return year < JULIAN_CALANDER_START;
    }

    private boolean isLeap(int year) {
        return isMultipleOf(year, FOUR) && !(isMultipleOf(year, HUNDRED));
    }

    private boolean isSpecialNormalYear(int year) {
        return isMultipleOf(year, HUNDRED) && !(isMultipleOf(year, FOUR_HUNDRES));
    }

    private boolean isSpecialLeapYear(int year) {
        return isMultipleOf(year, 400);
    }

    private boolean isMultipleOf(int year, int i) {
        return year % i == 0;
    }
}
