package com.bangdi.server;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        //跟SocketServer不同DatagramSocket没有客户端，服务端之分
        DatagramSocket datagramSocket = new DatagramSocket(10001);
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        //通过recevie方法接收数据
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        datagramSocket.close();

    }
}
