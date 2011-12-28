/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.render;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import presentation.Presentation;

/**
 *
 * @author Zagadka
 */
public class UpdateActorSpeech extends SimpleBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM)
            ,MessageTemplate.MatchConversationId("conversation"));
    Presentation pres;

    public UpdateActorSpeech(Agent agent, Presentation pres) {
        super(agent);
        this.pres = pres;
    }

    @Override
    public void action() {
        ACLMessage aclMessage = myAgent.receive(mt);
        if (aclMessage!=null) {
            pres.updateSpeech(aclMessage.getSender().getLocalName(), aclMessage.getContent());
            //pres.repaint();
        } else {
            this.block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
