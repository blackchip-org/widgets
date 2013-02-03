/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.blackchip.widget.util.Check;


/**
 *
 * @author mcgann
 */
public final class Styler
{
    private Map<Style,Object> styles = new HashMap<Style,Object>();

    public Styler()
    {
    }

    public Styler(Styler s)
    {
        put(s);
    }

    public Styler put(Style style, Object value)
    {
        Check.notNull(value);
        styles.put(style, value);
        return this;
    }

    public void put(Styler s)
    {
        for ( Style style: s.getStyles() )
        {
            put(style, s.getObject(style));
        }
    }

    public Set<Style> getStyles()
    {
        return styles.keySet();
    }

    public Object getObject(Style style)
    {
        return styles.get(style);
    }

    public int getInt(Style style, int defaultValue)
    {
        return styles.get(style) == null
               ? defaultValue
               : (Integer)styles.get(style);
    }

    public float getFloat(Style style, float defaultValue)
    {
        return styles.get(style) == null
               ? defaultValue
               : (Float)styles.get(style);
    }

    public Font getFont(Style style, Font defaultValue)
    {
        return styles.get(style) == null
               ? defaultValue
               : (Font)styles.get(style);
    }

    public Anchor getAnchor(Style style, Anchor defaultValue)
    {
        return styles.get(style) == null
               ? defaultValue
               : (Anchor)styles.get(style);
    }

    public Color getColor(Style style, Color defaultValue)
    {
        return styles.get(style) == null
               ? defaultValue
               : (Color)styles.get(style);
    }

    public Split getSplit(Style style, Split defaultValue)
    {
        return styles.get(style) == null
               ? defaultValue
               : (Split)styles.get(style);
    }
}
