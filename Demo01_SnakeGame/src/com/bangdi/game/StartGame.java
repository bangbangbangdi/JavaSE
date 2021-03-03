package com.bangdi.game;

import javax.swing.*;
import java.awt.*;

public class StartGame {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("贪吃蛇，永远滴神~");
        //设置大小不可调
        jf.setResizable(false);
        //获取屏幕长宽
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jf.setBounds((width-800)/2,(height-800)/2,800,800);
        //创建面板
        GamePanel gp = new GamePanel();
        jf.add(gp);
        //窗体关闭时程序停止
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);


    }
}
