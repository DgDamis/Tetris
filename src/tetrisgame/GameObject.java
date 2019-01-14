package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Adam Šmehýl
 */
public abstract class GameObject {

    protected Playground playground;
    protected Point position;
    protected Boolean active;
    protected Color brushColor;
    protected Color fillColor;
    protected int size = 50;
    protected int angle = 0;
    ArrayList<Cube> cubes;


    public void paint(Graphics gr) {
        for (Cube c : cubes) {
            c.paint(gr);
        }
    }

    public Playground getPlayground() {
        return playground;
    }

    public Point getPosition() {
        return position;
    }

    public Color getBrushColor() {
        return brushColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public int getSize() {
        return size;
    }

    public int getAngle() {
        return angle;
    }

    public ArrayList<Cube> getCubes() {
        return cubes;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setBrushColor(Color brushColor) {
        this.brushColor = brushColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void setCubes(ArrayList<Cube> cubes) {
        this.cubes = cubes;
    }

    
    
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getCollision(GameObject testedObject) {
        Boolean anyIntersects = Boolean.FALSE;
        for (Cube c : this.cubes) {
            for (Cube to : testedObject.cubes) {
                if (to.area.intersects(new Rectangle2D.Double(c.position.getX(), c.position.getY(), c.size, c.size))) {
                    anyIntersects = Boolean.TRUE;
                }
            }
        }
        return anyIntersects;
    }

    public Boolean getCeilingCollision(GameObject object) {
        Boolean anyIntersects = false;
        for (Cube c : cubes) {
            for (Cube o : object.cubes) {
                if (c.area.intersects(new Rectangle2D.Double(o.position.getX(), o.position.getY(), o.size, o.size))) {
                    anyIntersects = true;
                }
            }
        }
        return anyIntersects;
    }

    public Boolean getFloorCollision(GameObject object) {
        Boolean anyIntersects = false;
        for (Cube f : cubes) {
            for (Cube o : object.cubes) {
                if (f.area.intersects(new Rectangle2D.Double(o.position.getX(), o.position.getY(), o.size, o.size))) {
                    anyIntersects = true;
                }
            }
        }
        return anyIntersects;
    }

    public Boolean getLeftWallCollision(GameObject object) {
        Boolean anyIntersects = false;
        for (Cube lw : cubes) {
            for (Cube o : object.cubes) {
                if (lw.area.intersects(new Rectangle2D.Double(o.position.getX(), o.position.getY(), o.size, o.size))) {
                    anyIntersects = true;
                }
            }
        }
        return anyIntersects;
    }

    public int getNumberOfCollisionInLayer(ArrayList<GameObject> objects) {
        int numberOfCollisions = 0;
        for (Cube lw : cubes) {
            for (GameObject objekt : objects) {
                for (Cube cube : objekt.cubes) {
                    if (lw.area.intersects(new Rectangle2D.Double(cube.position.getX(), cube.position.getY(), cube.size, cube.size))) {
                        numberOfCollisions++;
                    }
                }
            }
        }
        return numberOfCollisions;
    }

    // Vrací aktualizovaný ArrayList s herními objekty s odstraněnými částmi, které se nacházely na smazané vrstvě
    public ArrayList getUpdatedArrayOfObjects(ArrayList<GameObject> objects) {
        ArrayList<GameObject> newArrayList;
        newArrayList = new ArrayList();
        ArrayList<Cube> cubesToRemove;
        cubesToRemove = new ArrayList();
        for (Cube lw : cubes) {
            for (GameObject objekt : objects) {
                for (Cube cube : objekt.cubes) {
                    if (lw.area.intersects(new Rectangle2D.Double(cube.position.getX(), cube.position.getY(), cube.size, cube.size))) {
                        cubesToRemove.add(cube);
                    }
                }
                for(Cube cube : cubesToRemove){
                    objekt.cubes.remove(cube);
                }
            }
        }
        newArrayList = objects;
        return newArrayList;
    }

    public void turn() {
        this.angle = (this.angle + 90);
        if (this.angle == 360) {
            this.angle = 0;
        }
        // Debugovací výpis
        //System.out.print("Current angle: ");
        //System.out.println(this.angle);
    }

    public Boolean getRightCollision(GameObject object) {
        Boolean anyIntersects = false;
        for (Cube rw : cubes) {
            for (Cube o : object.cubes) {
                if (rw.area.intersects(new Rectangle2D.Double(o.position.getX(), o.position.getY(), o.size, o.size))) {
                    anyIntersects = true;
                }
            }
        }
        return anyIntersects;
    }

    public GameObject getRandomObject(Point position) {
        GameObject gameObject;
        Random rand = new Random();
        int n = rand.nextInt(2) + 1;
        switch (n) {
            default:
                gameObject = new IShape(playground, position, true);
                break;
            case 2:
                gameObject = new OShape(playground, position, true);
                break;

        }
        return gameObject;
    }

    public void move(KeyEvent ke, String caller) {
        //System.out.println(ke.getKeyCode());
        if ("keyReleased".equals(caller)) {
            // Debugovací výpis
            // System.out.println("Jsem v ifu metody move od třídy GameObject");
            switch (ke.getKeyCode()) {
                case 37:
                    // Debugovací výpis
                    //System.out.println("Posunuji vlevo.");
                    this.moveToSide("Left");
                    break;
                case 39:
                    // Debugovací výpis
                    //System.out.println("Posunuji vpravo.");
                    this.moveToSide("Right");
                    break;
                case 38:
                    // Debugovací výpis
                    //System.out.println("Otáčím.");
                    this.turn();
                    break;
                default:
                    break;

            }
        } else {
            // Debugovací výpis
            // System.out.println("Jsem v elsu metody move od třídy GameObject");
            switch (ke.getKeyCode()) {
                case 40:
                    // Debugovací výpis
                    //System.out.println("Posunuji dolů");
                    this.fallAnimate(5);
                    break;
                default:
                    break;
            }
        }

    }
    

    abstract public void moveToSide(String direction);

    abstract public void fallAnimate(int speed);

    abstract public void moveUp();
    
    abstract public GameObject fallCorrection();
    
    abstract public GameObject flyCorrection();

}
