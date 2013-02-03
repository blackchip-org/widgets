/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget.layer;

import java.awt.Color;
import java.awt.Graphics2D;
import org.blackchip.widget.AbstractLayer;
import org.blackchip.widget.Area;
import org.blackchip.widget.Style;
import org.blackchip.widget.Styler;

/**
 *
 * @author mcgann
 */
public class Back extends AbstractLayer
{
    private Color DEFAULT_COLOR = Color.WHITE;

    public void draw(Graphics2D g, Area area)
    {
        Styler styler = getStyler();

        Color color = styler.getColor(Style.COLOR, DEFAULT_COLOR);
        g.setColor(color);
        g.fillRect(0, 0, area.getWidth(), area.getHeight());
    }

}
