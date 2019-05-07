package com.leapyears.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.leapyears.model.LeapYear;

class LeapYearViewModel extends AndroidViewModel {

    private final LeapYear leapYearModel;
    private MutableLiveData<String> resultLiveData = new MutableLiveData<>();

    public LeapYearViewModel(@NonNull Application application, LeapYear leapYearModel) {
        super(application);
        this.leapYearModel = leapYearModel;
    }

    public void find(int year) {
        if(leapYearModel.isPreJulianYear(year)){
            resultLiveData.setValue(year + " is a pre Julian Year, Year must be greater than 1581");
        } else if(leapYearModel.isLeapYear(year)){
            resultLiveData.setValue(year + " is a Leap Year");
        } else{
            resultLiveData.setValue(year + " is not a Leap Year");
        }
    }

    public LiveData<String> getResultLiveData() {
        return resultLiveData;
    }
}
