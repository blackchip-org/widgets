/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author mcgann
 */
public class TimeController
{

    private TimeModel model;
    private Timer timer;

    private TimeController()
    {
    }

    public TimeController(TimeModel model)
    {
        this.model = model;
        timer = new Timer(100, new TimeTask());
        timer.start();
    }

    public void stop()
    {
        timer.stop();
    }

    public void start()
    {
        timer.start();
    }

    public boolean isRunning()
    {
        return timer.isRunning();
    }

    class TimeTask implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            model.setCurrentTime();
        }
    }



}
