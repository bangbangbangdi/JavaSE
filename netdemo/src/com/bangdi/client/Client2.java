package com.bangdi.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("bangdi".getBytes());
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int length = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, length));
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
