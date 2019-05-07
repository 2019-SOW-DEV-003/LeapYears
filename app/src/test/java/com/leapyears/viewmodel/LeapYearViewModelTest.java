package com.leapyears.viewmodel;

import android.app.Application;
import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.leapyears.model.LeapYear;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LeapYearViewModelTest {

    private static final int LEAP_YEAR = 1996;
    private static final int NOT_A_LEAP_YEAR = 1900;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Application application;
    private LeapYearViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new LeapYearViewModel(application, new LeapYear());
    }

    @Test
    public void shouldUpdateResultAsLeapYear_WhenInputIsLeapYear() {
        viewModel.find(LEAP_YEAR);

        assertEquals("1996 is a Leap Year", viewModel.getResultLiveData().getValue());
    }

    @Test
    public void shouldUpdateResultAsNotLeapYear_WhenInputIsNotLeapYear() {
        viewModel.find(NOT_A_LEAP_YEAR);

        assertEquals("1900 is not a Leap Year", viewModel.getResultLiveData().getValue());
    }

    @Test
    public void shouldUpdateResultAsPreJulienYear_WhenInputIsPreJulienYear() {
        viewModel.find(400);

        assertEquals("400 is a pre Julian Year, Year must be greater than 1581", viewModel.getResultLiveData().getValue());
    }
}
