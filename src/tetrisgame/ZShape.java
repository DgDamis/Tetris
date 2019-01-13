package tetrisgame;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Adam Šmehýl
 */
public class ZShape extends GameObject {

    public ZShape(Playground playground, Point position, Boolean active) {
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
        switch (this.angle) {
            case 0:
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 0)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 0)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 1)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 2), this.position.y + (this.size * 1)), this.size, Color.RED));
                break;
            case 90:
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 0)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 1)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 1)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 2)), this.size, Color.RED));
                break;
            case 180:
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 0)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 0)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 1)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 2), this.position.y + (this.size * 1)), this.size, Color.RED));
                break;
            case 270:
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 0)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 1)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 1)), this.size, Color.RED));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 2)), this.size, Color.RED));
                break;
        }
    }
}
