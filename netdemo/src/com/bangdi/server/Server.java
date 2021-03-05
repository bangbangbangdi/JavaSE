package com.bangdi.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //服务器端使用ServerSocket来开放本地的端口
        ServerSocket serverSocket = new ServerSocket(10086);
        //接收client传输过来的数据，需要定义socket对象
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String str = dataInputStream.readUTF();
        System.out.println(str);
        dataInputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
