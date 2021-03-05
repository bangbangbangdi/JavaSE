package com.bangdi.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建socket对象，开启实现io的虚拟接口
        //需要制指定数据接收放的ip地址和端口号
        Socket client = new Socket("localhost", 10086);
        //获取输出流对象，向服务器端发送数据
        OutputStream outputStream = client.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("Hello,bangdi");
        dataOutputStream.close();
        outputStream.close();
        client.close();
    }
}
