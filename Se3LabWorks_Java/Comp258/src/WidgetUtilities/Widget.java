/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WidgetUtilities;

/**
 *
 * @author osborne
 */
public class Widget implements Comparable {
   
    private int widgetNumber;
    private int widgetQuantity;
    private String widgetName;

    public Widget() {}
    
    public Widget(int widgetNumber, int widgetQuantity, String widgetName) {
        this.widgetNumber = widgetNumber;
        this.widgetQuantity = widgetQuantity;
        this.widgetName = widgetName;
    }
   
    public int getWidgetNumber() {
        return widgetNumber;
    }

    public void setWidgetNumber(int widgetNumber) {
        this.widgetNumber = widgetNumber;
    }

    public int getWidgetQuantity() {
        return widgetQuantity;
    }

    public void setWidgetQuantity(int widgetQuantity) {
        this.widgetQuantity = widgetQuantity;
    }

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName;
    }
    
    public String toString(){
        return this.getWidgetName()+" "+this.getWidgetQuantity();
    }
    
    public boolean equals(Object o){
        Widget w = (Widget)o;
        
        if(this.getWidgetNumber() == w.getWidgetNumber()){
            return true;
        }
        return false;
        
    }
    
    public int compareTo(Object o){
        
        Widget w = (Widget)o;
        
        if(this.getWidgetQuantity() < w.getWidgetQuantity()){
            return -1;
        }
        else if(this.getWidgetQuantity() > w.getWidgetQuantity()){
            return 1;
        }
        else{
            return 0;
        }
    
    }
        
        
    
    
    
}
