/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator.logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sojoe
 */
public class Writedata {

    private static String congestionVar;

    public static synchronized void writeCongestion(int data) throws IOException {





        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("congestion"));

            out.write(data + ",");

            out.close();
        } catch (IOException e) {
        }


    }
}
