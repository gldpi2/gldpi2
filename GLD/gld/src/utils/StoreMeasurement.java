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
     *  Método para armazenar medição no banco de dados.
     */
    @Override
    public void run(){
        DatabaseInterface dbInterface = new DatabaseInterface();
        String idMeter, flow, tension, frequency;
        String sql;
        String params[];

        StringTokenizer st = new StringTokenizer(data, "," );
        
        idMeter = st.nextToken();
        flow = st.nextToken();
        tension = st.nextToken();
        frequency = st.nextToken();
        
        System.err.println(frequency);
        
        sql = "INSERT INTO mensuration (id_meter, flow, tension, frequency) VALUES (?, ?, ?, ?)";
        
        params = dbInterface.getParamsString(idMeter, flow, tension, frequency);
        
        dbInterface.connect();
        dbInterface.insert(sql, params);
        dbInterface.disconnect();
    }
}
