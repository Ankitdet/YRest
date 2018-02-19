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
    	int startHours = 9;
    	int startMinute = 25;
    	int startSecond = 0;
    	
    	int endHours = 9;
    	int endMinutes = 26;
    	int endSecond = 0;
    	
        Calendar calendar = Calendar.getInstance();
 
        // Set time of execution. Here, we have to run every day 4:20 PM; so,
        // setting all parameters.
        calendar.set(Calendar.HOUR, startHours);
        calendar.set(Calendar.MINUTE, startMinute);
        calendar.set(Calendar.SECOND, startSecond);
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
        calendar.set(Calendar.HOUR, endHours);
        calendar.set(Calendar.MINUTE, endMinutes);
        calendar.set(Calendar.SECOND, endSecond);
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
               // scheduler.shutdown();
            } 
        };
		
        // execute scheduler at fixed time.
        scheduler.scheduleAtFixedRate(task, startScheduler, stopScheduler, MILLISECONDS);
     
    }
}

/**


Date and Time :2018/02/19 21:25:00
Date and Time :2018/02/19 21:26:11
Date and Time :2018/02/19 21:27:22
Date and Time :2018/02/19 21:28:33
Date and Time :2018/02/19 21:29:44
Date and Time :2018/02/19 21:30:55
Date and Time :2018/02/19 21:32:06
Date and Time :2018/02/19 21:33:17
Date and Time :2018/02/19 21:34:28
Date and Time :2018/02/19 21:35:39
Date and Time :2018/02/19 21:36:50
Date and Time :2018/02/19 21:38:01
Date and Time :2018/02/19 21:39:12
Date and Time :2018/02/19 21:40:23
Date and Time :2018/02/19 21:41:34
Date and Time :2018/02/19 21:42:45
Date and Time :2018/02/19 21:43:56
Date and Time :2018/02/19 21:45:07
Date and Time :2018/02/19 21:46:18
Date and Time :2018/02/19 21:47:29
Date and Time :2018/02/19 21:48:40
Date and Time :2018/02/19 21:49:51
Date and Time :2018/02/19 21:51:02
Date and Time :2018/02/19 21:52:13
Date and Time :2018/02/19 21:53:24
Date and Time :2018/02/19 21:54:34
Date and Time :2018/02/19 21:55:45
Date and Time :2018/02/19 21:56:56
Date and Time :2018/02/19 21:58:07
Date and Time :2018/02/19 21:59:18
Date and Time :2018/02/19 22:00:29
Date and Time :2018/02/19 22:01:40
Date and Time :2018/02/19 22:02:51
Date and Time :2018/02/19 22:04:02
Date and Time :2018/02/19 22:05:13
Date and Time :2018/02/19 22:06:24
Date and Time :2018/02/19 22:07:35
Date and Time :2018/02/19 22:08:46
Date and Time :2018/02/19 22:09:57
Date and Time :2018/02/19 22:11:08
Date and Time :2018/02/19 22:12:19
Date and Time :2018/02/19 22:13:30
Date and Time :2018/02/19 22:14:41
Date and Time :2018/02/19 22:15:52
Date and Time :2018/02/19 22:17:03
Date and Time :2018/02/19 22:18:14
Date and Time :2018/02/19 22:19:25
Date and Time :2018/02/19 22:20:36
Date and Time :2018/02/19 22:21:47
Date and Time :2018/02/19 22:22:58
Date and Time :2018/02/19 22:24:09
Date and Time :2018/02/19 22:25:20
Date and Time :2018/02/19 22:26:31
Date and Time :2018/02/19 22:27:42
Date and Time :2018/02/19 22:28:53
Date and Time :2018/02/19 22:30:04
Date and Time :2018/02/19 22:31:15
Date and Time :2018/02/19 22:32:26
Date and Time :2018/02/19 22:33:37
Date and Time :2018/02/19 22:34:47
Date and Time :2018/02/19 22:35:58
Date and Time :2018/02/19 22:37:09
Date and Time :2018/02/19 22:38:20
Date and Time :2018/02/19 22:39:31
Date and Time :2018/02/19 22:40:42
Date and Time :2018/02/19 22:41:53
Date and Time :2018/02/19 22:43:04
Date and Time :2018/02/19 22:44:15
Date and Time :2018/02/19 22:45:26
Date and Time :2018/02/19 22:46:37
Date and Time :2018/02/19 22:47:48
Date and Time :2018/02/19 22:48:59
Date and Time :2018/02/19 22:50:10
Date and Time :2018/02/19 22:51:21
Date and Time :2018/02/19 22:52:32
Date and Time :2018/02/19 22:53:43
Date and Time :2018/02/19 22:54:54
Date and Time :2018/02/19 22:56:05
Date and Time :2018/02/19 22:57:16
Date and Time :2018/02/19 22:58:27
Date and Time :2018/02/19 22:59:38
Date and Time :2018/02/19 23:00:49
Date and Time :2018/02/19 23:02:00
Date and Time :2018/02/19 23:03:11
Date and Time :2018/02/19 23:04:22
Date and Time :2018/02/19 23:05:33
Date and Time :2018/02/19 23:06:44
Date and Time :2018/02/19 23:07:55
Date and Time :2018/02/19 23:09:06
Date and Time :2018/02/19 23:10:17
Date and Time :2018/02/19 23:11:28
Date and Time :2018/02/19 23:12:39
Date and Time :2018/02/19 23:13:49
Date and Time :2018/02/19 23:15:00


*/