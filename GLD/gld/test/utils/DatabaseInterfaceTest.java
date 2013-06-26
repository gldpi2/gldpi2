package utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wagner
 */
public class DatabaseInterfaceTest {

    DatabaseInterface dbInterface;

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
        this.dbInterface = new DatabaseInterface();
        this.dbInterface.connect();

        assertTrue("O status do banco de dados deveria ser True (conectado)", dbInterface.isConnected());
    }

    @Test
    public void disconnectTest() {
        this.dbInterface = new DatabaseInterface();
        this.dbInterface.connect();
        this.dbInterface.disconnect();

        assertFalse("O status do banco de dados deveria ser Falso (desconectado)", dbInterface.isConnected());
    }
}