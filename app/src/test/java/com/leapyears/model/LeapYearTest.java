package com.leapyears.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LeapYearTest {

    private static final int NORMAL_YEAR = 2017;
    private static final int LEAP_YEAR = 2012;
    private static final int SPECIAL_NORMAL_YEAR = 1800;
    private static final int SPECIAL_LEAP_YEAR = 2000;
    private static final int PRE_JULIEN_YEAR = 400;

    private LeapYear model;

    @Before
    public void setUp() {
        model = new LeapYear();
    }

    @Test
    public void shouldReturnFalse_ForNormalYearYear() {
        boolean result = model.isLeapYear(NORMAL_YEAR);

        assertFalse(result);
    }

    @Test
    public void shouldReturnTrue_ForLeapYear() {
        boolean result = model.isLeapYear(LEAP_YEAR);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalse_ForSpecialNormalYear() {
        boolean result = model.isLeapYear(SPECIAL_NORMAL_YEAR);

        assertFalse(result);
    }

    @Test
    public void shouldReturnTrue_ForSpecialLeapYear() {
        boolean result = model.isLeapYear(SPECIAL_LEAP_YEAR);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalse_ForPreJulianYear() {
        boolean result = model.isLeapYear(PRE_JULIEN_YEAR);

        assertFalse(result);
    }
}
