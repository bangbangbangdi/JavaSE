package com.bangdi.server;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        //创建ServerSocket用于接收Client发送的数据
        ServerSocket serverSocket = new ServerSocket(10000);
        //通过ServerSocket实例化一个socket对象
        Socket socket = serverSocket.accept();
        //真正创建IO流的始终是socket
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int length = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, length));
        //同样通过socket创建输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到 bangdi".getBytes());
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
