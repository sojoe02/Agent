/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messages;

/**
 *
 * @author Zagadka
 */
public class Item implements java.io.Serializable{
    
    private int cost;    
    private String name;

    public Item(int cost, String name) {
        this.cost = cost;        
        this.name = name;
    }    
    public int getCost(){
        return cost;
    }    
}
