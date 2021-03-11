package com.bangdi.server;

import com.bangdi.client.User;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(10000);
        Socket server = serverSocket.accept();
        InputStream inputStream = server.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        User user = (User) objectInputStream.readObject();
        String str = "";
        if ("bangdi".equals(user.getUsername()) && "bangdi".equals(user.getPassword())) {
            System.out.println("欢迎你"+user.getUsername());
            str = "登陆成功";
        }else{
            str = "登陆失败";
        }
        server.shutdownInput();
        DataOutputStream outputStream = new DataOutputStream(server.getOutputStream());
        outputStream.writeUTF(str);
        server.shutdownOutput();
        outputStream.close();
        inputStream.close();
        server.close();
        serverSocket.close();

    }
}
