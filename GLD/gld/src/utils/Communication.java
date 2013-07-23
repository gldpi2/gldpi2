/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.*;
import java.net.*;

/**
 *
 * @author gld-pi2
 */
public class Communication {

    public static class UDPClient {

        public static void sendData(String ipDest, int port, String peak, String offpeak) throws Exception {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(ipDest);
            byte[] sendData = new byte[1024];
            String sentence = "Peak: " + peak + "\nOffpeak: " + offpeak;
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            clientSocket.send(sendPacket);
            clientSocket.close();
        }
    }

    public static class UDPServer {

        public void serveForever() throws Exception {
            
            DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                System.out.println("RECEIVED: " + sentence);
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
            }
            
        }
    
    }

    public static void main(String args[]) throws Exception {
        
        UDPServer server = new UDPServer();
        server.serveForever();
        
    }
}
