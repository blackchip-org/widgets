/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget.layer;

import org.blackchip.widget.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

/**
 *
 * @author mcgann
 */
public class NeedleLine extends AbstractLayer
{
    private static final float DEFAULT_WIDTH  = 2f;
    private static final int   DEFAULT_RADIUS = 10;
    private static final Color DEFAULT_COLOR  = Color.BLACK;
    private static final int   DEFAULT_TAIL_LENGTH = 0;

    private ValueModel model;
    private AffineTransform tf = new AffineTransform();

    private NeedleLine()
    {
    }

    public NeedleLine(ValueModel model)
    {
        this.model = model;
    }
    
    public void draw(Graphics2D g, Area a)
    {
        Styler styler = getStyler();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                           RenderingHints.VALUE_ANTIALIAS_ON);
        
        float width = styler.getFloat(Style.WIDTH, DEFAULT_WIDTH);
        int radius = styler.getInt(Style.RADIUS, DEFAULT_RADIUS);
        Color color = styler.getColor(Style.COLOR, DEFAULT_COLOR);
        int tailLength = styler.getInt(Style.TAIL_LENGTH, DEFAULT_TAIL_LENGTH);

        int ax = Widgets.getAnchorX(a, styler);
        int ay = Widgets.getAnchorY(a, styler);

        double psrc[] = new double[4];
        double pdst[] = new double[4];

        psrc[0] = 0; psrc[1] = tailLength;
        psrc[2] = 0; psrc[3] = -radius;

        tf.setToRotation(model.getAngleRadians());
        tf.transform(psrc, 0, pdst, 0, 2);

        g.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.setColor(color);
        g.drawLine((int)Math.round(pdst[0] + ax), (int)Math.round(pdst[1] + ay),
                   (int)Math.round(pdst[2] + ax), (int)Math.round(pdst[3] + ay));
    }

}
