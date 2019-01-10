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
    GameObject activeObject;
    BottomBorder bottomBorder;
    
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
        bottomBorder.paint(gr);
    }
    
    public void addObject(){
        activeObject = new IShape(this,new Point(100,100),true);
    }
    
    private void init(){
        this.setBounds(30, 30, 500, 800);
        this.setBackground(Color.white);
        this.setFocusable(true);
        objects = new ArrayList();
        objects.add(new IShape(this,new Point(100,100),true));
        objects.add(new IShape(this,new Point(100,300),true));
        bottomBorder = new BottomBorder(this);
        timer = new Timer(200, this);
        timer.start();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        for(GameObject ob: objects){
            if(ob.active){
            ob.fallAnimate();
            if(ob.getFloorCollision(bottomBorder)){
                while(ob.getFloorCollision(bottomBorder)!= Boolean.FALSE){
                    ob.moveUp();
                }
                ob.setActive(Boolean.FALSE);
            }
       
            for(GameObject to: objects){
                if(ob.getCollision(to)){
                    while(ob.getCollision(to) != Boolean.FALSE)
                     System.out.println("Nekonečný cyklus :)");
                    ob.setActive(Boolean.FALSE);
                }
            }
            }
        } 
        //System.out.println("actionTimer");
        this.repaint();
    }
}
