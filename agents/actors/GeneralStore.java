/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents.actors;

/**
 *
 * @author Zagadka
 */
import behaviours.store.GiveItem;
import messages.Items;
import behaviours.store.GiveItemList;
import behaviours.store.GiveLocation;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import messages.AgentData;
import messages.Item;

public class GeneralStore extends Agent implements agents.AgentInterface {

    private int posx, posy, sector;    
    private HashMap<String, Items> stock = new HashMap<String, Items>();    

    @Override
    protected void setup() {

        Object[] args = getArguments();
        posx = Integer.parseInt(String.valueOf(args[0]).substring(0, 4));
        posy = Integer.parseInt(String.valueOf(args[0]).substring(4, 8));
        sector = Integer.parseInt(String.valueOf(args[1]));

        System.out.println("Hallo World ! my name is " + this.getLocalName()
                + " i am a straight up 'general store' agent. pos is" + posx + ":" + posy);

        sendPosition();
        registerService();
        getStock();
        addBehaviour(new GiveItemList(this,stock));
        addBehaviour(new GiveLocation(this,posx,posy,sector));
        addBehaviour(new GiveItem(this));
    }
    
    public Item takeoutItem(String key){
        Items items = stock.get(key);
        items.TakeOut();
        return(new Item(items.getPrice(),key));        
    }
    
    private void getStock(){
        //Starting all the stores:
        Random generator = new Random();
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader("src/generalitems.txt")));
            while (s.hasNextLine()) {
                Scanner s2 = new Scanner(s.nextLine());
                s2.useDelimiter(",");                
                int number = generator.nextInt(5);                
                String name = s2.next();                 
                int price = Integer.parseInt(s2.next());                
                stock.put(name, new Items(price, number));                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("src/generalitems.txt not found");
        } 
    }
    
    
    
    private void reStock(){
        Collection s = stock.values();
        //System.out.println(stores.size());
        Iterator<Items> sitr = s.iterator();
        Random generator = new Random();
        while (sitr.hasNext()) {
            int number = generator.nextInt(5);
            sitr.next().setNumber(number);
        }
    }

    private void registerService() {
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(this.getAID());

        ServiceDescription sd = new ServiceDescription();
        sd.setType("GeneralItems");
        sd.setName("GeneralItems");

        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException e) {
            System.err.println(getLocalName()
                    + " registration with DF unsucceeded. Reason: " + e.getMessage());
            doDelete();
        }
    }

    private void sendPosition() {
        AgentData position = new AgentData();
        position.setPosX(posx);
        position.setPosY(posy);
        position.setName(this.getLocalName());
        position.setType("store");

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
}
