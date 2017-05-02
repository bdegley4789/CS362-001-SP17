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
    public void test03() throws Throwable {
        LinkedList<Appt>tempAppt = new LinkedList<Appt>();
        TimeTable tempTable = new TimeTable();
        Appt Aappt = new Appt(11,28,9,8,2011,"appt","this appt");
        Appt Bappt = new Appt(8,13,22,3,2014,"appt","this appt");
        Appt notAppt = new Appt(4,57829,21,3,2016,"appt","this is appt");
        tempAppt.add(Aappt);
        tempAppt.add(Bappt);
        tempAppt = tempTable.deleteAppt(tempAppt,notAppt);
        assertEquals(tempAppt,null);
    }
}
