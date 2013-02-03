/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget;

/**
 *
 * @author mcgann
 */
public abstract class AbstractLayer implements Layer
{
    private Styler styler = new Styler();

    public void setStyle(Style style, Object value)
    {
        styler.put(style, value);
    }

    public void setStyles(Styler s)
    {
        for ( Style style: s.getStyles() )
        {
            this.styler.put(style, s.getObject(style));
        }
    }

    public Styler getStyler()
    {
        return styler;
    }

}
