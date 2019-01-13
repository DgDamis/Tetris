package tetrisgame;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Adam Šmehýl
 */
public class OShape extends GameObject {

    public OShape(Playground playground, Point position, Boolean active) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = position;
        this.active = active;
        construct();
    }

    @Override
    public void moveUp() {
        cubes.clear();
        this.position.y -= 1;
        construct();
    }

    @Override
    public void fallAnimate(int speed) {
        cubes.clear();
        this.position.y += speed;
        construct();
    }

    @Override
    public void moveToSide(String direction) {
        //System.out.println("Jsem ve funkci pousunu");
        cubes.clear();
        if ("Left".equals(direction)) {
            this.position.x -= 50;
        } else {
            this.position.x += 50;
        }
        construct();
    }

    private void construct() {
        cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y), this.size, Color.YELLOW));
        cubes.add(new Cube(this.playground, new Point(this.position.x + this.size, this.position.y), this.size, Color.YELLOW));
        cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + this.size), this.size, Color.YELLOW));
        cubes.add(new Cube(this.playground, new Point(this.position.x + this.size, this.position.y + this.size), this.size, Color.YELLOW));
    }
}
