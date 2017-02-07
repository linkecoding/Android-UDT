package com.sxh.testudt.hole;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;


public class UDPUtil {
    
    public static void sendMsg(String msg, String host, String port, DatagramSocket client){
        byte[] msgBuffer = msg.getBytes();
        SocketAddress targetAddress = new InetSocketAddress(host, Integer.parseInt(port));
        try {
            DatagramPacket msgPacket = new DatagramPacket(msgBuffer, 0, msgBuffer.length, targetAddress);
            client.send(msgPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static DatagramPacket receiveMsg(DatagramSocket client){
        byte[] msgBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(msgBuffer,
                msgBuffer.length);
        try {
            client.receive(receivePacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receivePacket;
    }

    
    public static String[] convertStrToIPAndPort(String str){
        String[] res = new String[2];
        String[] params = str.split(",");
        
        String host = params[0].substring(5);
        String port = params[1].substring(5);

        res[0] = host;
        res[1] = port;
        return res;
    }
}
