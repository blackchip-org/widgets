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

/**
 *
 * @author mcgann
 */
public class FaceCircle extends AbstractLayer
{

    public void draw(Graphics2D g, Area area)
    {
        Styler styler = getStyler();
        int radius        = styler.getInt  (Style.RADIUS, 10);
        Color color       = styler.getColor(Style.COLOR, Color.GREEN);
        Color borderColor = styler.getColor(Style.BORDER_COLOR, Color.RED);
        float borderWidth = styler.getFloat(Style.BORDER_WIDTH, 2f);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                           RenderingHints.VALUE_ANTIALIAS_ON);

        int ax = Widgets.getAnchorX(area, styler);
        int ay = Widgets.getAnchorY(area, styler);

        int ulx = ax - radius;
        int uly = ay - radius;

        g.setColor(color);
        g.fillOval(ulx, uly, radius * 2, radius * 2);

        g.setColor(borderColor);
        g.setStroke(new BasicStroke(borderWidth));
        g.drawOval(ulx, uly, radius * 2, radius * 2);

    }

}
