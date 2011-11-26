/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours;

/**
 *
 * @author Zagadka
 */
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Position;

public class GetPosition extends CyclicBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.MatchPerformative(ACLMessage.INFORM);

    public GetPosition(Agent agent) {
        super(agent);
    }

    @Override
    public void action() {
    ACLMessage aclMessage = myAgent.receive(mt);
    
    if (aclMessage!=null) { 
        //System.out.println(myAgent.getLocalName()+": I receive message.\n"+aclMessage); 
        Position content = null;
            try {
                content = (Position)aclMessage.getContentObject();
            } catch (UnreadableException ex) {
                Logger.getLogger(GetPosition.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println(content);                
        
        
    } else { 
        this.block(); 
      }    
    }

    
}
