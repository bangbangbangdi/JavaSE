package com.bangdi.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PicServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        Socket server = serverSocket.accept();
        InputStream inputStream = server.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("netdemo/copy.jpg");
        int length = -1;
        byte[] bytes = new byte[1024];
        while ((length = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes);
        }
        server.shutdownInput();
        System.out.println("已收到图片");

        OutputStream outputStream = server.getOutputStream();
        outputStream.write("                    收到".getBytes());

        outputStream.close();
        inputStream.close();
        fileOutputStream.close();
        server.close();
        serverSocket.close();
    }
}
