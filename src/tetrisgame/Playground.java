/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Adam
 */
public class Playground extends JPanel {
    private Timer timer;
    Window window;
    DefaultListModel model;
    ArrayList <GameObject> objects;
    
    public Playground(Window window, DefaultListModel model) {
        this.window = window;
        this.model = model;
        this.init();
    }
    
    @Override
    protected void paintComponent(Graphics gr){
        super.paintComponent(gr);
        GameObject gameObject = new IShape(this,new Point(100,100));
        gameObject.paint(gr);
        //gameObject.fallAnimate(gr);
    }
    
    
    private void init(){
        this.setBounds(30, 30, 500, 800);
        this.setBackground(Color.white);
        this.setFocusable(true);
        objects = new ArrayList();
        //timer = new Timer(40,this);
        //timer.start();
    }
}
