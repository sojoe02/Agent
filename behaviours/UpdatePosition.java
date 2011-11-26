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
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Position;
import presentation.Presentation;

public class UpdatePosition extends SimpleBehaviour {

    private static final MessageTemplate mt =
            MessageTemplate.MatchPerformative(ACLMessage.INFORM);
    
    Presentation pres;

    public UpdatePosition(Agent agent, Presentation pres) {
        super(agent);
        this.pres = pres;        
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
                Logger.getLogger(UpdatePosition.class.getName()).log(Level.SEVERE, null, ex);
            }            
        
        pres.updatePos(content.getName(), content.getPosX(), content.getPosY());
        
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
