/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.store;

import messages.Items;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Zagadka
 */
public class GiveItemList extends CyclicBehaviour{
    
    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST)
            ,MessageTemplate.MatchConversationId("GeneralItems"));
    
    HashMap stock;
    
    public GiveItemList(Agent agent, HashMap stock) {
        super(agent);                
        this.stock = stock;
    }

    @Override
    public void action() {
        ACLMessage aclMessage = myAgent.receive(mt);
        

        if (aclMessage != null) {            
            ACLMessage reply = aclMessage.createReply();
            reply.setConversationId("sendingitemlist");
            try {
                reply.setContentObject(stock);
            } catch (IOException ex) {
                Logger.getLogger(GiveItemList.class.getName()).log(Level.SEVERE, null, ex);
            }
            myAgent.send(reply);            

        } else {
            this.block();
        }
    }
    
}
