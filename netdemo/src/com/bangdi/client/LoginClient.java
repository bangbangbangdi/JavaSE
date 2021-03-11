package com.bangdi.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {
    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 10000);
        OutputStream outputStream = client.getOutputStream();
        User user = getUser();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        client.shutdownOutput();
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        String str = dataInputStream.readUTF();
        System.out.println(str);
        dataInputStream.close();
        objectOutputStream.close();
        outputStream.close();
        client.close();
    }
    public static User getUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        return new User(username,password);

    }
}
