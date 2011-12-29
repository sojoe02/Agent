/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator.logic;

import java.util.Random;

/**
 *
 * @author Zagadka
 */
public class Distributions {
    
    //For a normally distributed decision making:
    
    public static int getNormal(double mean, double variance){
        Random random = new Random();
        return Math.abs((int) (mean + random.nextGaussian() * variance));
    }
                
    
        /*
     * For Poisson based decision making:
     */
        public static int getPoisson(double lambda) {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= Math.random();
        } while (p > L);

        return k - 1;
    }
}
