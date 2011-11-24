/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents.persons;

/**
 *
 * @author Zagadka
 */

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class GeneralPerson extends Agent{
    

    protected void setup() {       
        
        System.out.println("Hallo World ! my name is " + this.getLocalName() +
                " i am the general person agent.");
    }
    
        private void sendPosition() {
        AID r = new AID("flingo" , AID.ISLOCALNAME);
        ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
        aclMessage.addReceiver(r);
        aclMessage.setContent("Hello! How are you?");
        this.send(aclMessage);

    }
    
    
}
