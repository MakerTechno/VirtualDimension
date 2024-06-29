package io.github.makertechno.user.gui;

import io.github.makertechno.user.gui.colors.ConsoleColorPack;
import io.github.makertechno.user.gui.colors.DefaultColorPacks;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import static io.github.makertechno.user.gui.util.JCUtils.getAvailableArea;

public class VirtualConsole extends JFrame {
    private static final int MAX_PARAM_LENGTH = 1000;
    private static ConsoleColorPack colorPack = DefaultColorPacks.getDefault();
    public VirtualConsole(String title){
        setTitle(title);
        generalSetup();
        setVisible(true);
    }

    private void generalSetup(){
        /*Frame size and location settings.*/
        Rectangle available = getAvailableArea(getGraphicsConfiguration());
        setSize(available.width/8*3,available.height/4*3);
        setLocationRelativeTo(null);

        /*Frame abilities settings.*/
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        /*Round corner settings.*/
        setUndecorated(true);
        getContentPane().setBackground(new Color(0,0,0,0));
        setBackground(colorPack.getBackground());
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
    }



    public static void setColorPack(ConsoleColorPack colorPack) {
        VirtualConsole.colorPack = colorPack;
    }

    public static void main(String[] args) {
        new VirtualConsole("命令行控制台");
    }
}
