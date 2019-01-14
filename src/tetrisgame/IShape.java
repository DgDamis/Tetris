package tetrisgame;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author Adam Šmehýl
 */
public final class IShape extends GameObject {

    public IShape(Playground playground, Point position, Boolean active) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = position;
        this.active = active;
        construct();
    }

    public IShape(GameObject oldObject) {
        this.playground = oldObject.getPlayground();
        this.position = oldObject.getPosition();
        this.active = oldObject.getActive();
        this.brushColor = oldObject.getBrushColor();
        this.fillColor = oldObject.getFillColor();
        this.cubes = oldObject.getCubes();
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

        // System.out.println("Jsem ve funkci pousunu");
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
                cubes.add(new Cube(this.playground, new Point(this.position.x - 50, this.position.y), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + 50, this.position.y), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + 100, this.position.y), 50, Color.CYAN));
                break;
            case 90:
                cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + (this.size * -1)), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + (this.size * 0)), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + (this.size * 1)), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + (this.size * 2)), 50, Color.CYAN));
                break;
            case 180:
                cubes.add(new Cube(this.playground, new Point(this.position.x - 50, this.position.y), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + 50, this.position.y), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + 100, this.position.y), 50, Color.CYAN));
                break;
            case 270:
                cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + this.size), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + (this.size * 2)), 50, Color.CYAN));
                cubes.add(new Cube(this.playground, new Point(this.position.x, this.position.y + (this.size * 3)), 50, Color.CYAN));
                break;
        }
    }

    @Override
    public GameObject fallCorrection() {
        GameObject movedObject = new IShape(this);
        ArrayList<Cube> oldCubes;
        oldCubes = this.getCubes();
        ArrayList<Cube> newCubes;
        newCubes = new ArrayList();
        for (Cube cube : oldCubes) {
            newCubes.add(new Cube(playground, new Point(cube.position.x, cube.position.y + 50),50,Color.CYAN));
        }
        movedObject.setCubes(newCubes);
        return movedObject;
    }
    
    @Override
    public GameObject flyCorrection() {
        GameObject movedObject = new IShape(this);
        ArrayList<Cube> oldCubes;
        oldCubes = this.getCubes();
        ArrayList<Cube> newCubes;
        newCubes = new ArrayList();
        for (Cube cube : oldCubes) {
            newCubes.add(new Cube(playground, new Point(cube.position.x, cube.position.y + 50),50,Color.CYAN));
        }
        movedObject.setCubes(newCubes);
        return movedObject;
    }

}
