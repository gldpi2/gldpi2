/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    public void configureTest(){
        this.dbInterface.configureConnection("localhost", "banco_teste", "root", "root");
        
        assertTrue(true);
    }
    
    @Test
    public void connectionTest() {
        this.dbInterface.configureConnection("localhost", "banco_teste", "root", "root");
        this.dbInterface.connect();
        
        assertTrue(dbInterface.isConnected());
    }
    
    @Test
    public void disconnectTest(){
        this.dbInterface.configureConnection("localhost", "banco_teste", "root", "root");
        this.dbInterface.connect();
        this.dbInterface.disconnect();
        
        assertFalse(dbInterface.isConnected());
    }
}