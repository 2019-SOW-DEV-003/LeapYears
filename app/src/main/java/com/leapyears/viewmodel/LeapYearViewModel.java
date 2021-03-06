package com.leapyears.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.leapyears.model.Year;

public class LeapYearViewModel extends AndroidViewModel {

    public static final String PRE_JULIEN_RESULT = " is a pre Julian Year, Year must be greater than 1581";
    public static final String LEAP_YEAR_RESULT = " is a Leap Year";
    public static final String NOT_A_LEAP_YEAR_RESULT = " is not a Leap Year";
    private final Year yearModel;
    private MutableLiveData<String> resultLiveData = new MutableLiveData<>();

    public LeapYearViewModel(@NonNull Application application, Year yearModel) {
        super(application);
        this.yearModel = yearModel;
    }

    public void find(int year) {
        if(yearModel.isPreJulianYear(year)){
            resultLiveData.setValue(year + PRE_JULIEN_RESULT);
        } else if(yearModel.isLeapYear(year)){
            resultLiveData.setValue(year + LEAP_YEAR_RESULT);
        } else {
            resultLiveData.setValue(year + NOT_A_LEAP_YEAR_RESULT);
        }
    }

    public LiveData<String> getResultLiveData() {
        return resultLiveData;
    }

    public void clear() {
        resultLiveData.setValue("");
    }
}
