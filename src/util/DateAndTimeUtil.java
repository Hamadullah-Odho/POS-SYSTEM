package PosSystem.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class DateAndTimeUtil {

    private static final DateTimeFormatter dateFormat ;
    private static final DateTimeFormatter timeFormat ;
    
    private DateAndTimeUtil(){}
    
    static{
     dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     timeFormat = DateTimeFormatter.ofPattern("hh:mm:ss a");
    }
    public static String getCurrentDate(){
        
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(dateFormat);
    }
    
    public static String getCurrentTime(){
    
        LocalTime currentTime = LocalTime.now();
        return currentTime.format(timeFormat);
    }
    
}
