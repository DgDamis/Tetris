/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Adam
 */
public abstract class IShape extends GameObject {

    public IShape(Playground playground, ArrayList<Cube> cubes, Point position) {
        this.playground = playground;
        this.cubes = cubes;
        this.position = position;
    }
    Playground playground;
    ArrayList <Cube> cubes;
    protected Point position;
    protected int size;
    
    public void create(){
        int x = -200;
        for(int i=0;i<4;i++){
            cubes.add(new Cube(playground,new Point(position.x+x,position.y)));
            x+=100;
        }
    }
    /*    
    public void paintComponent(Graphics gr){
        for(Cube cube : cubes){
            cube.paint(gr);
        }
    }
    */
}
