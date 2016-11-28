/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcdget10.Graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import pcdget10.Modele.Modele;

/**
 *
 * @author philipp38u
 */
public class Menu extends JMenuBar{
    private Modele modele;
    private JMenuItem reset;

    public Menu(Modele M) {
        super();
        modele = M;
        reset = new JMenuItem("Reset");
        
        
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               modele.reset();
            }
        });
        this.add(reset);
    }
    
    
}
