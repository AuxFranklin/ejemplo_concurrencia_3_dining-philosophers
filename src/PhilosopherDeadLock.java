
import java.awt.Color;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** @author franklinvelasquezfuentes
 */
public class PhilosopherDeadLock  extends Thread {
    
    protected ChopstickDeadLock leftChopstick;
    protected ChopstickDeadLock rightChopstcik;
    protected JLabel lbPhilosopher;
    protected JLabel lbLeftHand;
    protected JLabel lbRightHand;

    public PhilosopherDeadLock(ChopstickDeadLock leftChopstick, ChopstickDeadLock rightChopstcik, JLabel lbPhilosopher, JLabel lbLeftHand, JLabel lbRightHand) {
        this.leftChopstick = leftChopstick;
        this.rightChopstcik = rightChopstcik;
        this.lbPhilosopher = lbPhilosopher;
        this.lbLeftHand = lbLeftHand;
        this.lbRightHand = lbRightHand;
    }
    
    public void pensar(){
        
        this.lbPhilosopher.setBorder(BorderFactory.createLineBorder(Color.black,5));
        try {
            Random rand = new Random();
            int random_time = rand.nextInt(60);
            Thread.sleep(random_time);
        } catch (Exception e) {
        }
    }
    
    public void levantarChopstricks(){
        leftChopstick.levantar(this.lbLeftHand);
        rightChopstcik.levantar(this.lbRightHand);
    }
    
    public void bajarChopsticks(){
        rightChopstcik.bajar(this.lbRightHand);
        leftChopstick.bajar(this.lbLeftHand);
    }
    
    
    public void comer(){
        levantarChopstricks();
        this.lbPhilosopher.setBorder(BorderFactory.createLineBorder(Color.blue,5));
        try {
            Random rand = new Random();
            int random_time = rand.nextInt(60);
            Thread.sleep(random_time);
        } catch (Exception e) {
        }
        bajarChopsticks();
         this.lbPhilosopher.setBorder(BorderFactory.createLineBorder(Color.black,5));
    }

    
    @Override
    public void run() {
        while(true){
            pensar();
            comer();
        }
    }
    
    

}
