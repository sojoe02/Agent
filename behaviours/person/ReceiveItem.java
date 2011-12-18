/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.person;

import agents.actors.GeneralPerson;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Item;
import messages.PosSectorData;

/**
 *
 * @author Zagadka
 */
public class ReceiveItem extends CyclicBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.PROPOSE),
            MessageTemplate.MatchConversationId("giveitem"));
    
    GeneralPerson agent;
    

    public ReceiveItem(GeneralPerson agent) {
        this.agent = agent;
    }

    @Override
    public void action() {
        ACLMessage aclMessage = myAgent.receive(mt);
        if (aclMessage != null) {
        Item data = null;
            try {
                data = (Item) aclMessage.getContentObject();
            } catch (UnreadableException ex) {
                Logger.getLogger(GetDirections.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //System.out.println(data.getSector());
            agent.receiveItem(data);
        }

    }
}
