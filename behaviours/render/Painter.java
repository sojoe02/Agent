/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviours.render;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import presentation.Presentation;

/**
 *
 * @author Zagadka
 */
public class Painter extends TickerBehaviour {

    Presentation pres;


    public Painter(Agent agent, long period,Presentation pres) {
        super(agent,period);
        this.pres = pres;
    }

    @Override
    protected void onTick() {
        pres.repaint();
    }
}
