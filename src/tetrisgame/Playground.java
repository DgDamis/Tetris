/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Adam
 */
public class Playground extends JPanel implements ActionListener {
    private Timer timer;
    Window window;
    DefaultListModel model;
    ArrayList <GameObject> objects;
    
    public Playground(Window window, DefaultListModel model) {
        this.window = window;
        this.model = model;
        //object = new IShape(this,new Point(100,100));
        this.init();
    }
    
    @Override
    protected void paintComponent(Graphics gr){
        super.paintComponent(gr);
        for(GameObject ob: objects){
           ob.paint(gr);
        } 
    }
    
    
    private void init(){
        this.setBounds(30, 30, 500, 800);
        this.setBackground(Color.white);
        this.setFocusable(true);
        objects = new ArrayList();
        objects.add(new IShape(this,new Point(100,100)));
        objects.add(new IShape(this,new Point(100,300)));
        timer = new Timer(200, this);
        timer.start();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        for(GameObject ob: objects){
            ob.fallAnimate();
        } 
        System.out.println("actionTimer");
        this.repaint();
    }
}
