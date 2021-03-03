package com.bangdi.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel {
    //小蛇长度及坐标
    int length;
    int[] snakeX = new int[200];
    int[] snakeY = new int[200];
    //定义蛇行走的方向
    String direction;
    //设定游戏状态
    boolean isStart = false;
    //加入一个定时器
    Timer timer;
    //定义食物的x,y坐标
    int foodX;
    int foodY;
    //定义得分
    int score;
    //死亡判定
    boolean isDie = false;

    public void init() {
        //初始化蛇的长度
        length = 3;
        snakeX[0] = 175;
        snakeY[0] = 275;
        snakeX[1] = 150;
        snakeY[1] = 275;
        snakeX[2] = 125;
        snakeY[2] = 275;
        //初始化蛇头方向
        direction = "R";
        //初始化食物坐标
        foodX = 600;
        foodY = 300;
    }

    public GamePanel() {
        init();
        //将焦点定位在当前操作的面板上
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_SPACE) {//监听空格按下的动作
                    if (isDie) {
                        //全部恢复到初始状态
                        init();
                        isDie = false;
                    } else {
                        isStart = !isStart;
                        //调用重绘方法
                        repaint();
                    }
                }
                //监听向上箭头
                if (keyCode == KeyEvent.VK_UP) {
                    direction = "U";
                }
                //监听向下箭头
                if (keyCode == KeyEvent.VK_DOWN) {
                    direction = "D";
                }
                //监听向左箭头
                if (keyCode == KeyEvent.VK_LEFT) {
                    direction = "L";
                }
                //监听向右箭头
                if (keyCode == KeyEvent.VK_RIGHT) {
                    direction = "R";
                }
            }
        });
        //对定时器进行初始化操作
        timer = new Timer(100, new ActionListener() {
            /*
            ActionListeners是事件监听
            相当于每100ms监听一下你是否发生了一个动作
            具体的动作放入actionPerformed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isStart && !isDie) {
                    //后一节身子走到前一节身子的位置上
                    for (int i = length - 1; i > 0; i--) {
                        snakeX[i] = snakeX[i - 1];
                        snakeY[i] = snakeY[i - 1];
                    }
                    //按照蛇头方向改变行动方向
                    if ("R".equals(direction)) {
                        snakeX[0] += 25;
                    }
                    if ("L".equals(direction)) {
                        snakeX[0] -= 25;
                    }
                    if ("U".equals(direction)) {
                        snakeY[0] -= 25;
                    }
                    if ("D".equals(direction)) {
                        snakeY[0] += 25;
                    }
                    //防止小蛇超出边界
                    if (snakeX[0] > 750) {
                        snakeX[0] = 25;
                    }
                    if (snakeX[0] < 25) {
                        snakeX[0] = 750;
                    }
                    if (snakeY[0] < 175) {
                        snakeY[0] = 725;
                    }
                    if (snakeY[0] > 725) {
                        snakeY[0] = 175;
                    }
                    //吃到食物以后
                    if (snakeX[0] == foodX && snakeY[0] == foodY) {
                        //小蛇长度增加
                        length++;
                        //改变食物坐标
                        foodX = ((int) (Math.random() * 30 + 1) * 25);//[25,750]
                        foodY = ((int) (Math.random() * 22 + 7) * 25);//[175,725]
                        score += 10;
                    }
                    for (int i = 1; i < length; i++) {
                        if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                            isDie = !isDie;
                        }
                    }
                    repaint();
                }
            }
        });
        //启动定时器
        timer.start();
    }

    /*
    paintComponents这个方法类似于main方法
    自动调用
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //设置背景颜色
        this.setBackground(new Color(78, 79, 80));

        //头部图片
        Images.topImg.paintIcon(this, g, 7, -50);
        //设置画笔颜色
        g.setColor(new Color(125, 126, 127));
        //用画笔填充一个矩形
        g.fillRect(7, 157, 770, 600);

        //画小蛇
        //根据蛇头行进的方向绘制蛇头
        if ("U".equals(direction)) {
            Images.headUPImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if ("D".equals(direction)) {
            Images.headDownImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if ("L".equals(direction)) {
            Images.headLeftImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if ("R".equals(direction)) {
            Images.headRightImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        //优化蛇身
        for (int i = 1; i < length; i++) {
            Images.bodyImg.paintIcon(this, g, snakeX[i], snakeY[i]);
        }
        //如果游戏是暂停状态，则界面内有一句提示语：
        if (!isStart) {
            //画一个文字：
            g.setColor(new Color(222, 167, 137));
            //三个参数： 字体 加粗 字号
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            //画文字
            g.drawString("点击空格开始游戏", 250, 200);
        }
        //画食物：
        Images.foodImg.paintIcon(this, g, foodX, foodY);
        //画积分：
        g.setColor(new Color(222, 167, 137));
        g.setFont(new Font("微软雅黑", Font.BOLD, 20));
        g.drawString("积分：" + score, 620, 40);

        //画死亡状态：
        if (isDie) {
            g.setColor(new Color(208, 199, 199));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("小蛇死亡，按下空格重新开始", 150, 350);
        }
    }

}

















