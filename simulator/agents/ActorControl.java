/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator.agents;

import agents.AgentInterface;
import behaviours.simulation.StartNewPerson;
import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Zagadka
 */
public class ActorControl extends Agent implements AgentInterface {

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
        addBehaviour(new StartNewPerson(this));
    }
    
    public void startNewPerson() throws StaleProxyException {
        
        String agentName = "Stan";        
        Object[] args = {"00500400", "5000"};
        
        startNewAgent("agents.actors.GeneralPerson", agentName, args);
        
//        agentName = "bingo";        
//        Object[] args2 = {"07770470", "5000"};
//        
//        startNewAgent("agents.actors.GeneralPerson", agentName, args2);
        
    }
    
    private void startNewAgent(String className, String agentName, Object[] arguments) throws StaleProxyException {
        ((AgentController) getContainerController().createNewAgent(agentName, className, arguments)).start();
    }
}