/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget.layer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import org.blackchip.widget.AbstractLayer;
import org.blackchip.widget.Area;
import org.blackchip.widget.Styler;
import org.blackchip.widget.Widgets;

/**
 *
 * @author mcgann
 */
public class CircleTicks extends AbstractLayer
{

    private AffineTransform tf = new AffineTransform();

    public void draw(Graphics2D g, Area area)
    {
        Styler styler = getStyler();

        int radius = 93;
        float width = 1.5f;
        int length = 3;

        int ax = Widgets.getAnchorX(area, styler);
        int ay = Widgets.getAnchorY(area, styler);

        double psrc[] = new double[4];
        double pdst[] = new double[4];

        psrc[0] = 0; psrc[1] = radius;
        psrc[2] = 0; psrc[3] = radius + length;

        g.setStroke(new BasicStroke(width));

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                           RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(width));
        
        for ( int i = 0; i < 360; i += 6 )
        {
            tf.setToRotation(Math.toRadians(i));
            tf.transform(psrc, 0, pdst, 0, 2);
            if ( i % 30 == 0 )
            {
                g.setColor(Color.BLACK);
                g.fillRect((int)Math.round(pdst[0] + ax - 2), (int)Math.round(pdst[1] + ay - 2), 3, 3);
            }
            else
            {
                g.setColor(Color.GRAY);
                g.fillRect((int)Math.round(pdst[0] + ax - 1), (int)Math.round(pdst[1] + ay - 1), 2, 2);
            }

//            g.drawLine((int)Math.round(pdst[0] + ax), (int)Math.round(pdst[1] + ay),
//                       (int)Math.round(pdst[2] + ax), (int)Math.round(pdst[3] + ay));
        }
    }

}
