package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
          int Day;
          int Month;
          int Year;
          TimeTable tempTime = new TimeTable();
          Calendar now = Calendar.getInstance();
          Year = now.get(Calendar.YEAR);
          Day = now.get(Calendar.DAY_OF_MONTH);
          
          LinkedList<Appt> tempAppt = new LinkedList<Appt>();
	 }
    
    @Test
    public void test02() throws Throwable {
        LinkedList<Appt>tempAppt = new LinkedList<Appt>();
        TimeTable tempTable = new TimeTable();
        Appt Aappt = new Appt(11,28,9,8,2011,"appt","this appt");
        Appt Bappt = new Appt(8,13,22,3,2014,"appt","this appt");
        Appt CAppt = new Appt(4,57829,21,3,2016,"appt","this is appt");
        Appt DAppt = new Appt(4,9,9,9,2016,"appt","this is appt");
        tempAppt.add(Aappt);
        tempAppt.add(Bappt);
        tempAppt = tempTable.deleteAppt(tempAppt,CAppt);
        tempAppt = tempTable.deleteAppt(tempAppt,DAppt);
        assertEquals(tempAppt,null);
    }
    /*@Test
    public void test03() throws Throwable {
        Appt apptA = new Appt(10,0,14,5,2017,"one","two");
        Appt apptB = new Appt(10,0,14,5,2017,"three","four");
        Appt apptC = new Appt(10,0,14,5,2017,"five","six");
        Appt apptD = new Appt(10,0,14,5,2017,"seven","eight");
        Appt apptE = null;
        GregorianCalendar one = new GregorianCalendar(2017,5,15);
        GregorianCalendar two = new GregorianCalendar(2017,5,17);
        LinkedList<Appt> apptAll = new LinkedList<Appt>();
        apptAll.add(apptA);
        apptAll.add(apptB);
        apptAll.add(apptC);
        apptAll.add(apptD);
        LinkedList<Appt> appts = new LinkedList<Appt>();
        TimeTable timeTable = new TimeTable();
        LinkedList<CalDay> createdList = timeTable.getApptRange(apptAll, one, two);
        String strTest = createdList.toString();
        boolean checkStr = false;
        if (strTest.contains("one") && strTest.contains("two") && strTest.contains("three") && strTest.contains("four") && strTest.contains("five") && strTest.contains("six") && strTest.contains("seven") && strTest.contains("eight")) {
            checkStr = true;
        }
        assertTrue(checkStr);
        assertEquals(null, timeTable.deleteAppt(apptAll,apptA));
        assertEquals(null, timeTable.deleteAppt(appts,apptE));
    }*/
    @Test
    public void test04() throws Throwable {
        TimeTable t = new TimeTable();
        LinkedList<Appt> appts = new LinkedList<Appt>();
        LinkedList<Appt> apptsB;
        Appt apptB = new Appt(6, 4, 3, 3, 1999, "appt", "this appt");
        apptsB = t.deleteAppt(appts, apptB);
        assertNull(apptsB);
    }
    @Test
    public void test05() throws Throwable {
        TimeTable t = new TimeTable();
        LinkedList<Appt> appts = new LinkedList<Appt>();
        LinkedList<Appt> apptsB;
        Appt appt = new Appt(9, 6, 5, 6, 2001, "appt", "this appt");
        appts.add(appt);
        appt = new Appt(7, 6, 5, 4, 2001, "appt", "this appt");
        appts.add(appt);
        appt = new Appt(7, 6, 6, 6, 2001, "appt", "this appt");
        appts.add(appt);
        appt = new Appt(8, 6, 4, 6, 2001, "appt", "this appt");
        appts.add(appt);
        appt = new Appt(9, 7, 5, 7, 2001, "appt", "this appt");
        appts.add(appt);
        assertEquals(5, appts.size());
        apptsB = t.deleteAppt(appts,appt);
        assertEquals(4, apptsB.size());
    }
    @Test
    public void test06() throws Throwable {
        TimeTable t = new TimeTable();
        LinkedList<Appt> appts = new LinkedList<Appt>();
        Appt apptA = new Appt(12,25,5,3,2016,"appt","this appt");
        Appt apptB = new Appt(-1,22,3,4,2016,"appt","this appt");
        appts.add(apptA);
        appts.add(apptB);
        GregorianCalendar gregOne = new GregorianCalendar(2016,3,5);
        GregorianCalendar gregTwo = new GregorianCalendar(2016,5,4);
        t.getApptRange(appts,gregOne,gregTwo);
    }
}
