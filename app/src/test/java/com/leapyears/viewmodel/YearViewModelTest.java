package com.leapyears.viewmodel;

import android.app.Application;
import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.leapyears.model.Year;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.leapyears.viewmodel.LeapYearViewModel.LEAP_YEAR_RESULT;
import static com.leapyears.viewmodel.LeapYearViewModel.NOT_A_LEAP_YEAR_RESULT;
import static com.leapyears.viewmodel.LeapYearViewModel.PRE_JULIEN_RESULT;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class YearViewModelTest {

    private static final int LEAP_YEAR = 1996;
    private static final int NOT_A_LEAP_YEAR = 1900;
    public static final String EMPTY = "";
    public static final int PRE_JULIEN_YEAR = 400;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    private Application application;
    private LeapYearViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new LeapYearViewModel(application, new Year());
    }

    @Test
    public void shouldUpdateResultAsLeapYear_WhenInputIsLeapYear() {
        viewModel.find(LEAP_YEAR);

        assertResult(LEAP_YEAR + LEAP_YEAR_RESULT);
    }

    @Test
    public void shouldUpdateResultAsNotLeapYear_WhenInputIsNotLeapYear() {
        viewModel.find(NOT_A_LEAP_YEAR);

        assertResult(NOT_A_LEAP_YEAR + NOT_A_LEAP_YEAR_RESULT);
    }

    @Test
    public void shouldUpdateResultAsPreJulienYear_WhenInputIsPreJulienYear() {
        viewModel.find(PRE_JULIEN_YEAR);

        assertResult(PRE_JULIEN_YEAR + PRE_JULIEN_RESULT);
    }

    @Test
    public void shouldClearResult_WhenClearClicked() {
        viewModel.clear();

        assertResult(EMPTY);
    }

    private void assertResult(String expected) {
        assertEquals(expected, viewModel.getResultLiveData().getValue());
    }
}
