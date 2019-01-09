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
    
    abstract public void paint(Graphics gr);
    abstract public void clear();
    abstract public void fallAnimate();
}
