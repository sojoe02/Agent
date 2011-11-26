/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents.actors;

/**
 *
 * @author Zagadka
 */
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class GeneralPerson extends Agent implements agents.AgentInterface {
    
    int posx, posy;

    @Override
    protected void setup() {
        System.out.println("Hallo World ! my name is " + this.getLocalName()
                + " i am a straight up 'general person' agent.");
        
        sendPosition();
    }
    
    protected void updatePosition(){
        
    }   

    private void sendPosition() {
        AID r = new AID(RENDERAGENT, AID.ISLOCALNAME);
        ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
        aclMessage.addReceiver(r);
        aclMessage.setContent("Hello! How are you?");
        this.send(aclMessage);
    }
}
