package com.gordon_workspace;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static String isNumPrime(int num) {
        if (num < 2 ) {
            return "Not A Prime Number";
        }
        int i = 2;
        if (i < num) {
            do {
                if (num % i == 0) {
                    return "Not A Prime Number";
                }
                i++;
            } while (i < num);
        }
        return "Prime Number";
    }

    public static void main (String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8000);

            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            System.out.println("Server Running....");

            int num = (int)dataInputStream.readInt();
            dataOutputStream.writeUTF(isNumPrime(num));
            dataOutputStream.flush();
            dataOutputStream.close();
            serverSocket.close();

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

}
