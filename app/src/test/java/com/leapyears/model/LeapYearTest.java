package com.leapyears.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LeapYearTest {

    @Test
    public void shouldReturnFalse_ForNormalYearYear() {
        LeapYear model =  new LeapYear();

        boolean result = model.isLeapYear(2017);

        assertFalse(result);
    }

    @Test
    public void shouldReturnTrue_ForLeapYear() {
        LeapYear model =  new LeapYear();

        boolean result = model.isLeapYear(2012);

        assertTrue(result);
    }
}
