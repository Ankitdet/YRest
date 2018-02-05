package com.test.ws.utils;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class DemoScheduler {
 
    public static void main(String[] args) {
 
        // Create a calendar instance
        Calendar calendar = Calendar.getInstance();
 
        // Set time of execution. Here, we have to run every day 4:20 PM; so,
        // setting all parameters.
        calendar.set(Calendar.HOUR, 1);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.AM_PM, Calendar.PM);
 
        Long currentTime = new Date().getTime();
		// Check if current time is greater than our calendar's time. If So,
        // then change date to one day plus. As the time already pass for
        // execution.
        if (calendar.getTime().getTime() < currentTime) {
            calendar.add(Calendar.DATE, 1);
        }
 
        // Calendar is scheduled for future; so, it's time is higher than
        // current time.
        long startScheduler = calendar.getTime().getTime() - currentTime;
        // Setting stop scheduler at 4:21 PM. Over here, we are using current
        // calendar's object; so, date and AM_PM is not needed to set
        calendar.set(Calendar.HOUR, 1);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.SECOND, 10);
        calendar.set(Calendar.AM_PM, Calendar.PM);
 
        // Calculation stop scheduler
        long stopScheduler = calendar.getTime().getTime() - currentTime;
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        // Executor is Runnable. The code which you want to run periodically.
        Runnable task = new Runnable() {
 
            @Override
            public void run() {
            	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            	Date date = new Date();
                System.out.println("Date and Time :"+dateFormat.format(date));
                scheduler.shutdown();
            } 
        };
		
        // execute scheduler at fixed time.
        scheduler.scheduleAtFixedRate(task, startScheduler, stopScheduler, MILLISECONDS);
     
    }
}