/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author osborne
 */
public class EmptyListException extends Exception {
    
    public EmptyListException(){
        super("Invalid operation on empty list");
    }
    
}
