/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messages;

/**
 *
 * @author Zagadka
 */
public class Items implements java.io.Serializable{

    private int price;
    private int number;

    public Items(int price, int number) {
        this.price = price;
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void TakeOut() {
        number--;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
