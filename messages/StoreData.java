/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messages;

/**
 *
 * @author Zagadka
 */
public class StoreData extends PositionData{
    
    int sector;
    int activeCustomer;
    
    public StoreData(int posx,int posy, int sector,int activeCustomer){
        super(posx, posy);
        this.sector = sector;
        this.activeCustomer = activeCustomer;
    }
    
    public int getSector(){
        return sector;
    }
    
    public int getActiveCustomer(){
        return activeCustomer;
    }
}
