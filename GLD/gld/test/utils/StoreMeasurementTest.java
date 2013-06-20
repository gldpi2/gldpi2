package utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.DatabaseInterface;
import utils.StoreMeasurement;

/**
 *
 * @author wagner
 */
public class StoreMeasurementTest {

    DatabaseInterface dbInterface = new DatabaseInterface();

    public StoreMeasurementTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void insertMeasurementInDatabaseTest() {
        String sql = "INSERT INTO meter (id_environment) VALUES (?)";
        String[] params = dbInterface.getParamsString("1");

        dbInterface.connect();
        dbInterface.insert(sql, params);

        int lastId = dbInterface.getLastId("meter");
        dbInterface.disconnect();

        String data = lastId + ",3.0,4.0,9.1,";
        StoreMeasurement sm = new StoreMeasurement(data);

        int result = sm.storeMeasurementInDatabase();

        assertEquals("A quantidade de linhas afetadas deveria ser 1.", 1, result);
    }
}