package com.bangdi.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient2 {
    public static void main(String[] args) throws IOException {

        //需要不断的进行登陆测试
        while (true) {
            //在客户端实例化Socket时需要指定访问的ip及端口号
            Socket client = new Socket("localhost", 10000);
            //通过Socket对象创建出一个输出流
            OutputStream outputStream = client.getOutputStream();
            //待会要传输的对象
            User user = getUser();
            //传输对象需要将outputStream包装为ObjectOutputStream
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(user);
            client.shutdownOutput();
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            //从服务端写入时用的UTF编码，故读取时需要同样的编码
            String str = dataInputStream.readUTF();
            System.out.println(str);
            dataInputStream.close();
            objectOutputStream.close();
            outputStream.close();
            client.close();
            if ("登陆成功".equals(str))
                break;
        }

    }

    public static User getUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        return new User(username, password);

    }
}
