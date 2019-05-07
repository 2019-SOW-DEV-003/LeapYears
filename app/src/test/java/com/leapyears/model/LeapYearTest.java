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
}
