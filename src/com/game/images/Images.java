package com.game.images;

import javax.swing.*;
import java.net.URL;

public class Images {

    public static URL bodyUrl = Images.class.getResource("/images/body.jpg");
    public static ImageIcon bodyIcon = new ImageIcon(bodyUrl);

    public static URL upUrl = Images.class.getResource("/images/up.jpg");
    public static ImageIcon upIcon = new ImageIcon(upUrl);

    public static URL downUrl = Images.class.getResource("/images/down.jpg");
    public static ImageIcon downIcon = new ImageIcon(downUrl);

    public static URL leftUrl = Images.class.getResource("/images/left.jpg");
    public static ImageIcon leftIcon = new ImageIcon(leftUrl);

    public static URL rightUrl = Images.class.getResource("/images/right.jpg");
    public static ImageIcon rightIcon = new ImageIcon(rightUrl);

    public static URL foodUrl = Images.class.getResource("/images/food.jpg");
    public static ImageIcon foodIcon = new ImageIcon(foodUrl);

}
