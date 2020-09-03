package com.game.utils;

import com.game.images.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {
    private int length;//长度

    private int score;

    private String direction;//脑袋

    private boolean start;//状态

    private Timer timer;//定时器

    private boolean dead = false;

    private int[] snakeX = new int[200];
    private int[] snakeY = new int[200];

    //食物坐标
    private int foodX;
    private int foodY;

    public GamePanel() {
        init();
        this.setFocusable(true);

        this.addKeyListener(new KeyAdapter() {//键盘监听
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_SPACE) {
                    if (dead){
                        init();
                        dead = false;
                    } else {
                        start = !start;
                        repaint();
                    }
                }
                if (keyCode == KeyEvent.VK_UP) {
                    direction = "U";

                }
                if (keyCode == KeyEvent.VK_DOWN) {
                    direction = "D";

                }
                if (keyCode == KeyEvent.VK_LEFT) {
                    direction = "L";

                }
                if (keyCode == KeyEvent.VK_RIGHT) {
                    direction = "R";

                }
            }
        });

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (start && !dead) {
                    for (int i = length - 1; i > 0; i--) {
                        snakeX[i] = snakeX[i - 1];
                        snakeY[i] = snakeY[i - 1];
                    }
                    //动脑袋
                    if (direction.equals("R")) {
                        snakeX[0] += 25;
                    }
                    if (direction.equals("L")) {
                        snakeX[0] -= 25;
                    }
                    if (direction.equals("U")) {
                        snakeY[0] -= 25;
                    }
                    if (direction.equals("D")) {
                        snakeY[0] += 25;
                    }

                    if (snakeX[0] > 750) {
                        snakeX[0] = 25;
                    }
                    if (snakeX[0] < 25) {
                        snakeX[0] = 750;
                    }
                    if (snakeY[0] < 25) {
                        snakeY[0] = 725;
                    }
                    if (snakeY[0] > 725) {
                        snakeY[0] = 25;
                    }

                    //恰屎
                    if (snakeX[0] == foodX && snakeY[0] == foodY) {
                        length++;
                        foodX = 25 * ((int) (Math.random() * 30) + 1);//25-750
                        foodY = 25 * ((int) (Math.random() * 29) + 1);//25-725
                        score += 10;
                    }

                    //取消无敌模式
                    for (int i = 1; i < length; i++) {
                        if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                            dead = true;
                        }
                    }
                    repaint();
                }
            }
        });
        timer.start();
    }

    private void init() {
        length = 3;
        direction = "R";
        start = false;

        snakeX[0] = 175;
        snakeY[0] = 275;

        snakeX[1] = 150;
        snakeY[1] = 275;

        snakeX[2] = 125;
        snakeY[2] = 275;

        foodX = 300;
        foodY = 200;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setBackground(new Color(227, 202, 202, 145));

        g.setColor(new Color(69, 151, 155));
        g.fillRect(12, 20, 770, 730);

        switch (direction) {
            case "U":
                Images.upIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "D":
                Images.downIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "L":
                Images.leftIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "R":
                Images.rightIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            default:
                break;
        }
        for (int i = 1; i < length; i++) {
            Images.bodyIcon.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        if (start == false) {
            g.setColor(new Color(66, 177, 146));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("点击空格开始游戏", 250, 330);
        }

        Images.foodIcon.paintIcon(this, g, foodX, foodY);

        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("微软雅黑", Font.BOLD, 16));
        g.drawString("积分：" + score, 700, 15);

        if (dead){
            g.setColor(new Color(177, 24, 29));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("你挂了，废物 按空格继续吧", 200, 330);
        }

    }
}
