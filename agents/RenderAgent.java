/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents;

import behaviours.render.*;
import jade.core.Agent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import presentation.Frame;
import presentation.Presentation;

/**
 *
 * @author Zagadka
 */
public class RenderAgent extends Agent {

    Presentation pres;
    Frame frame;
    private int[] sposx, sposy;

    @Override
    public void setup() {

        System.out.println("Hello I am the graphics render agent my name is: "
                + this.getLocalName());

        pres = new Presentation();
        frame = new Frame(pres);

        frame.showGui();
        
        //drawMap();
        //addBehaviour(new DrawMap(this,pres,sposx,sposy));
        addBehaviour(new UpdatePosition(this, pres));
        addBehaviour(new UpdateActorSpeech(this, pres));
        addBehaviour(new AddActor(this, pres));
        addBehaviour(new Painter(this,50, pres));
    }

    public void drawMap() {
        
        ArrayList<String> line = new ArrayList<String>();
        
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader("src/shops.txt")));
            while (s.hasNext()) {
                //set delimiter to ,<space>
                s.useDelimiter(",\\s");
                line.add(s.next());                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("src/shops.txt not found");
        }
        
        sposx = new int[line.size()/2];
        sposy = new int[line.size()/2];
        int j = 0;
        int k = 0;
        
        for(String i : line){
            if (j==0){
                sposx[k] = Integer.parseInt(i);
                j++;
            } else if(j==1){
                sposy[k] = Integer.parseInt(i);
                j=0;
                k++;
            }
        }        
    }
}
