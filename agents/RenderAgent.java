/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents;

import behaviours.GetPosition;
import jade.core.Agent;
import presentation.Presentation;


/**
 *
 * @author Zagadka
 */
public class RenderAgent extends Agent{
    
    Presentation pres; 
    
    
    @Override
    public void setup(){
        System.out.println("Hello I am the graphics render agent my name is: " 
                + this.getLocalName());
        
        pres = new Presentation();
        
        pres.showGui();
        
        addBehaviour(new GetPosition(this));
        
    }
    
    
    public void addNewActor(){
        
    }
    
    public void updatePeoplePos(){
        
    }
}
