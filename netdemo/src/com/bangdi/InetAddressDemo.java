package com.bangdi;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//DESKTOP-O2E7221/192.168.0.104
        InetAddress inetAdd = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAdd);//www.baidu.com/183.232.231.172
        String hostAddress = inetAdd.getHostAddress();
        System.out.println(hostAddress);//183.232.231.172
        String hostName = inetAdd.getHostName();
        System.out.println(hostName);//www.baidu.com

    }
}
