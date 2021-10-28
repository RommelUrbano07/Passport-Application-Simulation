/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static javafx.scene.input.KeyCode.F;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Asus
 */
public class Marker extends JLabel{

    public Marker(String path) throws IOException {
        ImageIcon img = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(19, 25, Image.SCALE_SMOOTH));
        this.setIcon(img);
        this.setOpaque(true);
    }
}
