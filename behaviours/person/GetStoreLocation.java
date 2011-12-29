/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.person;

import agents.actors.GeneralPerson;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.StoreData;
import simulator.logic.Distributions;

/**
 *
 * @author Zagadka
 */
public class GetStoreLocation extends CyclicBehaviour implements agents.AgentInterface{

    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM),
            MessageTemplate.MatchConversationId("getstorelocation"));
    GeneralPerson agent;

    public GetStoreLocation(GeneralPerson agent) {
        this.agent = agent;

    }

    @Override
    public void action() {
        ACLMessage aclMessage = myAgent.receive(mt);

        
        if (aclMessage != null) {
            StoreData data = null;
            try {
                data = (StoreData) aclMessage.getContentObject();
            } catch (UnreadableException ex) {
                Logger.getLogger(GetDirections.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (data != null) {
                int[] destination = {data.getPosX(), data.getPosY()};
                //System.out.print(data.getSector() + ",");
                Random random = new Random();

                int value = Distributions.getPoisson(2);
                //For a normally distributed decision making:
                //Math.abs((int) (3 + random.nextGaussian() * 0.5));

                //System.out.println(value);


                if (data.getActiveCustomer() > 1) {
                    agent.sendMessage("Too many customers choosing another store");

                    ACLMessage reply = aclMessage.createReply();
                    reply.setPerformative(ACLMessage.INFORM);
                    reply.setConversationId("notcomming");

                    
                    /*
                     * Informing the collector agent that the agent is waiting.
                     */
                    agent.waitingToCollector();


                    agent.send(reply);
                    agent.doWait(2000);
                    agent.browse();
                } else {
                    agent.movetoStore(data.getSector(), destination);
                }
            } else {
                this.block();
            }


        } else {
            this.block();
        }

    }
}
