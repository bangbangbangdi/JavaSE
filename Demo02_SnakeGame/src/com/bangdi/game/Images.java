package com.bangdi.game;

import javax.swing.*;
import java.net.URL;

public class Images {
    public static URL topURL = Images.class.getResource("/images/Top.jpg");
    public static ImageIcon topImg = new ImageIcon(topURL);

    public static URL headUpURL = Images.class.getResource("/images/headUp.jpg");
    public static ImageIcon headUPImg = new ImageIcon(headUpURL);

    public static URL headDownURL = Images.class.getResource("/images/headDown.jpg");
    public static ImageIcon headDownImg = new ImageIcon(headDownURL);

    public static URL headRightURL = Images.class.getResource("/images/headRight.jpg");
    public static ImageIcon headRightImg = new ImageIcon(headRightURL);

    public static URL headLeftURL = Images.class.getResource("/images/headLeft.jpg");
    public static ImageIcon headLeftImg = new ImageIcon(headLeftURL);

    public static URL bodyURL = Images.class.getResource("/images/body.jpg");
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);

    public static URL foodURL = Images.class.getResource("/images/food.jpg");
    public static ImageIcon foodImg = new ImageIcon(foodURL);
}
