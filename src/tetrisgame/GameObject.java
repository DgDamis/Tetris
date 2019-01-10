/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javafx.scene.effect.Light;

/**
 *
 * @author Adam
 */
public abstract class GameObject {
    protected Playground playground;
    protected Point position;
    protected Boolean active;
    protected Color brushColor;
    protected Color fillColor;
    protected int size = 50;
    ArrayList <Cube> cubes;
    
    //IShape ishape;
/*
    public GameObject(Playground playground, Point position) {
        this.playground = playground;
        this.position = position;
        //switch (type) {
            //default:
                ishape = new IShape(this.playground, this.position);
                //break;
        //}
    }
    */
    //public void fallAnimate(GameObject gameobject) {
    //    gameobject.position = new Point(this.position.x, this.position.y-50);
    //}

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    public Boolean getCollision(GameObject testedObject){
        Boolean anyIntersects = Boolean.FALSE;
        for(Cube c: this.cubes){
            for(Cube to: testedObject.cubes){
                if(to.area.intersects(new Rectangle2D.Double(c.position.getX(), c.position.getY(), c.size, c.size))){
                   anyIntersects = Boolean.TRUE;
                }
            }
        }
        return anyIntersects;
    }
    
    abstract public void paint(Graphics gr);
    abstract public void clear();
    abstract public void fallAnimate();
    abstract public void moveUp();
    abstract public Boolean getFloorCollision(BottomBorder floor);
    abstract public Boolean getCollision();
}
