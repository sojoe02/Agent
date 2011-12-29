package agents;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zagadka
 */
public interface AgentInterface {
    
    public static final int MOVEDELAY = 1000;
    public static final int SPEECHDELAY = 10000;
    
    public static final String RENDERAGENT = "Render";
    public static final String PUPPETMASTER = "MasterControl";
    public static final String SERVICEPROVIDER = "Servicer";
    public static final String ACTORCONTROL = "ActorController";
    public static final String COLLECTOR = "DataCollector";
    
    public static final int resX = 1024;
    public static final int resY = 768;
    
}
