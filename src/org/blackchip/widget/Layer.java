/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author mcgann
 */
public interface Layer
{
    void draw(Graphics2D g, Area area);

    void setStyle(Style style, Object value);

    void setStyles(Styler styler);

    Styler getStyler();
}
