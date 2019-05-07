package com.leapyears.model;

class LeapYear {

    public boolean isLeapYear(int year) {
        if(year % 100 == 0 && !(year % 400 == 0)){
            return false;
        } else if(year % 4 == 0 && !(year % 100 == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
