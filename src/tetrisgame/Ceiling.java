/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author Adam
 */
public class Ceiling extends GameObject{
    
     public Ceiling(Playground playground) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = new Point(0,-50);
        this.size = 50;
        for(int i = 0; i < this.playground.getWidth()/this.size;i++){   
        cubes.add(new Cube(this.playground,new Point(this.position.x+(i*this.size),this.position.y),this.size,Color.BLACK));
        }
        System.out.println("Vytvořen strop");
    }
    
    @Override
    public void paint(Graphics gr) {
        for(Cube c: cubes){
            c.paint(gr);
        } 
    }
    
    public Boolean getCeilingCollision(GameObject object) {
        Boolean anyIntersects = false;
        for(Cube c: cubes){
            for(Cube o: object.cubes){
                if(c.area.intersects(new Rectangle2D.Double(o.position.getX(), o.position.getY(), o.size, o.size))){
                   anyIntersects = true;
                }
            }
        }
        return anyIntersects;
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

    public Boolean getFloorCollision(Floor floor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getCollision() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getFloorCollision(GameObject object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
