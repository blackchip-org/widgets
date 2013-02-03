/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget.layer;

import org.blackchip.widget.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

/**
 *
 * @author mcgann
 */
public class NeedleTriangle extends AbstractLayer
{
    private static final int   DEFAULT_WIDTH        = 10;
    private static final int   DEFAULT_RADIUS       = 50;
    private static final Color DEFAULT_COLOR        = Color.BLACK;
    private static final float DEFAULT_BORDER_WIDTH = 2f;

    private ValueModel model;
    private AffineTransform tf = new AffineTransform();

    private NeedleTriangle()
    {
    }

    public NeedleTriangle(ValueModel model)
    {
        this.model = model;
    }

    public void draw(Graphics2D g, Area a)
    {
        Styler styler = getStyler();

        int width = styler.getInt(Style.WIDTH, DEFAULT_WIDTH);
        int radius = styler.getInt(Style.RADIUS, DEFAULT_RADIUS);
        Color color = styler.getColor(Style.COLOR, DEFAULT_COLOR);
        Color borderColor = styler.getColor(Style.BORDER_COLOR, DEFAULT_COLOR);
        float borderWidth = styler.getFloat(Style.BORDER_WIDTH, DEFAULT_BORDER_WIDTH);

        int ax = Widgets.getAnchorX(a, styler);
        int ay = Widgets.getAnchorY(a, styler);

        double psrc[] = new double[6];
        double pdst[] = new double[6];

        psrc[0] = -(width / 2.0); psrc[1] = 0;
        psrc[2] =  (width / 2.0); psrc[3] = 0;
        psrc[4] =  0;             psrc[5] = -radius;

        tf.setToRotation(model.getAngleRadians());
        tf.transform(psrc, 0, pdst, 0, 3);

        Polygon p = new Polygon();
        p.addPoint((int)(pdst[0] + ax), (int)(pdst[1] + ay));
        p.addPoint((int)(pdst[2] + ax), (int)(pdst[3] + ay));
        p.addPoint((int)(pdst[4] + ax), (int)(pdst[5] + ay));

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                           RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.fillPolygon(p);

        g.setStroke(new BasicStroke(borderWidth));
        g.setColor(borderColor);
        g.drawPolygon(p);

    }


}
