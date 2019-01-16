package tetrisgame;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Adam Šmehýl
 */
public class SShape extends GameObject {

    public SShape(Playground playground, Point position, Boolean active) {
        this.playground = playground;
        this.cubes = new ArrayList();
        this.position = position;
        this.active = active;
        construct();
    }

    public SShape(GameObject oldObject) {
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
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 0)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 2), this.position.y + (this.size * 0)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 1)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 1)), this.size, Color.GREEN));
                break;
            case 90:
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 0)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 1)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 1)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 2)), this.size, Color.GREEN));
                break;
            case 180:
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 0)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 2), this.position.y + (this.size * 0)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 1)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 1)), this.size, Color.GREEN));
                break;
            case 270:
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 0)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 0), this.position.y + (this.size * 1)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 1)), this.size, Color.GREEN));
                cubes.add(new Cube(this.playground, new Point(this.position.x + (this.size * 1), this.position.y + (this.size * 2)), this.size, Color.GREEN));
                break;
        }
    }

    @Override
    public GameObject fallCorrection() {
        GameObject movedObject = new SShape(this);
        ArrayList<Cube> oldCubes;
        oldCubes = this.getCubes();
        ArrayList<Cube> newCubes;
        newCubes = new ArrayList();
        for (Cube cube : oldCubes) {
            newCubes.add(new Cube(playground, new Point(cube.position.x, cube.position.y + 50), 50, Color.GREEN));
        }
        movedObject.setCubes(newCubes);
        return movedObject;
    }

    @Override
    public GameObject flyCorrection() {
        GameObject movedObject = new SShape(this);
        ArrayList<Cube> oldCubes;
        oldCubes = this.getCubes();
        ArrayList<Cube> newCubes;
        newCubes = new ArrayList();
        for (Cube cube : oldCubes) {
            newCubes.add(new Cube(playground, new Point(cube.position.x, cube.position.y - 50), 50, Color.GREEN));
        }
        movedObject.setCubes(newCubes);
        return movedObject;
    }
}
