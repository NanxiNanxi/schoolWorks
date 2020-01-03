/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author zhou6718
 */
public class Date 
{
    private int month;
    private int day;
    private int year;
    public Date()
    {
        
    }
    public Date(int month,int day, int year)
    {
       int[] days = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
        if( month==2 && day==29 && (year%400==0 || (year % 4==0 && year % 100 != 0 )))
        {
            this.day = day;
        }
        else if( day<1 || day > days[month])
        {
            this.day = 1;
        }
        else
        {
            this.day = day;
        }  
        if(month <= 0 || month > 12) 
        {
            this.month = 1;
        }
        else 
        {
            this.month = month;
        }
        
        this.year = year;
    }
    public int getDay()
    {
        return day;
    }
    public void setDay(int day)
    {
        int[] days = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
        if( month==2 && day==29 && (year%400==0 || (year % 4==0 && year % 100 != 0 )))
        {
            this.day = day;
        }
        else if( day<1 || day > days[month])
        {
            this.day = 1;
        }
        else
        {
            this.day = day;
        }     
    }
    public int getMonth()
    {
        return month;
    }
    public void setMonth(int month)
    {
        if(month <= 0 || month > 12) this.month = 1;
        else this.month = month;
    }
    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }
    public String toString()
    {
        return month+"/"+ day + "/" +year;
    }
}