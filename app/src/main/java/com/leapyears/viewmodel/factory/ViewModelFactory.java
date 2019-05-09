package com.leapyears.viewmodel.factory;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.leapyears.model.Year;
import com.leapyears.viewmodel.LeapYearViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;
    private Year yearModel;

    public ViewModelFactory(Application application, Year yearModel) {
        this.mApplication = application;
        this.yearModel = yearModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LeapYearViewModel(mApplication, yearModel);
    }

}