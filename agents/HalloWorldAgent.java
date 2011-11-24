package agents;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zagadka
 */

import jade.core.Agent;

public class HalloWorldAgent extends Agent {
    
    private String service;

    protected void setup() {
        Object[] args = getArguments();
        service = String.valueOf(args[0]);
        
        System.out.println("Hallo World ! my name is " + this.getLocalName() +
                " i do the " + service + "service.");
    }
}
