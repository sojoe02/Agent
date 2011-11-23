/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents.stores;

/**
 *
 * @author Zagadka
 */

import jade.core.Agent;

public class GeneralStore extends Agent{
    private String service;

    protected void setup() {       
        
        System.out.println("Hallo World ! my name is " + this.getLocalName() +
                " i am the general store agent.");
    }
}
