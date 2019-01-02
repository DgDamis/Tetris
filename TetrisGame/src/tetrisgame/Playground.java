/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author Adam
 */
public class Playground extends JPanel {
    Window window;
    DefaultListModel model;
    
    public Playground(Window window, DefaultListModel model) {
        this.window = window;
        this.model = model;
        this.init();
    }
    
    
    private void init(){
        this.setBounds(30, 30, 500, 800);
        this.setBackground(Color.white);
        this.setFocusable(true);
    }
}
