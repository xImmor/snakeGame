package com.game;

import com.game.utils.GamePanel;

import javax.swing.*;
import java.awt.*;

public class GameStart {
    public static void main(String[] args) {
        JFrame frame = new JFrame("小 游 戏  大 智 慧");

        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        frame.setBounds((width - 800) / 2, (height - 800) / 2, 800, 800);

        frame.setResizable(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.setVisible(true);
    }

}
