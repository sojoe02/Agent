/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toturial;

/**
 *
 * @author Zagadka
 */
 
import jade.core.Agent; 
 
public class RecieverAgent extends Agent { 
 
  protected void setup() { 
    System.out.println("Hello. My name is "+this.getLocalName()); 
    addBehaviour(new ResponderBehaviour(this)); 
  } 
} 
 