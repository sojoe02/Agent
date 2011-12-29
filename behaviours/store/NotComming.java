/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.store;

import agents.actors.GeneralStore;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

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
