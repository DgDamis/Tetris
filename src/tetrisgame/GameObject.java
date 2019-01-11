/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

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
    ArrayList<Cube> cubes;


    public void paint(Graphics gr) {
        for (Cube c : cubes) {
            c.paint(gr);
        }
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getCollision(GameObject testedObject) {
        Boolean anyIntersects = Boolean.FALSE;
        for (Cube c : this.cubes) {
            for (Cube to : testedObject.cubes) {
                if (to.area.intersects(new Rectangle2D.Double(c.position.getX(), c.position.getY(), c.size, c.size))) {
                    anyIntersects = Boolean.TRUE;
                }
            }
        }
        return anyIntersects;
    }

    public Boolean getCeilingCollision(GameObject object) {
        Boolean anyIntersects = false;
        for (Cube c : cubes) {
            for (Cube o : object.cubes) {
                if (c.area.intersects(new Rectangle2D.Double(o.position.getX(), o.position.getY(), o.size, o.size))) {
                    anyIntersects = true;
                }
            }
        }
        return anyIntersects;
    }

    public Boolean getFloorCollision(GameObject object) {
        Boolean anyIntersects = false;
        for (Cube f : cubes) {
            for (Cube o : object.cubes) {
                if (f.area.intersects(new Rectangle2D.Double(o.position.getX(), o.position.getY(), o.size, o.size))) {
                    anyIntersects = true;
                }
            }
        }
        return anyIntersects;
    }

    public Boolean getLeftWallCollision(GameObject object) {
        Boolean anyIntersects = false;
        for (Cube lw : cubes) {
            for (Cube o : object.cubes) {
                if (lw.area.intersects(new Rectangle2D.Double(o.position.getX(), o.position.getY(), o.size, o.size))) {
                    anyIntersects = true;
                }
            }
        }
        return anyIntersects;
    }

    public Boolean getRightCollision(GameObject object) {
        Boolean anyIntersects = false;
        for (Cube rw : cubes) {
            for (Cube o : object.cubes) {
                if (rw.area.intersects(new Rectangle2D.Double(o.position.getX(), o.position.getY(), o.size, o.size))) {
                    anyIntersects = true;
                }
            }
        }
        return anyIntersects;
    }
    
    public GameObject getRandomObject(Point position){
        GameObject gameObject;
        Random rand = new Random();
        int n = rand.nextInt(2) + 1;
        switch(n){
            default: gameObject = new IShape(playground,position, true);
            break;
            case 2: gameObject = new OShape(playground,position, true);
            break;
            
        }
        return gameObject;
    }

    public void move(KeyEvent ke, String caller) {
        System.out.println(ke.getKeyCode());
        if("keyReleased".equals(caller)){
            System.out.println("Jsem v ifu");
        switch (ke.getKeyCode()) {
            case 37:
                System.out.println("Posunuji vlevo.");
                this.moveToSide("Left");
                break;
            case 39:
                System.out.println("Posunuji vlevo.");
                this.moveToSide("Right");
                break;
            default:
                break;

        }
        }
        else {
            System.out.println("Jsem v elsu");
            switch (ke.getKeyCode()) {
            case 40:
                System.out.println("Posunuji dolů");
                this.fallAnimate(5);
                break;
            default:
                break;
        }
        }
            

    }

    abstract public void moveToSide(String direction);

    abstract public void fallAnimate(int speed);

    abstract public void moveUp();

}
