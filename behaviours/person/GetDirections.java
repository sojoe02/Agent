/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.person;

/**
 *
 * @author Zagadka
 */
import agents.actors.GeneralPerson;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.PositionData;


public class GetDirections extends CyclicBehaviour {
    
    private static final MessageTemplate mt =
           MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), 
            MessageTemplate.MatchConversationId("directions"));
   
    GeneralPerson agent;

    
    public GetDirections(Agent agent){
        this.agent = (GeneralPerson) agent;
    } 
     

    @Override
    public void action() {
        ACLMessage aclMessage = myAgent.receive(mt);

        if (aclMessage != null) {
            //System.out.println(myAgent.getLocalName()+": I receive message.\n"+aclMessage); 
            PositionData content = null;
            try {
                content = (PositionData) aclMessage.getContentObject();
            } catch (UnreadableException ex) {
                Logger.getLogger(GetDirections.class.getName()).log(Level.SEVERE, null, ex);
            }
            agent.moveToCross(content.getPosX(), content.getPosY());

        } else {
            this.block();
        }

    }
}
