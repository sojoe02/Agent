/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents;

import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zagadka
 */
public class StarterAgent extends Agent {


    protected void setup(){
        System.out.println("Hello I am : " + this.getLocalName());
        try {
            startNewAgent("agents.persons.GeneralPerson","flimsy",null);
        } catch (StaleProxyException ex) {
            Logger.getLogger(StarterAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*method for starting a new agent
     * 
     */
    private void startNewAgent(String className, String agentName, Object[] arguments) throws StaleProxyException {


        ((AgentController) getContainerController().createNewAgent(agentName, className, arguments)).start();
    }
}
