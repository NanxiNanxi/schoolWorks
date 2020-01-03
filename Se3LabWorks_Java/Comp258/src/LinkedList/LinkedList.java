/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import ArrayManager.ArrayManager;
import WidgetUtilities.Widget;
import WidgetUtilities.WidgetUtilities;
import java.util.Scanner;

public class LinkedList {
    
    public Node start;
    public Node current;
    Scanner k = new Scanner(System.in);

    public LinkedList() {
    }

    public LinkedList(Object[] o) {
         for(int i=0; i<o.length; i++){
            
            append(o[i]);
            
        }
    }
//   2.	Add a method to your LinkedList class called circularAdvance.  It will advance current.  
//           If current is the last element in the list, it will move current to start.
    
    public void circularAdvance(){
        if(current.next != null){
            current = current.next;
        }
        else{
            current = start;
        }
    }
    
//    3.	Add a method to your linked list class called removeRange(int start, int end).  
//    It deletes all elements between start and end.  
    public void removeRange(int start, int end){
        int counter = 0;
        Node temp = this.start;
        while(temp != null){
            temp = temp.next;
            counter++;
        }
        if(start < 1 || end > counter ||  end < start){
            System.out.println("Please enter a valid start or end position!");
        }
        else{
            if(start == end){
                removeAtPosition(start);
            }
            else{
                for(int i=start;i <= end;i++){
                    removeAtPosition(i);
                }
                  
            }
                    
        }
    }
    
//    4.	Add a method to your linked list class called findAndReplace(Comparable target, Comparable source). 
//            It will replace all instances of target with source.  Remember it only needs to replace 
//            the data element of a Node, not the whole node.  It will return the number of replacements made.
    public int findAndReplace(Comparable target, Comparable source){
        int counter=0;
        Node temp = start;
        while(temp != null){
            if(target.equals(temp.getData())){
                temp.setData(source);
                counter++;
            }
            temp = temp.next;
        }
        return counter;
    }
    
//    6.	Write a method for your linked list called compareList(LinkedList list) It returns true if 
//            all items in both lists have the same data in their nodes.
    public boolean compareList(LinkedList list){
        int thisSize= 0;
        int listSize=1;
        Node temp = start;
        while(temp !=null){
            temp = temp.next;
            thisSize++;
        }
       if(list.start !=null)
        {
            list.start();
            while(list.current.next != null){
                list.advance();
                listSize++;
            }
        }
        
        if(start == null && list.start == null){
            return true;
        }
        
       if(listSize == thisSize){
           int notMatchCounter = 0;
            temp = start;
            list.start();
            while (temp != null){
                if(!temp.equals(list.current)){
                   notMatchCounter++;
                }
                temp = temp.next;
                list.advance();
        }
            if(notMatchCounter ==0){
                return true;
            }
       }
       return false;
    }
    
    
    public void removeAtPosition(int position){
        if(position ==0 ){
            start = start.next;
        }
        else{
             Node temp = start;
            for(int i=0; i< position-1; i++){
            temp = temp.next;
            }
            if(temp.next == current){
                current = start;
            }
            temp.next = temp.next.next;
        }
       
    }
    
    public void appendArray(Object[] a){
        for(Object o:a){
            addAfter(o);
        }
        
    }
    
    public boolean isUnique(Object o){
        Node temp = start;
        int count =0;
        while(temp != null) {
        if(temp.equals(o)){
            return true;
        }
        temp = temp.next;
        count++;
    }
        if(count==1)
        {
            return true;
        }
        else {
              return false;
        }
         
    }
    
   public ArrayManager getLinkedListAsArrayManager(){
       ArrayManager am = new ArrayManager();
       Node temp = start;
       int i =0;
       while(temp != null){
           am.addAt(i, temp.getData());
           temp = temp.next;
           i++;
       }
       return am;
   }
    
    public void append(Object o){
        Node n = new Node(o);
        if (start == null) {
            start = n;
        }
        else{
            Node temp = start;
            while (temp.next != null) {                
                temp = temp.next;
            }
            temp.next = n;
        }
        current = n;
    }
    
    public Object getCurrent(){
        if(this.current == null){
            this.current = start;
        }
        return this.current;
    }
    
    public void print(){
        Node temp = start;
        while (temp != null) {                
                System.out.println(temp.getData());
                temp = temp.next;
            }
    }
    
    public void start(){
        
        current = start;
        
    }
    
    public void advance(){
        
        if (current.next != null) {
            
            current = current.next;
        }
    }
    
   public void addBefore(Object o){
       
       Node n = new Node(o);
       
       if(start == null){
           start = n;
       }
       else{
           Node temp = start;
            while(temp.next != current){
                temp = temp.next;
            }
       n.next = current;
       temp.next = n;
       }
      
   
   }
   
   public void remove(){
       Node temp = start;
       
       while(temp.next != current){
           temp = temp.next;
       }
      temp.next = current.next;
      current = temp;
      
   }
   
    public void deleteCurrent() throws EmptyListException{
        
        if(start==null)
            throw new EmptyListException();
        
        if(current==start){
            start = start.next;
            current = start;
        }
        else{
            Node temp;
            temp = start;
            while(temp.next!=current){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            current = temp;
        }
    }
    
     public int countOccurances(Object o){
        
        int count=0;
        Node temp = start;
        while(temp!=null){
            if(temp.getData().equals(o)){
                count++;
            }
        
        temp=temp.next;
        }
        return count;
    }
    
      public void previous(){
        
        if(start==current){
            System.out.println("No previous node in this list");
        }
        else{
            Node temp = start;
            while(temp.next!=current){
                temp=temp.next;
            }
            current=temp;
        }
        
    } 
      
       public void printBelow(Comparable c){
        Node temp = start;
        while(temp != null){
            if(c.compareTo(temp.getData())>0){
                System.out.println(temp.getData());
            }
            temp = temp.next;
        }
        
    }
       public int countLessThan(Comparable c){
        int count=0;
        Node temp = start;
        while(temp!=null){
            if(c.compareTo(temp.getData())>0){
                count++;
            }
        
        temp=temp.next;
        }
        return count;
        
    } 
     
   public void showMenu(){
       System.out.println("1. Add before");
        System.out.println("2. Add after");
        System.out.println("3. Print");
        System.out.println("4. Get current");
        System.out.println("5. Delete current");
        System.out.println("6. Advance");
        System.out.println("7. Start");
        System.out.println("8. Exit");
        System.out.println(">>");
   }
    public void addAfter(Object o){
        Node n = new Node(o);
        
        if(start == null){
            start = n;
        }
        else{
           n.next = current.next;
            current.next = n;
        }
    }
    
    public boolean driveMachine(LinkedList ll){
        
        
        int choice = k.nextInt();
        boolean isStop = false;
        
        switch (choice){
            case 1:
                System.out.println("enter object you want to add: ");
               k.nextLine();
                Object o = k.nextLine();
                ll.addBefore(o);
                break;
            case 2:
                System.out.println("enter object you want to add: ");
                k.nextLine();
                o = k.nextLine();
                ll.addAfter(o);
                break;
            case 3:
                ll.print();
                break;
            case 4:
                ll.getCurrent();
                System.out.println(ll.current.toString());
                break;
            case 5:
                ll.remove();
                System.out.println(ll.getCurrent()+" has already been removed!");
                break;
            case 6:
                ll.advance();
                System.out.println("ll advanced!");
                break;
            case 7:
                ll.start();
                System.out.println("ll started!");
                break;
            case 8:
               isStop = true;
               break;
        }
        return isStop;
          
    }
   
//     public static void main(String[] args){
//        
//        try{
//        
//            Widget[] widgets = WidgetUtilities.getWidgets(10);
//            LinkedList list = new LinkedList(widgets);
//                        
//            list.append(widgets[0]);
//            list.append(widgets[0]);
//            
//            Widget w = new Widget();
//            w.setWidgetName(widgets[0].getWidgetName());
//            w.setWidgetNumber(widgets[0].getWidgetNumber());
//            w.setWidgetQuantity(widgets[0].getWidgetQuantity());
//            
//            list.print();
//            
//            int num =  list.countOccurances(w); //based on widget number
//            System.out.println(w +" appeared " + num +" times ");
//            int less = list.countLessThan(w);
//            System.out.println(less +" items are smaller than "+w);
//            
//        }
//        catch(Exception e){
//            System.out.println(e.toString());
//        }
//     }
//     }
    
    public static void main(String[] args) {
        
        LinkedList ll = new LinkedList();
        LinkedList l2 = new LinkedList();
//        boolean isStop =false;
//        while(!isStop){
//            ll.showMenu();
//            isStop=ll.driveMachine(ll);
//        }
       
        ll.append(6);
        ll.append(7);
        ll.append(8);
        ll.append(9);
        ll.append(15);
        ll.append(2);
        l2.append(6);
        l2.append(7);
        l2.append(8);
        l2.append(9);
        l2.append(15);
        l2.append(2);
        boolean b = false;
        b = ll.compareList(l2);
        System.out.println(b);
       
        System.out.println("____----------------------------------");

        //ll.removeAtPosition(5);
       // ll.addBefore(16);
       
        
 
        
        
        
        
      
        
        
    }
}

class Node{
    
    public Node next;
    private Object data;

    public Node(Object data) {
        
        this.data = data;
    }

    public Node() {
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

   
    public void setData(Object data) {
        this.data = data;
    }
    
    public boolean equals(Object o){
        if (((Node)o).getData().equals(this.getData())) {
            return true;
            
        }
        return false;
    }
    
}
     