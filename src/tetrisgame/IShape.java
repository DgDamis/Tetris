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
 * @author Adam
 */
public class IShape extends GameObject {
    ArrayList <Cube> cubes;
    
    
    public IShape(Playground playground, Point position) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = position;
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
    
    
}