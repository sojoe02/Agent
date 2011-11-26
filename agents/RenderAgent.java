/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents;

import behaviours.UpdateActorSpeech;
import behaviours.UpdatePosition;
import jade.core.Agent;
import presentation.Frame;
import presentation.Presentation;


/**
 *
 * @author Zagadka
 */
public class RenderAgent extends Agent{
    
    Presentation pres;   
    Frame frame;
    
    @Override
    public void setup(){
        
        System.out.println("Hello I am the graphics render agent my name is: " 
                + this.getLocalName());        
       
        pres = new Presentation();   
        frame = new Frame(pres);        
        
        frame.showGui();           
        
        addBehaviour(new UpdatePosition(this, pres));        
        addBehaviour(new UpdateActorSpeech(this,pres));
    }    

}
