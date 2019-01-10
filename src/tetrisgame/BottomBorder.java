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

/**
 *
 * @author maturita
 */
public class BottomBorder extends GameObject {
    ArrayList <Cube> cubes;
    
    
     public BottomBorder(Playground playground) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = new Point(0,300);
        this.size = 50;
        for(int i = 0; i < this.playground.getWidth()/this.size;i++){   
        cubes.add(new Cube(this.playground,new Point(this.position.x+(i*this.size),this.playground.getHeight()),this.size,Color.BLACK));
        }
        System.out.println("Vytvořena podlaha");
    }
    
    
    @Override
    public void paint(Graphics gr) {
        for(Cube c: cubes){
            c.paint(gr);
        } 
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fallAnimate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean getFloorCollision() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getFloorCollision(BottomBorder floor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean getFloorCollision(GameObject floor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getCollision() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
