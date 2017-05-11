package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

    @Test
    public void test02() throws Throwable {
        int startHour=15;
        int startMinute=2;
        int startDay=15;
        int startMonth=1;
        int startYear=2007;
        String title="Mail";
        String description="Go to mailbox.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                             startMinute ,
                             startDay ,
                             startMonth ,
                             startYear ,
                             title,
                             description);
        // assertions
        assertTrue(appt.getValid());
        assertEquals(15, appt.getStartHour());
        assertEquals(2, appt.getStartMinute());
        assertEquals(15, appt.getStartDay());
        assertEquals(1, appt.getStartMonth());
        assertEquals(2007, appt.getStartYear());
        assertEquals("Mail", appt.getTitle());
        assertEquals("Go to mailbox.", appt.getDescription());
    }
    
    @Test
    public void test03() throws Throwable {
        Appt appt = new Appt(25,61,33,13,2017,"Everything bad", "First four wrong");
        assertFalse(appt.getValid());
    }
    
    @Test
    public void tes04() throws Throwable {
        Appt appt = new Appt(25,61,33,13,2017,"Everything bad", "First four wrong");
        appt.setStartHour(15);
        appt.setStartMinute(2);
        appt.setStartDay(15);
        appt.setStartMonth(1);
        appt.setStartYear(2007);
        
        assertTrue(appt.getValid());
        assertEquals(appt.getStartHour(),15);
        assertEquals(appt.getStartMinute(),2);
        assertEquals(appt.getStartDay(),15);
        assertEquals(appt.getStartMonth(),1);
        assertEquals(appt.getStartYear(),2007);
    }
    
    @Test
    public void test05() throws Throwable {
        Appt appt = new Appt(-1,30, 10, 04, 2017, "Test Hour", "-1 hour not possible");
        assertFalse(appt.getValid());
    }
    @Test
    public void test06() throws Throwable {
        Appt appt = new Appt(25, 30, 10, 04, 2017, "Test Hour", "25 hours not possible");
        assertFalse(appt.getValid());
    }
    @Test
    public void test07() throws Throwable {
        Appt appt = new Appt(13, -1, 10, 04, 2017, "Test Minute", "-1 minutes not possible");
        assertFalse(appt.getValid());
    }
    @Test
    public void test08() throws Throwable {
        Appt appt = new Appt(13, 67, 10, 04, 2017, "Test Minute", "67 minutes not possible");
        assertFalse(appt.getValid());
    }
    @Test
    public void test09() throws Throwable {
        Appt appt = new Appt(13, 2, -1, 04, 2017, "Test Day", "-1 days not possible");
        assertFalse(appt.getValid());
    }
    @Test
    public void test10() throws Throwable {
        Appt appt = new Appt(13, 2, 32, 04, 2017, "Test Day", "32 days not possible");
        assertFalse(appt.getValid());
    }
    @Test
    public void test11() throws Throwable {
        Appt appt = new Appt(13, 2, 10, -1, 2017, "Test Month", "-1 month not possible");
        assertFalse(appt.getValid());
    }
    @Test
    public void test12() throws Throwable {
        Appt appt = new Appt(13, 2, 10, 13, 2017, "Test Month", "13 months not possible");
        assertFalse(appt.getValid());
    }
    @Test
    public void test13() throws Throwable {
        Appt appt = new Appt(13,2,10,04,2017, "Test String", "Testing String");
        assertEquals("\t04/10/2017 at 1:02pm ,Test String, Testing String.\n", appt.toString());
    }
    
    @Test
    public void test14() throws Throwable {
        Appt appt = new Appt(13,2,10,04,2017, "Test Set", "Testing set");
        appt.setStartHour(14);
        appt.setStartMinute(3);
        appt.setStartDay(11);
        appt.setStartMonth(05);
        appt.setStartYear(2016);
        appt.setTitle("gjdks");
        appt.setDescription("jgsdkjfbs");
        assertTrue(appt.getValid());
        assertEquals(14, appt.getStartHour());
        assertEquals(3, appt.getStartMinute());
        assertEquals(11, appt.getStartDay());
        assertEquals(05, appt.getStartMonth());
        assertEquals(2016, appt.getStartYear());
        assertEquals("gjdks", appt.getTitle());
        assertEquals("jgsdkjfbs", appt.getDescription());
    }
    @Test
    public void test15() throws Throwable {
        Appt appt = new Appt(13,2,10,04,2017, "Test Set", "Testing set");
        appt.setStartHour(0);
        appt.setStartMinute(0);
        appt.setStartDay(0);
        appt.setStartMonth(0);
        appt.setStartYear(0);
        appt.setTitle(null);
        appt.setDescription(null);
        assertTrue(appt.getValid());
        assertEquals(0, appt.getStartHour());
        assertEquals(0, appt.getStartMinute());
        assertEquals(0, appt.getStartDay());
        assertEquals(0, appt.getStartMonth());
        assertEquals(0, appt.getStartYear());
        assertEquals(null, appt.getTitle());
        assertEquals(null, appt.getDescription());
    }
}
