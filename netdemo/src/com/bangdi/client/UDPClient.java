package com.bangdi.client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        //跟Socket类似的，在实例化时要指定端口
        DatagramSocket datagramSocket = new DatagramSocket(10000);
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //DatagramSocket传输的是DatagramPacket，DatagramPacket在实例化的时候要求指定IP地址和对应端口
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("localhost"), 10001);
        //通过send方法发送数据
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
