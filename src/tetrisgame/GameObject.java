/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

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
    protected Boolean active;
    protected Point position;
    IShape ishape;
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
*//*
    public void fallAnimate(Graphics gr) {
        ishape = new IShape(this.playground,new Point(this.position.x, this.position.y-50));
        ishape.paint(gr);

    }
    */
    abstract public void paint(Graphics gr);

}
