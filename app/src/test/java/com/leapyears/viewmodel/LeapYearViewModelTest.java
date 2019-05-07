package com.leapyears.viewmodel;

import android.app.Application;
import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.leapyears.model.LeapYear;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LeapYearViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Application application;

    @Test
    public void shouldUpdateResultAsLeapYear_WhenInputIsLeapYear() {
        LeapYearViewModel viewModel = new LeapYearViewModel(application, new LeapYear());

        viewModel.find(1996);

        assertEquals("1996 is a Leap Year", viewModel.getResultLiveData().getValue());
    }

    @Test
    public void shouldUpdateResultAsNotLeapYear_WhenInputIsNotLeapYear() {
        LeapYearViewModel viewModel = new LeapYearViewModel(application, new LeapYear());

        viewModel.find(1900);

        assertEquals("1900 is not a Leap Year", viewModel.getResultLiveData().getValue());
    }
}
