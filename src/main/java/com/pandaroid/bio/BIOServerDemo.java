package com.pandaroid.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pandaroid
 */
public class BIOServerDemo {

    private ServerSocket serverSocket;
    private static final int PORT = 8080;
    private static final int BYTES_SIZE = 8080;

    public BIOServerDemo() {
        try {
            this.serverSocket = new ServerSocket(PORT);
            System.out.println("[BIOServerDemo] ServerSocket started! this.serverSocket.getInetAddress(): " + this.serverSocket.getInetAddress());
            System.out.println("[BIOServerDemo] ServerSocket started! Port: " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BIOServerDemo().listen();
    }

    private void listen() {
        Socket socket = null;
        try {
            socket = this.serverSocket.accept();
            System.out.println("[BIOServerDemo listen] socket.getInetAddress(): " + socket.getInetAddress());
            System.out.println("[BIOServerDemo listen] socket.getPort(): " + socket.getPort());
            InputStream is = socket.getInputStream();
            // Start: 使用 BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            for(String rcvMsg = br.readLine(); null != rcvMsg; rcvMsg = br.readLine()) {
                System.out.println("[BIOServerDemo listen] rcvMsg: " + rcvMsg);
            }
            // End  : 使用 BufferedReader
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
