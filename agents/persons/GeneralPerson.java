/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents.persons;

/**
 *
 * @author Zagadka
 */

import jade.core.Agent;

public class GeneralPerson extends Agent{
    

    protected void setup() {       
        
        System.out.println("Hallo World ! my name is " + this.getLocalName() +
                " i am the general person agent.");
    }
}
