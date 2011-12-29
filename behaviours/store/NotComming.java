/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.store;

import agents.actors.GeneralStore;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.StoreData;
import messages.PositionData;
/**
 *
 * @author Zagadka
 */
public class NotComming extends CyclicBehaviour{
    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM),
            MessageTemplate.MatchConversationId("notcomming"));


    GeneralStore agent;

    public NotComming(GeneralStore agent) {
        this.agent = agent;
    }
    
    public void action() {
        ACLMessage aclMessage = agent.receive(mt);
        
        if(aclMessage != null){                       
            agent.removeCustomer();
            //System.out.println("removing customer");
        } else{
            this.block();
        }
    }
}
