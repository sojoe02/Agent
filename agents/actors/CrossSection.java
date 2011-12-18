/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents.actors;

import agents.AgentInterface;
import behaviours.CrossSectionDirections;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import messages.AgentData;

/**
 *
 * @author Zagadka
 */
public class CrossSection extends Agent implements AgentInterface {

    int[] streets;
    String name;
    int posx;
    int posy;

    @Override
    public void setup() {
        
        System.out.println("Hallo World ! my name is " + this.getLocalName()
                + " i am a straight up 'crossection' agent.");
        
        Object[] args = getArguments();

        this.posx = Integer.parseInt(String.valueOf(args[0]).substring(0, 4));
        this.posy = Integer.parseInt(String.valueOf(args[0]).substring(4, 8));
        streets = new int[args.length];

        for (int i = 1; i < args.length; i++) {
            
            name += args[i];
            streets[i - 1] = Integer.parseInt(String.valueOf(args[i]));
        }
        sendPosition();
        registerService();
        addBehaviour(new CrossSectionDirections(this,posx,posy));
    }

    private void sendPosition() {
        AgentData position = new AgentData();
        position.setPosX(posx);
        position.setPosY(posy);
        position.setName(this.getLocalName());
        position.setType("cross");

        AID render = new AID(RENDERAGENT, AID.ISLOCALNAME);
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.addReceiver(render);
        try {
            msg.setContentObject(position);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        send(msg);
    }

    private void registerService() {
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(this.getAID());

        ServiceDescription sd = new ServiceDescription();
        sd.setType("CrossSection");
        sd.setName(name);

        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException e) {
            System.err.println(getLocalName()
                    + " registration with DF unsucceeded. Reason: " + e.getMessage());
            doDelete();
        }
    }
    
    
}
