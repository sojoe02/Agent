/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.store;

import jade.core.behaviours.CyclicBehaviour;
import messages.Items;
import agents.actors.GeneralStore;
import behaviours.person.GetDirections;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Item;

/**
 *
 * @author Zagadka
 */
public class GiveItem extends CyclicBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
            MessageTemplate.MatchConversationId("buyingitem"));
    GeneralStore agent;

    public GiveItem(GeneralStore agent) {
        this.agent = agent;
    }

    @Override
    public void action() {

        ACLMessage aclMessage = myAgent.receive(mt);

        if (aclMessage != null) {
            
            Item data = agent.takeoutItem(aclMessage.getContent());

            if (data != null) {
                System.out.println(data.getCost());

                ACLMessage reply = aclMessage.createReply();

                reply.setConversationId("giveitem");
                // reply.setPerformative(ACLMessage.ACCEPT_PROPOSAL);

                try {
                    reply.setContentObject(data);
                } catch (IOException ex) {
                    Logger.getLogger(GiveItemList.class.getName()).log(Level.SEVERE, null, ex);
                }
                myAgent.send(reply);
            } else {
                this.block();
            }
        } else {
            this.block();
        }
    }
}
