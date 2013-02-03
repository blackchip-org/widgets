/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget.layer;

import org.blackchip.widget.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author mcgann
 */
public class ClockNumbers extends AbstractLayer
{
    private static Color DEFAULT_COLOR  = Color.WHITE;
    private static Font  DEFAULT_FONT   = new Font(Font.SERIF, Font.PLAIN, 20);
    private static int   DEFAULT_RADIUS = 10;

    public void draw(Graphics2D g, Area area)
    {
        Styler styler = getStyler();

        Color color  = styler.getColor(Style.COLOR , DEFAULT_COLOR);
        Font  font   = styler.getFont (Style.FONT  , DEFAULT_FONT );
        int   radius = styler.getInt  (Style.RADIUS, DEFAULT_RADIUS);

        int ax = Widgets.getAnchorX(area, styler);
        int ay = Widgets.getAnchorY(area, styler);

        g.setColor(color);
        g.setFont(font);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                           RenderingHints.VALUE_ANTIALIAS_ON);

        FontMetrics fm = g.getFontMetrics(font);

        for ( int i = 1; i <= 12; i++ )
        {
            int angle = i * 30 - (30 * 3);
            int x = (int)(radius * Math.cos(Math.toRadians(angle)));
            int y = (int)(radius * Math.sin(Math.toRadians(angle)));

            String numeral = String.valueOf(i);
            Rectangle2D bounds = fm.getStringBounds(numeral, g);

            int bw = (int)(bounds.getWidth() / 2);
            int bh = (int)(bounds.getHeight() / 2 - 3);

            g.drawString(numeral, x + ax - bw,
                                  y + ay + bh);
        }
    }

}
