package edu.osu.cs362;


import org.junit.Test;
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;
    
    /**
     * Return a randomly selected method to be tests !.
     */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setDescription","setStartHour","setStartMinute","setStartDay","setStartMonth","setStartYear","toString","getValid"};// The list of the of methods to be tested in the Appt class
        
        int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
        
        return methodArray[n] ; // return the method name
    }
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
          long startTime = Calendar.getInstance().getTimeInMillis();
          long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
          
          
          System.out.println("Start testing...");
          
          
          for (int iteration = 0; elapsed < TestTimeout; iteration++) {
              long randomseed =System.currentTimeMillis();
              //			System.out.println(" Seed:"+randomseed );
              Random random = new Random(randomseed);
              
              int TstartDay=10;
              int TstartMonth=3;
              int TstartYear=2017;
              
              GregorianCalendar temp = new GregorianCalendar(TstartYear,TstartMonth,TstartDay);
              CalDay now = new CalDay(temp);
              now.toString();
              now.getSizeAppts();
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
              for (int i = 0; i < NUM_TESTS; i++) {
                  String methodName = ApptRandomTest.RandomSelectMethod(random);
                  if (methodName.equals("setTitle")){
                      String newTitle=(String) ValuesGenerator.getString(random);
                      appt.setTitle(newTitle);
                  }
                  if (methodName.equals("setDescription")){
                      String newDescription=(String) ValuesGenerator.getString(random);
                      appt.setDescription(newDescription);
                  }
                  if (methodName.equals("setStartHour")){
                      //0-23 hours is valid
                      int newHour=(int) ValuesGenerator.getRandomIntBetween(random,-12,40);
                      appt.setStartHour(newHour);
                  }
                  if (methodName.equals("setStartMinute")){
                      //0-59 minutes is valid
                      int newMinute=(int) ValuesGenerator.getRandomIntBetween(random,-2,61);
                      appt.setStartMinute(newMinute);
                  }
                  if (methodName.equals("setStartDay")){
                      //1-31 days is valid
                      int newDay=(int) ValuesGenerator.getRandomIntBetween(random,-2,33);
                      appt.setStartDay(newDay);
                  }
                  if (methodName.equals("setStartMonth")){
                      //1-12 months is valid
                      int newMonth=(int) ValuesGenerator.getRandomIntBetween(random,-2,14);
                      appt.setStartMonth(newMonth);
                  }
                  if (methodName.equals("setStartYear")){
                      //All years are valid
                      int newYear=(int) ValuesGenerator.getRandomIntBetween(random,1990,2020);
                      appt.setStartYear(newYear);
                  }
                  if (methodName.equals("toString")){
                      appt.toString();
                  }
                  if (methodName.equals("getValid")){
                      appt.getValid();
                  }
                  now.iterator();
                  now.toString();
                  now.getSizeAppts();
                  now.addAppt(appt);
                  now.getSizeAppts();
                  now.iterator();
                  now.toString();
                  
              }
              
              now.iterator();
              now.toString();
              now.getSizeAppts();
              now.addAppt(appt);
              now.getSizeAppts();
              now.iterator();
              now.toString();
              
              elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
              if((iteration%10000)==0 && iteration!=0 )
                  System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
              
          }
          
          
          System.out.println("Done testing...");
		 
		 
	 }
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


	
}
