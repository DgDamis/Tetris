/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Adam Šmehýl
 */
public class IShape extends GameObject {

    public IShape(Playground playground, Point position, Boolean active) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = position;
        this.active = active;
        cubes.add(new Cube(this.playground, new Point(this.position.x - 50, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + 50, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + 100, this.position.y), 50, Color.CYAN));
    }

    @Override
    public void moveUp() {
        cubes.clear();
        this.position.y -= 1;
        cubes.add(new Cube(this.playground, new Point(this.position.x - 50, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + 50, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + 100, this.position.y), 50, Color.CYAN));
    }

    @Override
    public void fallAnimate(int speed) {
        cubes.clear();
        this.position.y += speed;
        cubes.add(new Cube(this.playground, new Point(this.position.x - 50, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + 50, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + 100, this.position.y), 50, Color.CYAN));
    }

    @Override
    public void moveToSide(String direction) {
        System.out.println("Jsem ve funkci pousunu");
       cubes.clear();
       if("Left".equals(direction)){
           this.position.x -= 50;
       }
       else this.position.x += 50;
       cubes.add(new Cube(this.playground, new Point(this.position.x - 50, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + 50, this.position.y), 50, Color.CYAN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + 100, this.position.y), 50, Color.CYAN));
       
    }
}