/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;


import jade.core.behaviours.CyclicBehaviour;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.AgentData;
import messages.PositionData;
import presentation.Presentation;
/**
 *
 * @author Zagadka
 */
public class CrossSectionDirections extends CyclicBehaviour{
    
    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), 
            MessageTemplate.MatchConversationId("directions"));
    
    int posx;
    int posy;
    
    
    public CrossSectionDirections(Agent agent, int posx, int posy) {
        super(agent);        
        this.posx = posx;
        this.posy = posy;
        
    }

    @Override
    public void action() {
        ACLMessage aclMessage = myAgent.receive(mt);

        if (aclMessage != null) {
            PositionData pos = new PositionData(posx,posy);
            ACLMessage reply = aclMessage.createReply();
            try {
                reply.setContentObject(pos);
            } catch (IOException ex) {
                Logger.getLogger(CrossSectionDirections.class.getName()).log(Level.SEVERE, null, ex);
            }
            myAgent.send(reply);            

        } else {
            this.block();
        }
    }
    
    
}
