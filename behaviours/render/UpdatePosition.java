/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.render;

/**
 *
 * @author Zagadka
 */
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.AgentData;
import presentation.Presentation;

public class UpdatePosition extends CyclicBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM),
            MessageTemplate.MatchConversationId("positionupdate"));
    Presentation pres;

    public UpdatePosition(Agent agent, Presentation pres) {
        super(agent);
        this.pres = pres;
    }

    @Override
    public void action() {
        ACLMessage aclMessage = myAgent.receive(mt);

        if (aclMessage != null) {
            //System.out.println(myAgent.getLocalName()+": I receive message.\n"+aclMessage); 
            AgentData content = null;
            try {
                content = (AgentData) aclMessage.getContentObject();
            } catch (UnreadableException ex) {
                Logger.getLogger(UpdatePosition.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (content.getType().equals("person")) {
                pres.updatePos(content.getName(), content.getPosX(), content.getPosY());
            }
                
                
//            } else if (content.getType().equals("store")) {
//                pres.addStore(content.getName(), content.getPosX(), content.getPosY());
//                System.out.println(content.getName());
//            }
//            else if (content.getType().equals("store")) {
//                pres.addStore(content.getName(), content.getPosX(), content.getPosY());
//                System.out.println(content.getName());
//            }

            //pres.repaint();


        } else {
            this.block();
        }
    }

}
