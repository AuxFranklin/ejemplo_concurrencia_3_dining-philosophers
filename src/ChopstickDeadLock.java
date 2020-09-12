
import java.awt.Color;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** @author franklinvelasquezfuentes
 */
public class ChopstickDeadLock {
    // Clase del Palillo = Chopstick
    
    protected JLabel lbChostick;
    protected ReentrantLock candado;


    public ChopstickDeadLock(JLabel lbChostick) {
        this.lbChostick = lbChostick;
        this.candado =  new ReentrantLock();
    }
    
    
    public void levantar(JLabel lbHand){
        candado.lock();
        this.lbChostick.setBorder(BorderFactory.createLineBorder(Color.red,1));
        lbHand.setForeground(Color.red);
    }
    
    
    public void bajar(JLabel lbHand){
        this.lbChostick.setBorder(BorderFactory.createLineBorder(Color.black,1));
        lbHand.setForeground(Color.black);
        candado.unlock();
    }
    
    
    
    // ahorita no es funcional
    public boolean puedeLevantar(JLabel lbHand){
        return true;
    }
  
}
