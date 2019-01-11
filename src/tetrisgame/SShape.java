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
 * @author Adam
 */
public class SShape extends GameObject{

    public SShape(Playground playground, Point position, Boolean active) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = position;
        this.active = active;
        cubes.add(new Cube(this.playground, new Point(this.position.x + this.size, this.position.y), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size*2), this.position.y), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + this.size), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + this.size, this.position.y + this.size), this.size, Color.GREEN));
    }

    @Override
    public void moveUp() {
        cubes.clear();
        this.position.y -= 1;
        cubes.add(new Cube(this.playground, new Point(this.position.x + this.size, this.position.y), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size*2), this.position.y), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + this.size), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + this.size, this.position.y + this.size), this.size, Color.GREEN));
    }

    @Override
    public void fallAnimate(int speed) {
        cubes.clear();
        this.position.y += speed;
        cubes.add(new Cube(this.playground, new Point(this.position.x + this.size, this.position.y), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size*2), this.position.y), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + this.size), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + this.size, this.position.y + this.size), this.size, Color.GREEN));
    }

    @Override
    public void moveToSide(String direction) {
        System.out.println("Jsem ve funkci pousunu");
        cubes.clear();
        if ("Left".equals(direction)) {
            this.position.x -= 50;
        } else {
            this.position.x += 50;
        }
        cubes.add(new Cube(this.playground, new Point(this.position.x + this.size, this.position.y), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size*2), this.position.y), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + this.size), this.size, Color.GREEN));
        cubes.add(new Cube(this.playground, new Point(this.position.x + this.size, this.position.y + this.size), this.size, Color.GREEN));
    }
    
}
