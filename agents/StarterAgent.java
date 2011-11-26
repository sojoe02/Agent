/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents;

import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Zagadka
 */
public class StarterAgent extends Agent implements AgentInterface {

    public static Map<Integer, String> PeopleAgentPos =
            new HashMap<Integer, String>(50);
    public static Map<Integer, Double> House =
            new HashMap<Integer, Double>(50);

    @Override
    protected void setup() {
        System.out.println("Hello I am : " + this.getLocalName());

        //Start render agent:
        try {
            startNewAgent("agents.RenderAgent", RENDERAGENT, null);
        } catch (StaleProxyException ex) {
            Logger.getLogger(StarterAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            startNewAgent("agents.actors.GeneralPerson","Stan", null);
        } catch (StaleProxyException ex) {
            Logger.getLogger(StarterAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                try {
            startNewAgent("agents.actors.GeneralPerson","Ollie", null);
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
