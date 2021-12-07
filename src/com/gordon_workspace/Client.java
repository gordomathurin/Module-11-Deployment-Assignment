package com.gordon_workspace;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            Socket socket = new Socket("localhost", 8000);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            System.out.println("Enter number you would like to check: ");
            int num = scanner.nextInt();

            dataOutputStream.writeInt(num);
            String serverResponse = (String)dataInputStream.readUTF();

            System.out.println(num + ": " + serverResponse);

            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();

        } catch (Exception exception) {
            System.out.println(exception);
        }
        scanner.close();
    }
}
