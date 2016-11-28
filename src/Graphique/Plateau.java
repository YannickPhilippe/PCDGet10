/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcdget10.Graphique;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import pcdget10.Modele.Modele;

/**
 *
 * @author philipp38u
 */
public class Plateau extends JPanel implements Observer{
    private Modele modele;
    private ArrayList<GameButton> listebutton; 

    public Plateau(Modele modele) {
        this.setLayout(new GridLayout(5, 5));
        
        this.modele = modele;
        modele.addObserver(this);
        
        this.listebutton = new ArrayList<>();
        
        for (int i = 0; i <5; i ++){
            for (int j = 0; j < 5; j ++){
            GameButton B = new GameButton(i, j, "");
            B.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Bouton X : "+B.getPosition().x+" Y : "+B.getPosition().y+" = "+modele.getValue(B.getPosition()));
                    modele.Click(B.getPosition());
                }
            });
            this.add(B);
            
            listebutton.add(B);
            }
        }
        this.update(null, null);
    }

    
    public void update(Observable o, Object arg) {
        for (GameButton b : listebutton) {
          if(modele.getSelect() != null)
          {
              if(modele.getSelect().equals(b.getPosition()))
              {
                  b.setForeground(Color.red);
              }
              else{
                  b.setForeground(Color.BLACK);
              }
          }
          if(modele.getAdj() != null)
          {
              ArrayList ADJ = modele.getAdj();
              if(ADJ.contains(b.getPosition()))
              {
                  b.setForeground(Color.red);
                  b.setBorder(new LineBorder(Color.BLACK, 8));
              }
              else{
                 b.setBorder(new LineBorder(Color.WHITE, 3));
                  b.setForeground(Color.BLACK);
              }
          }
          b.setText(modele.getValue(b.getPosition())+""); 
        }
    }
}
