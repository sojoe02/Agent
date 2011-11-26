/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents.actors;

/**
 *
 * @author Zagadka
 */
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import messages.Position;

public class GeneralPerson extends Agent implements agents.AgentInterface {

    int posx, posy;
    

    @Override
    protected void setup() {
        Object[] args = getArguments();
        posx = Integer.parseInt(String.valueOf(args[0]).substring(0, 3));
        posy = Integer.parseInt(String.valueOf(args[0]).substring(3, 6));
        
        System.out.println("Hallo World ! my name is " + this.getLocalName()
                + " i am a straight up 'general person' agent.");
        sendPosition();
    }

    protected void updatePosition() {
    }

    private void sendPosition() {
//        AID r = new AID(RENDERAGENT, AID.ISLOCALNAME);
//        ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
//        aclMessage.addReceiver(r);
//        aclMessage.setContent("Hello! How are you?");
//        this.send(aclMessage);

        Position position = new Position();
        position.setPosX(posx);
        position.setPosY(posy);
        position.setName(this.getLocalName());

        AID render = new AID(RENDERAGENT, AID.ISLOCALNAME);
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(render);
        try {
            msg.setContentObject(position);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        send(msg);
    }
}
