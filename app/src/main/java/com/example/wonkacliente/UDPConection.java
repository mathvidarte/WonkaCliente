package com.example.wonkacliente;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPConection extends Thread {

    private DatagramSocket socket;

    public void run () {

        try {
            socket = new DatagramSocket(6001);

            while (true) {

                byte[] buffer = new byte[100];

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                Log.d("IMWATINGMFK", "WAITIIIING");

                socket.receive(packet);

                String mensaje = new String(packet.getData()).trim();
                Log.d("YEAHHHH", "YEAAAAAAAH"+mensaje);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage (String mensaje) {
        new Thread (
                () -> {
                    try {
                        InetAddress ip = InetAddress.getByName("192.168.1.50");
                        DatagramPacket packet = new DatagramPacket (mensaje.getBytes(), mensaje.getBytes().length, ip, 5001);
                        socket.send(packet);
                        Log.d("POFAVOOOOOO", "POFAVOOOOO");

                    } catch (UnknownHostException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}
