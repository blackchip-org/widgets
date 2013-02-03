/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author mcgann
 */
public class WidgetPanel extends JPanel implements ValueListener
{
    private List<Layer> layers = new LinkedList<Layer>();

    public void addLayer(Layer layer)
    {
        layers.add(layer);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Area a = new Area(this.getWidth(), this.getHeight());
        for ( Layer layer: layers )
        {
            layer.draw((Graphics2D)g, a);
        }
    }

    public void valueChanged()
    {
        this.repaint();
    }

}
