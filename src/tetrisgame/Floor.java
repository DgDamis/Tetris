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
public class Floor extends GameObject {

    public Floor(Playground playground) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = new Point(0, 300);
        this.size = 50;
        for (int i = 0; i < this.playground.getWidth() / this.size; i++) {
            cubes.add(new Cube(this.playground, new Point(this.position.x + (i * this.size), this.playground.getHeight()), this.size, Color.BLACK));
        }
        // Debugovací výpis
        //System.out.println("Vytvořena podlaha");
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveToSide(String direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fallAnimate(int speed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
