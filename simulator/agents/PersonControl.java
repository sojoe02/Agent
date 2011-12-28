/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator.agents;

import agents.AgentInterface;
import behaviours.simulation.PersonControlTick;
import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zagadka
 */
public class PersonControl extends Agent implements AgentInterface {

    ArrayList<String> usedNames = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();

    @Override
    public void setup() {
        
        System.out.println("Hello I am the Actor Controller agent my name is: "
                + this.getLocalName());
        
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader("src/names.txt")));
            while (s.hasNext()) {
                //set delimiter to ,<space>
                s.useDelimiter(",\\s");
                names.add(s.next());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("src/names.txt not found");
        }
        try {
            //doWait(20000);
            
            startNewPerson();
        } catch (StaleProxyException ex) {
            Logger.getLogger(PersonControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        addBehaviour(new PersonControlTick(this));
    }
    
    
    
    public void startNewPerson() throws StaleProxyException {
        
        String agentName = "Stan";        
        Object[] args = {"00500400", "5000","2"};
        
        startNewAgent("agents.actors.GeneralPerson", agentName, args);
        
        agentName = "bingo";        
        Object[] args2 = {"07770470", "5000","3"};
        
        startNewAgent("agents.actors.GeneralPerson", agentName, args2);
        
        
        agentName = "bingo2";        
        Object[] args3 = {"07770470", "5000","3"};
        
        startNewAgent("agents.actors.GeneralPerson", agentName, args3);
        
        
        agentName = "bingo3";        
        Object[] args4 = {"07770470", "5000","3"};
        
        startNewAgent("agents.actors.GeneralPerson", agentName, args4);
        
    }
    
    private void startNewAgent(String className, String agentName, Object[] arguments) throws StaleProxyException {
        ((AgentController) getContainerController().createNewAgent(agentName, className, arguments)).start();
    }
}