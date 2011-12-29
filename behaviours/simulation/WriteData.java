/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.simulation;

import jade.core.behaviours.TickerBehaviour;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import simulator.agents.Collector;

/**
 *
 * @author sojoe
 */
public class WriteData extends TickerBehaviour {

    Collector agent;

    public WriteData(Collector agent, long period) {
        super(agent, period);
        this.agent = agent;
    }

    @Override
    protected void onTick() {

        try {
            
            BufferedWriter out = new BufferedWriter(
                    new FileWriter("congestion.csv", true));
            
            System.out.println(agent.getCongestion());
            out.write(Integer.toString(agent.getCongestion()) + ",\n");
            agent.resetCongestion();

            out.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteData.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    {
    }
}
