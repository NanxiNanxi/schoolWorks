public class Date 
{
    private int month;
    private int day;
    private int year;
    
    public Date()
    {
        month = 1;
        day = 1;
        year = 2018;
    }
    
    public Date(int monthGet, int dayGet, int yearGet)
    {
        month = monthGet;
        day = dayGet;
        year = yearGet;
    }
    
    public int getMonth()
    {
        return month;
    }
    public void setMonth(int monthGet)
    {
       month = monthGet;
    }
    
    public int getDay()
    {
        return day;
    }
    public void setDay(int dayGet)
    {
       day = dayGet;
    }
    public int getYear()
    {
        return year;
    }
    public void setYear(int yearGet)
    {
       year = yearGet;
    }
    
    public void displayDate(int monthNum, int dayNum, int yearNum)
    {
        System.out.println(monthNum + "/" + dayNum +"/" + yearNum);
    }
            
}
import java.util.*;
public class TestDate 
{
    static Scanner k = new Scanner(System.in);
    public static void main(String[] args) 
    {
        Date date = new Date();
        int day = 1;
        int month = 1;
        int year = 2018;
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        System.out.print("Default date: ");
        date.displayDate(month, day, year);
        
        System.out.println("Please enter a new day: ");
        day = k.nextInt();
        System.out.println("Please enter a new month: ");
        month = k.nextInt();
        System.out.println("Please enter a new year: ");
        year = k.nextInt();
        
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        
        System.out.print("The new date is: ");
        date.displayDate(month, day, year);
    }
}
