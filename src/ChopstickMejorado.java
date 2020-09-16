
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** @author franklinvelasquezfuentes
 */
public class ChopstickMejorado extends ChopstickDeadLock{

    public ChopstickMejorado(JLabel lbChopstick) {
        super(lbChopstick);
    }
    
    /*
    levantar() queda igual
    */
//    public void levantar(JLabel lbHand){
//        candado.lock();
//        this.lbChostick.setBorder(BorderFactory.createLineBorder(Color.red,1));
//        lbHand.setForeground(Color.red);
//    }

    
    
    @Override
    public boolean puedeLevantar(JLabel lbHand) {
        boolean pudo_levantar = candado.tryLock();
        if(pudo_levantar){
            this.lbChostick.setBorder(BorderFactory.createLineBorder(Color.red,1));
            lbHand.setForeground(Color.red);
        }
        return pudo_levantar;
    }
    

    
    
    
    

}
