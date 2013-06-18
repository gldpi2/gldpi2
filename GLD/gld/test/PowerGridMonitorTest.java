/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.PowerGridMonitor;

/**
 *
 * @author wagner
 */
public class PowerGridMonitorTest {
    
    public PowerGridMonitorTest() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test(){
        PowerGridMonitor monitor = new PowerGridMonitor();
        
        Thread monitorThread = new Thread(monitor);
        
        monitorThread.start();
        try {
            monitorThread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(PowerGridMonitorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}