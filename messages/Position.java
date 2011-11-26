/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messages; 

/**
 *
 * @author Zagadka
 */
public class Position implements java.io.Serializable{
    private int posx;
    private int posy;
    private String name;
    
    public void setPosX(int posx){
        this.posx = posx;
    }
    
    public void setPosY(int posy){
        this.posy = posy;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public int getPosX(){
        return posx;
    }
    
    public int getPosY(){
        return posy;
    }
    
    @Override
    public String toString(){
        return "name is: "+ name +"\tposition x: " + getPosX() + "\t position y: " + getPosY();
    }
}
