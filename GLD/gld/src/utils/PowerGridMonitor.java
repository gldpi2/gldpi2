package utils;

import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wagner
 */

public class PowerGridMonitor implements Runnable {
    /**
     *  Rotina que monitora os dados recebidos da rede elétrica.
     */
    @Override
    public void run(){
        DatagramSocket serverSocket;
        try {
            byte[] receiveData = new byte[1024];
            
            serverSocket = new DatagramSocket(9876);
            
            while(true){
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                
                serverSocket.receive(receivePacket);
            
                String sentence = new String(receivePacket.getData());
                System.out.println("RECEIVED: " + sentence);
            }
        } catch (SocketException ex) {
            Logger.getLogger(PowerGridMonitor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PowerGridMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     *  Método para armazenar medição no banco de dados.
     */
    private void saveMeasurementInDatabase(double current, double voltage, double frequency){
        DatabaseInterface dbInterface = new DatabaseInterface();
        
        double potency;
        double powerFactor;
        
        dbInterface.connect();
        Statement statement = dbInterface.cre
        
        
        
        dbInterface.disconnect();
    }
}
