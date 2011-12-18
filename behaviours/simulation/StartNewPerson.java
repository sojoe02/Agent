/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.simulation;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.AgentData;
import simulator.agents.ActorControl;

/**
 *
 * @author Zagadka
 */
public class StartNewPerson extends CyclicBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
    ActorControl agent;

    public StartNewPerson(Agent agent) {        
        this.agent = (ActorControl) agent;        
    }

    @Override
    public void action() {
        ACLMessage aclMessage = agent.receive(mt);
        if (aclMessage != null) {
            if (aclMessage != null) {
                try {                    
                    agent.startNewPerson();
                } catch (StaleProxyException ex) {
                    Logger.getLogger(StartNewPerson.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                this.block();
            }            
        }
    }
}
