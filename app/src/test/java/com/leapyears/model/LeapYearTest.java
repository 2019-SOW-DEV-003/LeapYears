package com.leapyears.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class LeapYearTest {

    @Test
    public void shouldReturnFalse_ForNormalYearYear() {
        LeapYear model =  new LeapYear();

        boolean result = model.isLeapYear(2017);

        assertFalse(result);
    }
}
