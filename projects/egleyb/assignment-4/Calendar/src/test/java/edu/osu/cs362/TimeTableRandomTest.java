package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
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
     * Generate Random Tests that tests TimeTable Class.
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
            TimeTable table = new TimeTable();
            Calendar second = Calendar.getInstance();
            LinkedList<Appt> temp = new LinkedList<Appt>();
            int TstartDay=10;
            int TstartMonth=3;
            int TstartYear=2017;
            GregorianCalendar one = new GregorianCalendar(TstartYear,TstartMonth,TstartDay);
            int SstartDay=6;
            int SstartMonth=1;
            int SstartYear=2016;
            GregorianCalendar two = new GregorianCalendar(SstartYear,SstartMonth,SstartDay);
            CalDay now = new CalDay(one);
            Appt sample = null;
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
            temp.add(appt);
            table.getApptRange(temp,one,two);
            int nextHour=(int) ValuesGenerator.getRandomIntBetween(random,-2,25);
            Appt Fappt = new Appt(nextHour,startMinute,startDay,startMonth,startYear,title,description);
            CalDay deuce = new CalDay(new GregorianCalendar(2017,3,12));
            temp.add(appt);
            temp.add(Fappt);
            table.deleteAppt(temp,Fappt);
            LinkedList<Appt> temp2 = new LinkedList<Appt>();
            table.deleteAppt(temp2,appt);
            LinkedList<Appt> temp3 = null;
            Appt Gappt = null;
            //table.deleteAppt(Fappt,appt);
            table.getApptRange(temp3,one,two);
            table.deleteAppt(temp,Gappt);
            table.getApptRange(temp2,one,two);
            
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
                    int newHour=(int) ValuesGenerator.getRandomIntBetween(random,-2,25);
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
                assertTrue((table.deleteAppt(temp,appt))==null);
                temp.add(appt);
                now.addAppt(appt);
                table.getApptRange(temp3,one,two);
                table.getApptRange(temp3,one,one);
                table.getApptRange(temp3,two,one);
                table.getApptRange(temp2,two,two);
                table.getApptRange(temp2,two,one);
                table.getApptRange(temp2,one,two);
                table.getApptRange(temp,one,two);
                table.getApptRange(temp,two,one);
                assertTrue((table.deleteAppt(temp,appt))!=null);
                table.deleteAppt(temp,appt);
                table.getApptRange(temp,one,two);
            }
            
            table.deleteAppt(temp,appt);
            
            
            elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
            if((iteration%10000)==0 && iteration!=0 )
                System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
            
        }
        //TimeTable
        
        
        System.out.println("Done testing...");
    }
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
