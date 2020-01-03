/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayManager;

/**
 *
 * @author zhou6718
 */
public class ArrayManagerTest {
    public static void main(String[] args) {
        ArrayManager am = new ArrayManager();
//        for (int i = 0; i < 10; i++) {
//            int n = (int)(Math.random()*100+1);
//            am.append(n);
//        }
        am.append(30);
        am.append(30);
        am.append(10);
        am.append(50);
        am.append(60);
        am.print();
        System.out.println("=======================");
       int counter = 0;
              counter = am.findAndReplace(30, 20);
        System.out.println(counter);
//        am.addAt(0, 110);
//        System.out.println("=======================");
//        am.print();
//        am.removeAt(10);
//        System.out.println("=======================");
//        am.print();
    }
}
