package com.leapyears.viewmodel.factory;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.leapyears.model.LeapYear;
import com.leapyears.viewmodel.LeapYearViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;
    private LeapYear leapYearModel;

    public ViewModelFactory(Application application, LeapYear leapYearModel) {
        this.mApplication = application;
        this.leapYearModel = leapYearModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LeapYearViewModel(mApplication, leapYearModel);
    }

}