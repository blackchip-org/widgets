/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget.example.fuel;

import javax.swing.JFrame;

/**
 *
 * @author mcgann
 */
public class Main {

    public static final void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f1 = new FuelGaugeFrame();
                f1.setVisible(true);
            }

        });
    }
}
