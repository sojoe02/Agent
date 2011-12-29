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
public class GiveLocation extends CyclicBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
            MessageTemplate.MatchConversationId("givestorelocation"));
    
    int posx, posy, sector;
    
    GeneralStore agent;

    public GiveLocation(GeneralStore agent, int posx, int posy,int sector) {
        this.agent = agent;
        this.posx = posx;
        this.posy = posy; 
        this.sector = sector;
    }

    @Override
    public void action() {
        ACLMessage aclMessage = agent.receive(mt);
        
        if(aclMessage != null){                       
            StoreData data = new StoreData(posx,posy,sector,agent.getActiveCustomer());
            agent.addCustomer();            
            ACLMessage reply = aclMessage.createReply();         
            reply.setPerformative(ACLMessage.INFORM);
            reply.setConversationId("getstorelocation");
            try {                
                reply.setContentObject(data);
            } catch (IOException ex) {
                Logger.getLogger(GiveItemList.class.getName()).log(Level.SEVERE, null, ex);
            }
            myAgent.send(reply); 
        } else{
            this.block();
        }
    }
}
