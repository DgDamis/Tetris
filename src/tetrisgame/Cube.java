/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Adam
 */
public class Cube {

    int size = 50;
    protected Playground playground;
    public Point position;
    public Area area;
    private Color fillColor = Color.BLACK;
    private Color brushColor = Color.BLACK;

    public Cube(Playground playground, Point position) {
        this.playground = playground;
        this.position = position;
        this.area = new Area(new Rectangle2D.Double(this.position.getX(), this.position.getY(), this.size, this.size));
    }

    public Cube(Playground playground, Point position, int size) {
        this.size = size;
        this.playground = playground;
        this.position = position;
        this.area = new Area(new Rectangle2D.Double(this.position.getX(), this.position.getY(), this.size, this.size));
    }
    
    public Cube(Playground playground, Point position, int size, Color fillColor) {
        this.size = size;
        this.playground = playground;
        this.position = position;
        this.fillColor = fillColor;
        this.area = new Area(new Rectangle2D.Double(this.position.getX(), this.position.getY(), this.size, this.size));
    }

    public Cube(Playground playground, Point position, int size, Color fillColor, Color brushColor) {
        this.size = size;
        this.playground = playground;
        this.position = position;
        this.fillColor = fillColor;
        this.brushColor = brushColor;
        this.area = new Area(new Rectangle2D.Double(this.position.getX(), this.position.getY(), this.size, this.size));
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void paint(Graphics gr) {
        Graphics2D g2d = (Graphics2D) gr;
        g2d.setColor(fillColor);
        g2d.fill(area);
    }

}
