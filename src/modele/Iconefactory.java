/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import sun.security.jca.GetInstance;

/**
 *
 * @author philipp38u
 */
public class Iconefactory {
    private static Iconefactory instance = new Iconefactory();
    
    private Icon un;
    private Icon deux;
    private Icon trois;
    private Icon quatre;
    private Icon cinq;
    private Icon six;
    private Icon sept;
    private Icon huit;
    private Icon neuf;
    private Icon dix;
    
    private Iconefactory() {
        try{
            un = new ImageIcon("src/ressource/1.png");
        deux = new ImageIcon("src/ressource/2.png");
        trois = new ImageIcon("src/ressource/3.png");
        quatre = new ImageIcon("src/ressource/4.png");
        cinq = new ImageIcon("src/ressource/5.png");
        six = new ImageIcon("src/ressource/6.png");
        sept = new ImageIcon("src/ressource/7.png");
        huit = new ImageIcon("src/ressource/8.png");
        neuf = new ImageIcon("src/ressource/9.png");
        dix = new ImageIcon("src/ressource/10.png");
        }catch(Exception e)
        {
        e.printStackTrace();
        }
    
    }
    
    public static Iconefactory GetInstance(){return instance;}
    
    public Icon getIcone(int value)
    {
        switch(value){
            case 1:
                return this.un;
            case 2:
                return this.deux;
            case 3:
               return this.trois;
            case 4:
                return this.quatre;
            case 5:
                return this.cinq;
            case 6:
                return this.six; 
            case 7:
                return this.sept;
            case 8:
                return this.huit;
            case 9:
                return this.neuf;
            case 10:
                return this.dix;
        }
        return null;
    }
}
