package utils;

import java.util.StringTokenizer;

/**
 *
 * @author wagner
 */
public class StoreMeasurement implements Runnable {

    String data;

    /**
     * Método construtor da classe StoreMeasurement
     *
     * @param data String Dados recebidos da rede em forma de string.
     */
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

    /**
     * Método que armazena a medição realizada no banco de dados.
     *
     * @return int Retorna a quantidade de linhas inseridas no banco de dados.
     */
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
