package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
    
    @Test
    public void test00() throws Throwable {
        CalDay date = new CalDay();
        assertFalse(date.isValid());
    }
}
