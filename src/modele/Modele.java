/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author philipp38u
 */
public class Modele extends Observable{
    private int[][] plateau;
    private int nbclick;
    private Point selection;
    private ArrayList<Point> Adjacent; 

    public Modele() {
        nbclick = 0;
        selection = null;
        Adjacent = new ArrayList<>();
        this.plateau = new int[5][5];
        for (int i = 0; i < 5; i ++){
            for(int j = 0; j < 5; j ++ ){
                plateau[i][j] = (int)(Math.random() * (5-1)) + 1;
            }
        }
    }
    
    public int getValue(Point P)
    {
        return plateau[P.x][P.y];
    }
    
    public int getNbClick(){
        return this.nbclick;
    }
    
    public void Click(Point P)
    {
        if(selection == null)
        {
            selection = P;
            Adjacent = CalculeADJ(plateau[P.x][P.y], P, new ArrayList());
        }
        else{
            if(Adjacent.contains(P))
            {
            
            }
            else
            {
                selection = P;
                Adjacent = CalculeADJ(plateau[P.x][P.y], P, new ArrayList());
            }
        }
        
        setChanged();
        notifyObservers();
    }
    
    public Point getSelect()
    {
        return this.selection;
    }
    
    public ArrayList<Point> getAdj(){
        return this.Adjacent;
    }
    
    public ArrayList CalculeADJ(int value, Point origine, ArrayList liste){
        if(origine.x >= 0 && origine.x < 5 && origine.y >= 0 && origine.y < 5){
            if( plateau[origine.x][origine.y] == value){
                if(!liste.contains(origine))
                {
                    liste.add(origine);
                    liste = CalculeADJ(value, new Point(origine.x-1, origine.y), liste);
                    liste = CalculeADJ(value, new Point(origine.x+1, origine.y), liste);
                    liste = CalculeADJ(value, new Point(origine.x, origine.y-1), liste);
                    liste = CalculeADJ(value, new Point(origine.x, origine.y+1), liste);
                }
            } 
        }
        return liste;
    }
    
    public void reset()
    {
        for (int i = 0; i < 5; i ++){
            for(int j = 0; j < 5; j ++ ){
                plateau[i][j] = (int)(Math.random() * (5-1)) + 1;
            }
        }
        this.nbclick = 0;
        Adjacent = new ArrayList<>();
        selection = null;
        setChanged();
        notifyObservers();
    }
}
