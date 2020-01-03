/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayManager;

import LinkedList.LinkedList;


public class ArrayManager {
    private Object[] data;
    private int size;

    public ArrayManager() {
    
        size = 0;
        data = new Object[10];
        
    }
    
    public ArrayManager(Object[] items){
        size = items.length;
        data = items;
        
    }
    //   1.	 Add a method to your ArrayManager called findAndReplace(Object target, Object source).  
//   It will replace all instances of target with source.  It will return the number of replacements made.
   public int findAndReplace(Object target, Object source){
       int counter = 0;
       for(int i = 0; i< data.length;i++){
           if(data[i].equals(target)){
               data[i] = source;
               counter++;
           }
       }
       return counter;
   }
    /**
 5.	Write a constructor for your ArrayManager that accepts a LinkedList as a parameter.  
 * It creates an instance of an ArrayManager containing the list data.  It iterates through 
 * the list and builds an Array Manager
 */
    public ArrayManager(LinkedList ll){
        ArrayManager am = new ArrayManager();
        if(ll.start !=null){
            ll.start();
            while(ll.current != null){
                am.append(ll.getCurrent());
                ll.advance();
            }
        }
        
        
       
    }
    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }
    
    public void append(Object item){
        if(size >= data.length){
            resize();
        }
      
        data[size]=item;
        size++;
    }
    
    public void addAt(int index, Object item){
         if(size >= data.length){
            resize();
        }
        for (int i = size; i >=index; i--) {
            data[i+1]=data[i];
        }
        data[index]=item;
    }
    
    public Object getElement(int index){
        return data[index];
    }
    private void resize(){
        Object[] temp = new Object[data.length+10];
            System.arraycopy(data, 0, temp, 0, data.length);
            data=temp;
    }
    
    public void removeAt(int index){
       
        for (int i = index; i <size; i++) {
            data[i]=data[i+1];
           
        }
        size--;
    }
    
    public int size(){
        return  size;
    }

    
    public void printBelow(Comparable c){
        for(Object o:data){
        if(c.compareTo(o)>0){
            System.out.println(o);
        }
    }
    }
    
    public void printRange(int start, int end){
        if(start <1 || start >end || end > size){
            System.out.println("start or end index not valid!");
        }
        else{
             for (int i = start-1; i < end; i++) {
                 System.out.println(data[i]);
        }
        }
       
    }
    public void appendArray(Object[] a){
        for(Object o: a){
            append(o);
        }
    }
    
   public void removeOccurences(Object o){
      for(int i=0;i<size;i++){
          if(data[i].equals(o)){
              removeAt(i);
      }
      }
   }
   
   public LinkedList getArrayManagerAsList(){
       LinkedList list = new LinkedList();
      for(int i=0; i < size; i++){
          list.append(data[i]);
      }
      return list;
   }
   


   
    
}
