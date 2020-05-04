package com.pandaroid.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @author pandaroid
 */
public class BIOClientDemo {

    private static final String IP = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(IP, PORT);
            OutputStream os = socket.getOutputStream();
            String sendStr = "[BIOClientDemo main] 随机 UUID: " + UUID.randomUUID().toString();
            System.out.println(sendStr);
            os.write(sendStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
