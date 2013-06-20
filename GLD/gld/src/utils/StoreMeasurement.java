package utils;

import java.util.StringTokenizer;

/**
 *
 * @author wagner
 */
public class StoreMeasurement implements Runnable {

    String data;

    public StoreMeasurement(String data) {
        this.data = data;
    }

    /**
     * Método para armazenar medição no banco de dados.
     */
    @Override
    public void run() {
        storeMeasurementInDatabase();
    }

    public int storeMeasurementInDatabase() {
        DatabaseInterface dbInterface = new DatabaseInterface();
        String idMeter, flow, tension;
        String sql;
        String params[];
        int result;

        StringTokenizer st = new StringTokenizer(data, ",");

        idMeter = st.nextToken();
        flow = st.nextToken();
        tension = st.nextToken();

        sql = "INSERT INTO mensuration (id_meter, flow, tension) VALUES (?, ?, ?)";

        params = dbInterface.getParamsString(idMeter, flow, tension);

        dbInterface.connect();
        result = dbInterface.insert(sql, params);
        dbInterface.disconnect();

        return result;
    }
}
