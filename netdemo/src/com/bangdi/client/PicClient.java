package com.bangdi.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PicClient {
    public static void main(String[] args) throws IOException {
        //向指定的Server发送一张图片
        FileInputStream fileInputStream = new FileInputStream("netdemo/img.jpg");
        //Socket创建的同时就指定IP和对应端口
        Socket client = new Socket("localhost", 10086);
        OutputStream outputStream = client.getOutputStream();
        byte[] bytes = new byte[1024];
        int length = -1;
        //读取指定文件的二进制信息
        while ((length = fileInputStream.read(bytes)) != -1) {
            //将读取到的二进制信息写入到由Socket创建的输出流中，此时的outputStream是有具体指向的
            outputStream.write(bytes);
        }
        //写入完成后关闭输出流
        client.shutdownOutput();
        //接收从Server返回的信息
        InputStream inputStream = client.getInputStream();
        while ((length = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, length));
        }

        inputStream.close();
        outputStream.close();
        fileInputStream.close();
        client.close();


    }
}
