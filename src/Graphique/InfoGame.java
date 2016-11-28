/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Modele;

/**
 *
 * @author philipp38u
 */
public class InfoGame extends JPanel implements Observer{
    private Modele modele;
    private JLabel nbClick;

    public InfoGame(Modele M) {
        this.modele = M;
        modele.addObserver(this);
        nbClick = new JLabel("NB Click = 0");
        this.add(nbClick);
    }

    @Override
    public void update(Observable o, Object arg) {
       nbClick.setText("NB Click = "+modele.getNbClick());
    }
    
    
}
