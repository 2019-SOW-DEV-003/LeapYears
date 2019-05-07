package com.leapyears.model;

class LeapYear {

    boolean isLeapYear(int year) {
        if(year < 1582){
            return false;
        } else if(isMultipleOf(year, 400)){
            return true;
        } else if(isMultipleOf(year, 100) && !(isMultipleOf(year, 400))){
            return false;
        } else
            return isMultipleOf(year, 4) && !(isMultipleOf(year, 100));
    }

    private boolean isMultipleOf(int year, int i) {
        return year % i == 0;
    }
}
