/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator.logic;

/**
 *
 * @author Zagadka
 */
public class Move {

    public int[] getNextPos(int[] to, int[] from, int v, int time) {

        double longNow = (double)from[0];
        double latNow = (double)from[1];
        double longEnd = (double)to[0];
        double latEnd = (double)to[1];
        double angle = Math.atan2(latEnd - latNow, longEnd - longNow);

        double vLong = v * Math.cos(angle) * 0.0001;
        double vLat = v * Math.sin(angle) * 0.0001;

        double nextLong =  longNow + (double)time * vLong;
        double nextLat =  latNow + (double)time * vLat;

        int[] coor = {(int)nextLong,(int)nextLat};

        return coor;
    }
}
