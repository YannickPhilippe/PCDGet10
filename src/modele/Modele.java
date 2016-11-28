/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import static modele.enumEtat.*;

/**
 *
 * @author philipp38u
 */
public class Modele extends Observable{
    private int[][] plateau;
    private int nbclick;
    private int nbCoups;
    private Point selection;
    private ArrayList<Point> Adjacent; 
    private enumEtat partie;

    public Modele() {
        nbclick = 0;
        this.nbCoups = 0;
        selection = null;
        Adjacent = new ArrayList<>();
        this.plateau = new int[5][5];
        for (int i = 0; i < 5; i ++){
            for(int j = 0; j < 5; j ++ ){
                plateau[i][j] = (int)(Math.random() * (4-1)) + 1;
            }
        }
        partie = InGame;
    }
    
    public int getValue(Point P){
        return plateau[P.x][P.y];
    }
    
    public int getNbClick(){
        return this.nbclick;
    }

    public int getNbCoups() {
        return nbCoups;
    }
    
    
    
    public void Click(Point P){
        this.nbclick ++;
        if(selection == null){
            selection = P;
            Adjacent = CalculeADJ(plateau[P.x][P.y], P, new ArrayList());
        }
        else{
            if(Adjacent.contains(P) && Adjacent.size() > 1){
                for (Point Pt : Adjacent) {
                    if(Pt.equals(P)){
                        plateau[Pt.x][Pt.y] ++;
                        if( plateau[Pt.x][Pt.y] == 10)
                        {
                            partie = win;
                        }
                    }else{
                        plateau[Pt.x][Pt.y] = 0;
                    }
                }
                rebuild();
                this.nbCoups ++;
                selection = null;
                Adjacent.clear();
            }
            else{
                selection = P;
                Adjacent = CalculeADJ(plateau[P.x][P.y], P, new ArrayList());
            }
        }
        
        setChanged();
        notifyObservers();
    }
    
    public Point getSelect(){
        return this.selection;
    }
    
    public ArrayList<Point> getAdj(){
        return this.Adjacent;
    }
    
    private void rebuild(){
        for (int j = 0; j < 05 ; j++ ){
           for (int i = 4; i >= 0 ; i-- ){
              if( this.plateau[i][j] == 0)
              {
                  if(i -1 >= 0)
                  {
                      this.plateau[i][j] = this.plateau[i-1][j];
                      this.plateau[i-1][j] = 0;
                  }
              }
           } 
        }
        for (int i = 0 ; i <5 ; i ++){
            for (int j = 0 ; j <5 ; j ++){
                if( this.plateau[i][j] == 0){
                     plateau[i][j] = (int)(Math.random() * (5-1)) + 1;
                }
            }
        }
    }
    
    public ArrayList CalculeADJ(int value, Point origine, ArrayList liste){
        if(origine.x >= 0 && origine.x < 5 && origine.y >= 0 && origine.y < 5){
            if( plateau[origine.x][origine.y] == value){
                if(!liste.contains(origine)){
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
    
    public enumEtat getEtat(){
        return this.partie;
    }
    
    public void reset()
    {
        for (int i = 0; i < 5; i ++){
            for(int j = 0; j < 5; j ++ ){
                plateau[i][j] = (int)(Math.random() * (4-1)) + 1;
            }
        }
        this.nbclick = 0;
        this.nbCoups = 0;
        partie = InGame;
        Adjacent = new ArrayList<>();
        selection = null;
        setChanged();
        notifyObservers();
    }
}
