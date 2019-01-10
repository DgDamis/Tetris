/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author Adam
 */
public class IShape extends GameObject {
    
    
    public IShape(Playground playground, Point position, Boolean active) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = position;
        this.active = active;
        cubes.add(new Cube(this.playground,new Point(this.position.x-50,this.position.y),50,Color.CYAN));
        cubes.add(new Cube(this.playground,new Point(this.position.x,this.position.y),50,Color.CYAN));
        cubes.add(new Cube(this.playground,new Point(this.position.x+50,this.position.y),50,Color.CYAN));
        cubes.add(new Cube(this.playground,new Point(this.position.x+100,this.position.y),50,Color.CYAN));
    }
    
    public void paint(Graphics gr){
        for(Cube c: cubes){
            c.paint(gr);
        } 
    }
    
    public void fallAnimate(){
        cubes.clear();
        this.position.y +=50;
        cubes.add(new Cube(this.playground,new Point(this.position.x-50,this.position.y),50,Color.CYAN));
        cubes.add(new Cube(this.playground,new Point(this.position.x,this.position.y),50,Color.CYAN));
        cubes.add(new Cube(this.playground,new Point(this.position.x+50,this.position.y),50,Color.CYAN));
        cubes.add(new Cube(this.playground,new Point(this.position.x+100,this.position.y),50,Color.CYAN));
    }
    

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveUp() {
        cubes.clear();
        this.position.y -=5;
        cubes.add(new Cube(this.playground,new Point(this.position.x-50,this.position.y),50,Color.CYAN));
        cubes.add(new Cube(this.playground,new Point(this.position.x,this.position.y),50,Color.CYAN));
        cubes.add(new Cube(this.playground,new Point(this.position.x+50,this.position.y),50,Color.CYAN));
        cubes.add(new Cube(this.playground,new Point(this.position.x+100,this.position.y),50,Color.CYAN));
    }

    public Boolean getFloorCollision(BottomBorder floor) {
        Boolean anyIntersects = false;
        for(Cube c: cubes){
            for(Cube f: floor.cubes){
                if(f.area.intersects(new Rectangle2D.Double(c.position.getX(), c.position.getY(), c.size, c.size))){
                   anyIntersects = true;
                }
            }
        }
        return anyIntersects;
    }

    @Override
    public Boolean getCollision() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
