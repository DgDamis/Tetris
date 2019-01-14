package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Adam Šmehýl
 */
public class RightWall extends GameObject {

    public RightWall(Playground playground) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = new Point(playground.getWidth(), 0);
        this.size = 50;
        for (int i = 0; i < this.playground.getHeight() / this.size; i++) {
            cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + (i * this.size)), this.size, Color.BLACK));
        }
        // Debugovací výpis
        // System.out.println("Vytvořena pravá zeď");
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

    @Override
    public GameObject fallCorrection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GameObject flyCorrection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
