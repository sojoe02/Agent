/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.simulation;

import jade.core.behaviours.CyclicBehaviour;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;


import simulator.agents.Collector;


/**
 *
 * @author sojoe
 */
public class RCongestion extends CyclicBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM),
            MessageTemplate.MatchConversationId("personwaiting"));
    
    Collector agent;

    public RCongestion(Collector agent) {
        this.agent = agent;
        
    }

 
    @Override
    public void action() {        
        
        
        ACLMessage aclMessage = agent.receive(mt);

        
        //ACLMessage aclMessage = agent.receive(mt);

        if (aclMessage != null) {
            agent.addCongestion();
            //agent.getCongestion();
            
            
        } else {
            this.block();
        }
    }
}
