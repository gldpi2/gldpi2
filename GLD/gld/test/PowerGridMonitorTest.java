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
    public void hello() {
        try {
            PowerGridMonitor powerGridMonitor = new PowerGridMonitor();
            Thread threadMonitor = new Thread(powerGridMonitor);

            threadMonitor.start();

            threadMonitor.join();

        } catch (InterruptedException ex) {
            Logger.getLogger(PowerGridMonitorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}