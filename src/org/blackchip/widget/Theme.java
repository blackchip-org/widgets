/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mcgann
 */
public class Theme
{
    private String name;
    private Map<Layer,Styler> stylers = new HashMap<Layer,Styler>();

    private Theme()
    {
    }

    public Theme(String name)
    {
        this.name = name;
    }

    public void setStyler(Layer layer, Styler styler)
    {
        stylers.put(layer, styler);
    }

    public Theme put(Layer layer, Style style, Object value)
    {
        Styler styler = stylers.get(layer);
        if ( styler == null )
        {
            styler = new Styler();
            stylers.put(layer, styler);
        }
        styler.put(style, value);
        return this;
    }

    public void apply()
    {
        for ( Layer layer: stylers.keySet() )
        {
            layer.setStyles(stylers.get(layer));
        }
    }

}
