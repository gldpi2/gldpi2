package utils;

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
            serverSocket = new DatagramSocket(9876);
            
            while(true){
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                
                serverSocket.receive(receivePacket);
            
                String data = new String(receivePacket.getData());
                
                Logger.getLogger(PowerGridMonitor.class.getName()).log(Level.INFO, null, "RECEIVED: " + data);
                
                Thread storeMeasurementThread = new Thread(new StoreMeasurement(data));
                storeMeasurementThread.start();
            }
        } catch (SocketException ex) {
            Logger.getLogger(PowerGridMonitor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PowerGridMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
