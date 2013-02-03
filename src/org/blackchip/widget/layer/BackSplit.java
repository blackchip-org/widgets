/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget.layer;

import org.blackchip.widget.*;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author mcgann
 */
public class BackSplit extends AbstractLayer
{
    public void draw(Graphics2D g, Area a)
    {
        Styler styler = getStyler();
        Split split = styler.getSplit(Style.SPLIT, Split.HORIZONTAL);

        if ( split == Split.HORIZONTAL )
        {
            Color colorTop = styler.getColor(Style.COLOR_TOP, Color.WHITE);
            g.setColor(colorTop);
            int topHeight = (int)Math.floor(a.getHeight() / 2);
            g.fillRect(0, 0, a.getWidth(), topHeight);

            Color colorBottom = styler.getColor(Style.COLOR_BOTTOM,
                                                Color.BLACK);
            g.setColor(colorBottom);
            int bottomHeight = (int)Math.ceil(a.getHeight() - topHeight);
            g.fillRect(0, bottomHeight - 1, a.getWidth(), bottomHeight);

        }
        else
        {
            throw new UnsupportedOperationException();
        }
    }

}
