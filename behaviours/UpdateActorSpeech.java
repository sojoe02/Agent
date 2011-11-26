/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentation.Presentation;

/**
 *
 * @author Zagadka
 */
public class UpdateActorSpeech extends SimpleBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
    
    Presentation pres;

    public UpdateActorSpeech(Agent agent, Presentation pres) {
        super(agent);        
        this.pres = pres;
    }

    @Override
    public void action() {
        ACLMessage aclMessage = myAgent.receive(mt);
        if (aclMessage != null) {
            pres.updateSpeech(aclMessage.getSender().getLocalName(),aclMessage.getContent());
            pres.repaint();
        } else {
            this.block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }

}
