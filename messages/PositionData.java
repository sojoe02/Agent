/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messages;

/**
 *
 * @author Zagadka
 */
public class PositionData implements java.io.Serializable {

    private int posx;
    private int posy;
    //private int[] section;
    public PositionData(int posx, int posy){
        this.posx = posx;
        this.posy = posy;
        //this.section = section;
    }
    
    public int getPosX() {
        return posx;
    }

    public int getPosY() {
        return posy;
    }
//    public int[] getSection(){
//        return section;
//    }
}
