/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget.example.fuel;

import java.awt.Color;
import org.blackchip.widget.Anchor;
import org.blackchip.widget.Style;
import org.blackchip.widget.Styler;
import org.blackchip.widget.ValueModel;
import org.blackchip.widget.WidgetPanel;
import org.blackchip.widget.layer.Back;
import org.blackchip.widget.layer.FaceCircle;
import org.blackchip.widget.layer.NeedleLine;

/**
 *
 * @author mcgann
 */
public class FuelGaugePanel extends WidgetPanel {

    public FuelGaugePanel(ValueModel model) {

        Styler baseStyles = new Styler()
                .put(Style.ANCHOR, Anchor.CENTER)
                .put(Style.ANCHOR_OFFSET_X, 0)
                .put(Style.ANCHOR_OFFSET_Y, 0);

        Back back = new Back();
        back.setStyle(Style.COLOR, new Color(250, 250, 250));
        this.addLayer(back);

        NeedleLine needle = new NeedleLine(model);
        Styler needleStyler = new Styler(baseStyles)
                .put(Style.ANCHOR, Anchor.BOTTOM)
                .put(Style.COLOR,  Color.RED)
                .put(Style.RADIUS, 150)
                .put(Style.WIDTH,  3f);
        needle.setStyles(needleStyler);
        this.addLayer(needle);

        FaceCircle cap = new FaceCircle();
        Styler capStyler = new Styler(baseStyles)
                .put(Style.COLOR,           Color.GRAY)
                .put(Style.BORDER_COLOR,    Color.BLACK)
                .put(Style.RADIUS,          15)
                .put(Style.ANCHOR,          Anchor.BOTTOM);
        cap.setStyles(capStyler);
        this.addLayer(cap); 

    }
}
