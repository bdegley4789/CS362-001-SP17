package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
    
    @Test
    public void test01() throws Throwable {
        CalDay day = new CalDay();
        assertFalse(day.isValid());
    }
    @Test
    public void test02() throws Throwable {
        CalDay day = new CalDay();
        assertEquals("", day.toString());
    }
    @Test
    public void test03() throws Throwable {
        CalDay day = new CalDay();
        assertEquals(day.iterator(),null);
    }
    @Test
    public void test04() throws Throwable {
        GregorianCalendar gregDay = new GregorianCalendar(2017, 5, 1);
        CalDay day = new CalDay(gregDay);
        assertEquals(day.isValid(),true);
        assertEquals(5, day.getMonth());
        assertEquals(1, day.getDay());
        assertEquals(2017, day.getYear());
    }
    /*@Test
    public void test05() throws Throwable {
        GregorianCalendar gregDay = new GregorianCalendar(2017, 5, 1);
        CalDay day = new CalDay(gregDay);
        Appt appt = new Appt(13, 2, 32, 04, 2017, "Test Set", "Testing Set");
        day.addAppt(appt);
        assertEquals(day.isValid(),true);
        assertEquals(5, day.getMonth());
        assertEquals(1, day.getDay());
        assertEquals(2017, day.getYear());
        assertEquals(1, day.getAppts().size());
        assertEquals(1, day.getSizeAppts());
        assertEquals(13, day.getAppts().get(0).getStartHour());
        assertEquals("\t --- 5/1/2017 --- \n --- -------- Appointments ------------ --- \n", day.toString());
        String strTest = day.toString();
        boolean checkStr = false;
        if (strTest.contains("Test Set")) {
            checkStr = true;
        }
        assertTrue(checkStr);
    }*/
    /*@Test
    public void test06() throws Throwable {
        GregorianCalendar gregDay = new GregorianCalendar(2017, 5, 1);
        CalDay day = new CalDay(gregDay);
        Appt appt = new Appt(4, 2, 32, 04, 2017, "Test Set", "Testing Set");
        day.addAppt(appt);
        appt = new Appt(6, 2, 32, 04, 2017, "Test Set2", "Testing Set");
        day.addAppt(appt);
        appt = new Appt(5, 2, 32, 04, 2017, "Test Set", "Testing Set");
        day.addAppt(appt);
        assertEquals(day.isValid(),true);
        assertEquals(3, day.getAppts().size());
        assertFalse(day.getAppts().size() == 1);
        assertEquals(4, day.getAppts().get(0).getStartHour());
        assertEquals(5, day.getAppts().get(1).getStartHour());
        assertEquals(6, day.getAppts().get(2).getStartHour());
        String strTest = day.toString();
        boolean checkStr = false;
        if (strTest.contains("Test Set") && strTest.contains("Test Set2")) {
            checkStr = true;
        }
        assertTrue(checkStr);
    }*/
    /*@Test
    public void test07() throws Throwable {
        GregorianCalendar gregDay = new GregorianCalendar(2017, 5, 1);
        CalDay day = new CalDay(gregDay);
        Appt appt = new Appt(4, 2, 32, 04, 2017, "Test Set", "Testing Set");
        day.addAppt(appt);
        appt = new Appt(13, 2, 4, 03, 2008, "Test Set", "Testing Set");
        day.addAppt(appt);
        assertEquals(2, day.getAppts().size());
        appt = new Appt(5, 2, 9, 01, 2015, "Test Set", "Testing Set");
        day.addAppt(appt);
        appt = new Appt(14, 2, 32, 04, 2014, "Test Set", "Testing Set");
        day.addAppt(appt);
        appt = new Appt(7, 2, 32, 04, 2002, "Test Set", "Testing Set");
        day.addAppt(appt);
        assertEquals(day.isValid(),true);
        assertEquals(5,day.getAppts().size());
        assertEquals(1, day.getDay());
        assertEquals(5, day.getMonth());
        assertEquals(2017, day.getYear());
        assertEquals(7, day.getAppts().get(0).getStartHour());
        assertEquals(13, day.getAppts().get(1).getStartHour());
        assertEquals(14, day.getAppts().get(2).getStartHour());
        assertEquals(5, day.getAppts().get(3).getStartHour());
        assertEquals(4, day.getAppts().get(4).getStartHour());
        assertTrue(day.iterator() != null);
    }*/
    /*@Test
    public void test08() throws Throwable {
        GregorianCalendar gregDay = new GregorianCalendar(2017, 5, 1);
        CalDay day = new CalDay(gregDay);
        Appt appt = new Appt(6, 5, 12, 5, 2017, "Test Set", "Testing Set");
        day.addAppt(appt);
        assertEquals("\t --- 5/1/2017 --- \n --- -------- Appointments ------------ --- \n", day.toString());
    }*/
}
