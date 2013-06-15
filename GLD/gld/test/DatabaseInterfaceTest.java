import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.DatabaseInterface;

/**
 *
 * @author wagner
 */
public class DatabaseInterfaceTest {
    DatabaseInterface dbInterface = new DatabaseInterface();

    public DatabaseInterfaceTest() {
        
    }
      
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
            
    }
    
    @Test
    public void connectionTest() {
        this.dbInterface.connect();
        
        assertTrue("O status do banco de dados deveria ser True (conectado)", dbInterface.isConnected());
    }
    
    @Test
    public void disconnectTest(){
        this.dbInterface.connect();
        this.dbInterface.disconnect();
        
        assertFalse("O status do banco de dados deveria ser Falso (desconectado)", dbInterface.isConnected());
    }
}