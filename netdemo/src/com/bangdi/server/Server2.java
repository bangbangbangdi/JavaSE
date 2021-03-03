package com.bangdi.server;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int length = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, length));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到 bangdi".getBytes());
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
