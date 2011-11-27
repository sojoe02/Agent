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
    int wait = 3500;

    @Override
    protected void setup() {
        Object[] args = getArguments();
        posx = Integer.parseInt(String.valueOf(args[0]).substring(0, 3));
        posy = Integer.parseInt(String.valueOf(args[0]).substring(3, 6));

        System.out.println("Hallo World ! my name is " + this.getLocalName()
                + " i am a straight up 'general person' agent.");
        sendPosition();

        this.doWait(wait);

        sendMessage("Hello I am a general person agent");

        this.doWait(wait);

        sendMessage("My name is : " + this.getLocalName());

        this.doWait(wait);

        sendMessage("I represent a potential customer");

        this.doWait(wait);

        sendMessage("I just arrived in the this city and I want to buy something");

        this.doWait(wait);

        sendMessage("So I make a request on the item type I need");

        this.doWait(wait + 1000);

        sendMessage("Hey thats a store: 'Ollie the Store'");

        this.doWait(wait);

        sendMessage("It even provides the service i need, I'll go and have a look");

        this.doWait(wait);

        sendMessage("dumdidumdum...");

        while (posx < 800) {
            this.doWait(10);
            posx++;
            sendPosition();
        }
        
        sendMessage("ladidadida...");

        while (posy < 500) {
            this.doWait(10);
            posy++;
            sendPosition();


        }

    }

    private void sendMessage(String message) {
        AID r = new AID(RENDERAGENT, AID.ISLOCALNAME);
        ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
        aclMessage.addReceiver(r);
        aclMessage.setContent(message);
        this.send(aclMessage);
    }

    private void sendPosition() {
        Position position = new Position();
        position.setPosX(posx);
        position.setPosY(posy);
        position.setName(this.getLocalName());
        position.setType("person");

        AID render = new AID(RENDERAGENT, AID.ISLOCALNAME);
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(render);
        try {
            msg.setContentObject(position);
        } catch (Exception ex) {
        }

        send(msg);
    }
}
