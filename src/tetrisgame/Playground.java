package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Adam Šmehýl
 */
public class Playground extends JPanel implements ActionListener {

    private Timer timer;
    Window window;
    DefaultListModel model;
    ArrayList<GameObject> objects;
    GameObject floor;
    GameObject ceiling;
    GameObject pendingObject;

    public Playground(Window window, DefaultListModel model) {
        this.window = window;
        this.model = model;
        this.init();
    }

    @Override
    protected void paintComponent(Graphics gr) {
        // Vyvolání této funkce, pro vykreslení
        super.paintComponent(gr);
        // Vykreslení všech objektů
        for (GameObject ob : objects) {
            ob.paint(gr);
        }
        // Vykreslení podlahy a stropu
        floor.paint(gr);
        ceiling.paint(gr);
    }
    // Testovací provoz, přidání dalšího objektu po kliknutí na tlačítko
    public void addObject() {
        objects.add(new IShape(this, new Point(150, 100), true));
    }
    
    // Inicializace herního pole
    private void init() {
        // Odsazení herního pole
        this.setBounds(30, 30, 500, 800);
        this.setBackground(Color.white);
        this.setFocusable(true);
        objects = new ArrayList();
        // Testovací provoz, přidání dvou testovacích objektů
        //objects.add(new IShape(this, new Point(100, 100), true));
        //objects.add(new IShape(this, new Point(100, 300), true));
        // Vytvoření podlahy, stropu
        floor = new Floor(this);
        ceiling = new Ceiling(this);
        // Inicializace timeru
        timer = new Timer(16, this);
        timer.start();
    }

    // Funkce volaná timerem
    @Override
    public void actionPerformed(ActionEvent e) {
        // Procházení pole herních objektů
        for (GameObject objekt : objects) {
            // Zjištění, jestli se jedná o aktivní objekt
            if (objekt.active) {
                // Aktivní (tedy padající) objekt se posune níže
                objekt.fallAnimate();
                // Zjištění, jestli posunutý objekt nekoliduje s jiným (neaktivním, odehraným) objektem
                for (GameObject testedObjekt : objects) {
                    // Vynechání sebe sama pro test kolize
                    if (objekt == testedObjekt) {
                        continue;       
                    }
                    // Samotný test kolize
                    if (objekt.getCollision(testedObjekt)) {
                        // V případě kolize s jiným objektem dojde k vyjmutí ven
                        while (objekt.getCollision(testedObjekt) != Boolean.FALSE) {
                        objekt.moveUp();
                        }
                        // Deaktivace objektu v případě kolize
                        objekt.setActive(Boolean.FALSE);
                        pendingObject = new IShape(this, new Point(150, 100), true);
                    }
                }
                // Zjištění, zda objekt nekoliduje s podlahou
                if (floor.getFloorCollision(objekt)) {
                    // V případě kolize je objekt posunut nad podlahu
                    while (floor.getFloorCollision(objekt) != Boolean.FALSE) {
                        objekt.moveUp();
                    }
                    // Deaktivace objektu po usazení na podlahu
                    objekt.setActive(Boolean.FALSE);
                    pendingObject = new IShape(this, new Point(150, 100), true);
                }
                // V případě naplnění herního pole, naskladání objektů na sebe, dojde k ukončení hry
                if (ceiling.getCeilingCollision(objekt)) {
                    objects.clear();
                    this.repaint();
                    timer.stop();
                }
            }
        }
        if(pendingObject != null){
        objects.add(pendingObject);
        }
        pendingObject = null;
        //Obnovení herního pole
        this.repaint();
    }
}
