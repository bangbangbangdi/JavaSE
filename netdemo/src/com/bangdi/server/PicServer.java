package com.bangdi.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PicServer {
    public static void main(String[] args) throws IOException {
        //ServerSocket在实例化时要指定具体的端口
        ServerSocket serverSocket = new ServerSocket(10086);
        //在这个具体的ServerSocket下再创建Socket
        Socket server = serverSocket.accept();
        //从具体的socket上创建出输入流
        InputStream inputStream = server.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("./netdemo/copy.jpg");
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
