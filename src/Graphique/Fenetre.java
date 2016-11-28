/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import Modele.Modele;

/**
 * @author philipp38u
 */
public class Fenetre extends JFrame {

    public Fenetre(){
    super("Get 10 - PCD") ;
    setPreferredSize(new Dimension(500, 500)) ;
    this.setLayout(new BorderLayout());
    Modele M = new Modele();
    this.setJMenuBar(new Menu(M));
    Plateau P = new Plateau(M);
    this.add(P, BorderLayout.CENTER);
    InfoGame I = new InfoGame(M);
    this.add(I, BorderLayout.SOUTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack() ;
    setVisible(true) ;
        
    }
    
}
