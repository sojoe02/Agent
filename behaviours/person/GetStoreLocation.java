/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.person;

import agents.actors.GeneralPerson;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.PosSectorData;


/**
 *
 * @author Zagadka
 */
public class GetStoreLocation extends CyclicBehaviour{
    
    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
            MessageTemplate.MatchConversationId("getstorelocation"));
    
    GeneralPerson agent;
    
    public GetStoreLocation(GeneralPerson agent){
        this.agent = agent;
    }

    @Override
    public void action() {     
        ACLMessage aclMessage = myAgent.receive(mt);
        
        
        if (aclMessage != null) {             
            PosSectorData data = null;
            try {
                data = (PosSectorData) aclMessage.getContentObject();
            } catch (UnreadableException ex) {
                Logger.getLogger(GetDirections.class.getName()).log(Level.SEVERE, null, ex);
            }
            int[] destination = {data.getPosX(),data.getPosY()};
            //System.out.println(data.getSector());
            agent.movetoStore(data.getSector(), destination);
            

        } else {
            this.block();
        }
        
    }
    
}
