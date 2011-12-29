/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.simulation;


import jade.core.behaviours.CyclicBehaviour;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;


import simulator.agents.Controller;

/**
 *
 * @author Zagadka
 */
public class ReceiveCrossData extends CyclicBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM),
            MessageTemplate.MatchConversationId("fullcrosssectiondata"));
    
    Controller agent;

    public ReceiveCrossData(Controller agent) {
        this.agent = agent;

    }

    @Override
    public void action() {

        ACLMessage aclMessage = myAgent.receive(mt);

        if (aclMessage != null) {
            agent.addNewPosition(aclMessage.getContent());            
        } else {
            this.block();
        }
    }
}
