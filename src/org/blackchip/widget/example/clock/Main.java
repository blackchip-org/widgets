/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget.example.clock;

import java.awt.Rectangle;
import javax.swing.JFrame;
import org.blackchip.widget.TimeController;
import org.blackchip.widget.TimeModel;

/**
 *
 * @author mcgann
 */
public class Main
{
    public static final void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TimeModel model = new TimeModel();
                TimeController tc = new TimeController(model);

                JFrame f1 = new ClockMacDashFrame(model);
                f1.setVisible(true);

                JFrame f3 = new ClockTimexFrame(model);
                f3.setBounds(f1.getWidth() + 50, 0, f3.getWidth(), f3.getHeight());
                f3.setVisible(true);
                
                JFrame f2 = new ClockControllerFrame(model, tc);
                f2.setBounds(0, f1.getHeight() + 50, f2.getWidth(), f2.getHeight());
                f2.setVisible(true);

            }
        });

    }

}
