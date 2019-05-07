package com.leapyears.model;

class LeapYear {

    public boolean isLeapYear(int year) {
        if(year % 4 == 0 && !(year % 100 == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
