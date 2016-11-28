/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcdget10.Graphique;
import java.awt.Point;
import javax.swing.JButton;

/**
 *
 * @author philipp38u
 */
public class GameButton extends JButton{
    private Point position;

    public GameButton(int X, int Y, String text){
        super(text);
        this.position = new Point(X, Y);
    }
    
    public Point getPosition(){
        return this.position;
    }
}