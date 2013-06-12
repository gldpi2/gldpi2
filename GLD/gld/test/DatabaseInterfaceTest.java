/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    String host = "gld.zapto.org";
    String database = "banco_teste";
    String user = "admin";
    String pass = "admin";
    
    public DatabaseInterfaceTest() {
        
    }
    
      
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
        
    }
    
    @Test
    public void configureTest(){
        this.dbInterface.configureConnection(host, database, user, pass);
        
        assertTrue(true);
    }
    
    @Test
    public void connectionTest() {
        this.dbInterface.configureConnection(host, database, user, pass);
        this.dbInterface.connect();
        
        assertTrue(dbInterface.isConnected());
    }
    
    @Test
    public void disconnectTest(){
        this.dbInterface.configureConnection(host, database, user, pass);
        this.dbInterface.connect();
        this.dbInterface.disconnect();
        
        assertFalse(dbInterface.isConnected());
    }
}