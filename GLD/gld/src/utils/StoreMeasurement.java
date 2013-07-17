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
        String sql;
        String params[];
        int result;

        StringTokenizer st = new StringTokenizer(data, ",");

        String idMeter = st.nextToken();
        String timestamp = st.nextToken();
        String bateryTension = st.nextToken();
        String aeroGeneratorFlow = st.nextToken();
        String panelFlow = st.nextToken();
        String bateryLoad = st.nextToken();
        String energyAvailable = st.nextToken();
        String activeSystem = st.nextToken();
        String tension = st.nextToken();
        String flow = st.nextToken();
        String powerFactor = st.nextToken();
        String frequency = st.nextToken();


        sql = "INSERT INTO mensuration (id_meter, flow, tension, power_factor, frequency, flow_panel, "
                + "flow_aero_generator, batery_tension, batery_Load, active_system, "
                + "energy_available, timestamp) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        params = dbInterface.getParamsString(idMeter, flow, tension, powerFactor, frequency,
                panelFlow, aeroGeneratorFlow, bateryTension, bateryLoad, activeSystem,
                energyAvailable, timestamp);

        dbInterface.connect();
        result = dbInterface.insert(sql, params);
        dbInterface.disconnect();

        return result;
    }
}
