/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.store;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.PosSectorData;
import messages.PositionData;

/**
 *
 * @author Zagadka
 */
public class GiveLocation extends CyclicBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
            MessageTemplate.MatchConversationId("givestorelocation"));
    
    int posx, posy, sector;

    public GiveLocation(Agent agent, int posx, int posy,int sector) {
        super(agent);
        this.posx = posx;
        this.posy = posy; 
        this.sector = sector;
    }

    @Override
    public void action() {
        ACLMessage aclMessage = myAgent.receive(mt);
        
        if(aclMessage != null){                       
            PosSectorData data = new PosSectorData(posx,posy,sector);
            ACLMessage reply = aclMessage.createReply();            
            reply.setConversationId("getstorelocation");
            try {                
                reply.setContentObject(data);
            } catch (IOException ex) {
                Logger.getLogger(GiveItemList.class.getName()).log(Level.SEVERE, null, ex);
            }
            myAgent.send(reply); 
        }
    }
}
