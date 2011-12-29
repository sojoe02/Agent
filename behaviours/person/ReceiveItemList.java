/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.person;

import messages.Items;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.MessageTemplate;
import agents.actors.GeneralPerson;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.PositionData;

/**
 *
 * @author Zagadka
 */
public class ReceiveItemList extends CyclicBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM),
            MessageTemplate.MatchConversationId("sendingitemlist"));
    GeneralPerson agent;

    public ReceiveItemList(Agent agent) {
        this.agent = (GeneralPerson) agent;
    }

    @Override
    public void action() {
        ACLMessage aclMessage = myAgent.receive(mt);


        if (aclMessage != null) {
            HashMap<String, Items> stock = null;
            try {
                stock = (HashMap) aclMessage.getContentObject();
            } catch (UnreadableException ex) {
                Logger.getLogger(GetDirections.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
             * Choose an item from the stock at random, and make the person choose it:
             */
            //System.out.println(aclMessage.getSender().getLocalName());
            if (stock != null) {
                Object[] s = stock.keySet().toArray();
                Random rand = new Random();
                agent.chooseItem(s[rand.nextInt(s.length)].toString());
            } else{
                //System.out.println("NULL DETECTED");
                this.block();
            }

        } else {
            this.block();
        }
    }
}
