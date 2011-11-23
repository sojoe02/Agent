/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toturial;

/**
 *
 * @author Zagadka
 */
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class SenderAgent extends Agent {

    protected void setup() {
        System.out.println("Hello I am : " + this.getLocalName());
        sendMessage();
    }

    private void sendMessage() {
        AID r = new AID("flingo" , AID.ISLOCALNAME);
        ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
        aclMessage.addReceiver(r);
        aclMessage.setContent("Hello! How are you?");
        this.send(aclMessage);

    }
}
