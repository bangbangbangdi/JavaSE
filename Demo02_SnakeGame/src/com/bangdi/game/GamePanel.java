package com.bangdi.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    enum Direction {
        UP, DOWN, RIGHT, LEFT
    }

    int length;
    int[] snakeX = new int[200];
    int[] snakeY = new int[200];
    Direction direction;
    boolean isStart = false;
    Timer timer;
    int foodX;
    int foodY;
    int score;
    boolean isDie;

    public void init() {
        length = 3;
        snakeX[0] = 175;
        snakeY[0] = 275;
        snakeX[1] = 150;
        snakeY[1] = 275;
        snakeX[2] = 125;
        snakeY[2] = 275;
        foodX = 375;
        foodY = 375;
        direction = Direction.RIGHT;
    }

    public GamePanel() {
        init();
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_SPACE) {
                    if (isDie) {
                        init();
                        isDie = false;
                    } else {
                        isStart = !isStart;
                        repaint();
                    }
                }
                if (keyCode == KeyEvent.VK_UP) {
                    direction = Direction.UP;
                }
                if (keyCode == KeyEvent.VK_DOWN) {
                    direction = Direction.DOWN;
                }
                if (keyCode == KeyEvent.VK_LEFT) {
                    direction = Direction.LEFT;
                }
                if (keyCode == KeyEvent.VK_RIGHT) {
                    direction = Direction.RIGHT;
                }
            }
        });
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isStart && !isDie) {
                    for (int i = length - 1; i > 0; i--) {
                        snakeX[i] = snakeX[i - 1];
                        snakeY[i] = snakeY[i - 1];
                    }
                    if (direction == Direction.UP) {
                        snakeY[0] -= 25;
                    }
                    if (direction == Direction.DOWN) {
                        snakeY[0] += 25;
                    }
                    if (direction == Direction.LEFT) {
                        snakeX[0] -= 25;
                    }
                    if (direction == Direction.RIGHT) {
                        snakeX[0] += 25;
                    }
                    if (snakeX[0] > 750) {
                        snakeX[0] = 0;
                    }
                    if (snakeX[0] < 0) {
                        snakeX[0] = 750;
                    }
                    if (snakeY[0] > 725) {
                        snakeY[0] = 125;
                    }
                    if (snakeY[0] < 125) {
                        snakeY[0] = 725;
                    }
                    if (snakeX[0] == foodX && snakeY[0] == foodY) {
                        length++;
                        //[25,725]  [125,700]
                        foodX = ((int) (Math.random() * 29 + 1)) * 25;//[25,725]
                        foodY = ((int) (Math.random() * 24 + 5)) * 25;//[125,700]
                        score += 10;
                    }
                    for (int i = 1; i < length; i++) {
                        if (snakeX[i] == snakeX[0] && snakeY[i] == snakeY[0]) {
                            isDie = !isDie;
                        }
                    }
                    repaint();
                }
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(231, 218, 205));
        Images.topImg.paintIcon(this, g, 7, -75);
        g.setColor(new Color(208, 234, 202));
        g.fillRect(7, 130, 770, 620);

        switch (direction) {
            case UP:
                Images.headUPImg.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case DOWN:
                Images.headDownImg.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case LEFT:
                Images.headLeftImg.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case RIGHT:
                Images.headRightImg.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
        }

        for (int i = 1; i < length; i++) {
            Images.bodyImg.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        if (!isStart) {
            g.setColor(new Color(94, 186, 172));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 250, 200);
        }

        Images.foodImg.paintIcon(this, g, foodX, foodY);

//        g.setColor(new Color(94, 186, 172));
        g.setFont(new Font("微软雅黑", Font.BOLD, 30));
        g.drawString("积分：" + score, 650, 100);

        if (isDie) {
            g.setColor(new Color(114, 236, 193, 221));
            g.setFont(new Font("微软雅黑", Font.BOLD, 50));
            g.drawString("游戏结束，按下空格重新开始", 75, 400);
        }
    }
}
