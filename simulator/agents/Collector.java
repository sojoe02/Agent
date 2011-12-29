/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator.agents;

import agents.AgentInterface;
import behaviours.simulation.RCongestion;

import behaviours.simulation.WriteData;
import jade.core.Agent;


/**
 *
 * @author sojoe
 */
public class Collector extends Agent implements AgentInterface{

    int congestionVar = 0;

    @Override
    public void setup() {
        System.out.println("HEY");
        
        System.out.println("EY");
        addBehaviour(new RCongestion(this));
        addBehaviour(new WriteData(this, 5000));
        
        doWait(1000);
        
//        try {
//            writeCongestion(1000,300);
//        } catch (IOException ex) {
//            Logger.getLogger(Collector.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

//    public void writeCongestion(int tick, int stopThress) throws IOException {
//
//        int i = 0;
//        
//        try {
//            BufferedWriter out = new BufferedWriter(new FileWriter("congestion"));
//            while (i < stopThress) {
//                System.out.println(congestionVar);
//                out.write(congestionVar + ",");
//                congestionVar = 0;
//                //out.newLine();                
//                doWait(tick);
//                i++;
//            }            
//            out.close();
//        } catch (IOException e) {
//        }
//
//
//    }
    
    public int getCongestion(){        
        return this.congestionVar;
    }
    
    public void resetCongestion(){
        this.congestionVar = 0;
    }

    public void addCongestion() {

        this.congestionVar++;


    }
}
