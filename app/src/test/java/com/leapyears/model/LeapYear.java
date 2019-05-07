package com.leapyears.model;

class LeapYear {

    boolean isLeapYear(int year) {
        if(isJulianYear(year)){
            return false;
        } else if(isSpecialLeapYear(year)){
            return true;
        } else if(isSpecialNormalYear(year)){
            return false;
        } else
            return isLeap(year);
    }

    private boolean isLeap(int year) {
        return isMultipleOf(year, 4) && !(isMultipleOf(year, 100));
    }

    private boolean isSpecialNormalYear(int year) {
        return isMultipleOf(year, 100) && !(isMultipleOf(year, 400));
    }

    private boolean isJulianYear(int year) {
        return year < 1582;
    }

    private boolean isSpecialLeapYear(int year) {
        return isMultipleOf(year, 400);
    }

    private boolean isMultipleOf(int year, int i) {
        return year % i == 0;
    }
}
