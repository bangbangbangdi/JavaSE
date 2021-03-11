package com.bangdi.server;

import com.bangdi.client.User;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        while(true){
            //ServerSocket实例化时只需指定自己的端口
            ServerSocket serverSocket = new ServerSocket(10000);
            //ServerSocket对象在实现通信时一样需要Socket对象
            Socket server = serverSocket.accept();
            InputStream inputStream = server.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            User user = (User) objectInputStream.readObject();
            String str = "";
            if ("bangdi".equals(user.getUsername()) && "bangdi".equals(user.getPassword())) {
                System.out.println("欢迎你" + user.getUsername());
                str = "登陆成功";
            } else {
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
            if ("登陆成功".equals(str))
                break;
        }
    }
}
