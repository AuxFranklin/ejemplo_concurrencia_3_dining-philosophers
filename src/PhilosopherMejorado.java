
import java.awt.Color;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** @author franklinvelasquezfuentes
 */
public class PhilosopherMejorado extends PhilosopherDeadLock {
    
    public PhilosopherMejorado(ChopstickMejorado leftChopstick, ChopstickMejorado rightChopstcik, JLabel lbPhilosopher, JLabel lbLeftHand, JLabel lbRightHand) {
        super( leftChopstick,  rightChopstcik,  lbPhilosopher,  lbLeftHand,  lbRightHand) ;
    }
    
    
    /*
    bajarChopsticks() -> Queda Igual
    pensar() -> Queda Igual
    
    */
    
    
    public boolean puede_levantar_chopsticks(){
        if(!this.leftChopstick.puedeLevantar(lbLeftHand)){
            return false;
        }
        if(!this.rightChopstcik.puedeLevantar(lbRightHand)){
            leftChopstick.bajar(lbLeftHand);
            return false;
        }
        return true;
    }
    
    
    public void comer(){
        if(puede_levantar_chopsticks()){
            this.lbPhilosopher.setBorder(BorderFactory.createLineBorder(Color.blue,5));
             try {
            Random rand = new Random();
            int random_time = rand.nextInt(30);
            
            Thread.sleep(random_time);
            
            bajarChopsticks();
            this.lbPhilosopher.setBorder(BorderFactory.createLineBorder(Color.black,5));
        } catch (Exception e) {
        }
        } else {
        }
        
    }
    
    

}
