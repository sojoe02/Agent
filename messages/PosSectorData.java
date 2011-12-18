/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messages;

/**
 *
 * @author Zagadka
 */
public class PosSectorData extends PositionData{
    
    int sector;
    
    public PosSectorData(int posx,int posy, int sector){
        super(posx, posy);
        this.sector = sector;
    }
    
    public int getSector(){
        return sector;
    }
}
