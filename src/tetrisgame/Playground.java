package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Adam Šmehýl
 */
public class Playground extends JPanel implements ActionListener, KeyListener {

    public Timer timer;
    Window window;
    DefaultListModel model;
    ArrayList<GameObject> objects;
    GameObject copyActive;
    GameObject floor;
    GameObject ceiling;
    GameObject pendingObject;
    GameObject leftWall;
    GameObject rightWall;
    ArrayList<GameObject> backgroundLayers;
    Point defaultStartingPoint = new Point((this.getWidth() / 2) + 50, 100);
    int lastObject;
    int beforeLastObject;
    public int skore = 0;
    Boolean gameStart = Boolean.FALSE;

    public Playground(Window window, DefaultListModel model) {
        this.window = window;
        this.model = model;
        this.init();
    }

    @Override
    protected void paintComponent(Graphics gr) {
        // Vyvolání této funkce, pro vykreslení
        super.paintComponent(gr);
        window.setSkore(skore);
        // Vykreslení všech objektů
        for (GameObject ob : objects) {
            ob.paint(gr);
        }
        // Vykreslení podlahy a stropu, levé a pravé stěny
        floor.paint(gr);
        ceiling.paint(gr);
        leftWall.paint(gr);
        rightWall.paint(gr);
        // Debugovací kód, vykreslení pozadí
        //for (GameObject layer : backgroundLayers) {
        //    layer.paint(gr);
        //}

        // Game Logic
        ArrayList<GameObject> newArrayList;
        ArrayList<GameObject> newArrayList2;
        ArrayList<GameObject> tempArray1;
        tempArray1 = new ArrayList();
        newArrayList2 = new ArrayList();
        newArrayList = new ArrayList(objects);
        Boolean layerCleared = Boolean.FALSE;
        Boolean checkLayers = Boolean.FALSE;
        // Procházení pole herních objektů
        for (GameObject objekt : objects) {
            // Zjištění, jestli se jedná o aktivní objekt
            if (objekt.active) {
                copyActive = objekt;
                // Aktivní (tedy padající) objekt se posune níže
                objekt.fallAnimate(2);

                // Zjištění, jestli posunutý objekt nekoliduje s jiným (neaktivním, odehraným) objektem
                for (GameObject testedObjekt : objects) {
                    // Vynechání sebe sama pro test kolize
                    if (objekt == testedObjekt) {
                        continue;
                    }
                    // Samotný test kolize
                    if (objekt.getCollision(testedObjekt)) {
                        // V případě kolize s jiným objektem dojde k vyjmutí ven
                        while (objekt.getCollision(testedObjekt)) {
                            objekt.moveUp();
                        }
                        // Deaktivace objektu v případě kolize
                        objekt.setActive(Boolean.FALSE);
                        checkLayers = Boolean.TRUE;
                        // Pokud dojde k deaktivaci herního objektu, vytvoří se nový objekt čekající na přidání 
                        pendingObject = getRandomObject(defaultStartingPoint);
                    }
                }

                // Zjištění, zda objekt nekoliduje s podlahou
                if (floor.getFloorCollision(objekt)) {
                    // V případě kolize je objekt posunut nad podlahu
                    while (floor.getFloorCollision(objekt)) {
                        objekt.moveUp();
                    }
                    // Deaktivace objektu po usazení na podlahu
                    objekt.setActive(Boolean.FALSE);
                    checkLayers = Boolean.TRUE;
                    // Pokud dojde k deaktivaci herního objektu, vytvoří nový objekt čekající na přidání 
                    pendingObject = getRandomObject(defaultStartingPoint);
                }

                // V případě naplnění herního pole, naskladání objektů na sebe, dojde k ukončení hry
                if (ceiling.getCeilingCollision(objekt)) {
                    newArrayList.clear();
                    this.repaint();
                    timer.stop();
                    gameStart = Boolean.FALSE;
                    window.setGameOver(Boolean.TRUE);
                    pendingObject = null;
                }
                // V případě naražení do zdí, je zamezeno útěku ven
                if (leftWall.getLeftWallCollision(objekt)) {
                    while (leftWall.getLeftWallCollision(objekt)) {
                        objekt.moveToSide("Right");
                    }
                }
                if (rightWall.getRightCollision(objekt)) {
                    while (rightWall.getRightCollision(objekt)) {
                        objekt.moveToSide("Left");
                    }
                }
                ////////////

            }
            // Konec procházení objektů
        }

        // Kontrola naplnění řady
        if (checkLayers) {
            for (GameObject layer : backgroundLayers) {
                //System.out.print("Počet kolizí ve vrstvě: ");
                //System.out.println(layer.getNumberOfCollisionInLayer(objects));
                // Jesliže je řada zaplněná, je její obsah vymazán
                if (layer.getNumberOfCollisionInLayer(objects) >= 10) {
                    System.out.println("Mažu vrstvu");
                    newArrayList = layer.getUpdatedArrayOfObjects(objects);
                    // Uvedení informace, že došlo ke smazání vrstvy a úpravě objektů
                    layerCleared = Boolean.TRUE;
                    skore += 10000;
                }
            }
        }
        if (layerCleared) {
            // Vše, co zbylo na herním poli, je posunuto dolů
            for (GameObject objekt2 : newArrayList) {
                tempArray1.add(objekt2.fallCorrection());
            }
            newArrayList = new ArrayList(tempArray1);
            // Kontrola kolize s podlahou
            tempArray1 = new ArrayList();
            for (GameObject objekt : newArrayList) {
                if (floor.getFloorCollision(objekt)) {
                    tempArray1.add(objekt.flyCorrection());
                } else {
                    tempArray1.add(objekt);
                }
            }
            newArrayList = new ArrayList(tempArray1);
            // Pokud dojde k posunu do jiného objektu, je objekt navrácen do původní pozice
            /*
            tempArray1 = new ArrayList();
            for (GameObject objekt : newArrayList) {
                // Zjištění, zda každy objekt nekoliduje s ostatními
                for (GameObject testedObjekt : newArrayList) {
                    // Vynechání sebe sama pro test kolize
                    if (objekt == testedObjekt) {
                        continue;
                    }
                    // Samotný test kolize
                    if (objekt.getCollision(testedObjekt)) {
                        // V případě kolize s jiným objektem dojde k návratu
                        //while (objekt.getCollision(testedObjekt)) {
                            tempArray1.add(objekt.flyCorrection());
                        //}
                    } else {
                        tempArray1.add(objekt);
                    }
                }
            }
             */
            // Opravené (posunuté pole) je vráceno zpět
            newArrayList = new ArrayList(tempArray1);
        }
        // Aktualizace pole objektů
        objects = new ArrayList(newArrayList);
        // Pokud existuje objekt čekající na přidání, je přidán
        if (pendingObject != null) {
            objects.add(pendingObject);
            pendingObject = null;
        }

    }
    // Testovací provoz, přidání dalšího objektu po kliknutí na tlačítko

    public void addObject() {
        if (Objects.equals(gameStart, Boolean.FALSE)) {
            objects.add(getRandomObject(defaultStartingPoint));
            gameStart = Boolean.TRUE;
        }
        this.requestFocusInWindow();
    }

    // Inicializace herního pole
    private void init() {
        // Odsazení herního pole
        this.setBounds(30, 30, 500, 800);
        this.setBackground(Color.white);
        this.setFocusable(true);
        // Inicializace poslouchače klávesnice
        this.addKeyListener(this);
        window.setTitle("Tetris");
        objects = new ArrayList();
        backgroundLayers = new ArrayList();
        // Testovací provoz, přidání dvou testovacích objektů
        //objects.add(new IShape(this, new Point(100, 100), true));
        //objects.add(new IShape(this, new Point(100, 300), true));
        // Vytvoření podlahy, stropu, levé a pravé stěny
        floor = new Floor(this);
        ceiling = new Ceiling(this);
        leftWall = new LeftWall(this);
        rightWall = new RightWall(this);
        // Vytvoření herních vrstev
        for (int i = 0; i < this.getHeight() / 50; i++) {
            backgroundLayers.add(new PlaygroundLayer(this, new Point(0, i * 50)));
        }
        // Inicializace timeru
        timer = new Timer(16, this);
    }

    // Funkce volaná timerem
    @Override
    public void actionPerformed(ActionEvent e) {
        //Obnovení herního pole
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //System.out.println("keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //System.out.println("keyPressed");
        if (copyActive != null) {
            copyActive.move(ke, "keyTyped");
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //System.out.println("keyReleased");
        if (copyActive != null) {
            copyActive.move(ke, "keyReleased");
        }
    }

    public GameObject getRandomObject(Point position) {
        GameObject gameObject;
        Random rand = new Random();
        int n = rand.nextInt(7) + 1;
        while (n == lastObject || n == beforeLastObject) {
            n = rand.nextInt(7) + 1;
        }
        beforeLastObject = lastObject;
        lastObject = n;
        switch (n) {
            default:
                gameObject = new IShape(this, new Point(150, 0), true);
                break;
            case 2:
                gameObject = new OShape(this, new Point(150, 0), true);
                break;
            case 3:
                gameObject = new JShape(this, new Point(150, 0), true);
                break;
            case 4:
                gameObject = new LShape(this, new Point(150, 0), true);
                break;
            case 5:
                gameObject = new SShape(this, new Point(150, 0), true);
                break;
            case 6:
                gameObject = new TShape(this, new Point(150, 0), true);
                break;
            case 7:
                gameObject = new ZShape(this, new Point(150, 0), true);
                break;
        }

        return gameObject;
    }

}
