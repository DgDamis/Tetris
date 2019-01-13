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
public class PlaygroundLayer extends GameObject {

    public PlaygroundLayer(Playground playground, Point position) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = position;
        this.size = 50;
        for (int i = 0; i < this.playground.getWidth() / this.size; i++) {
            cubes.add(new Cube(this.playground, new Point(this.position.x + (i * this.size), this.position.y), this.size, Color.WHITE));
        }
        // Debugovací výpis
        //System.out.println("Vytvořena vrstva pozadí");
    }

    @Override
    public void moveToSide(String direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fallAnimate(int speed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
