/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget.example.clock;

import java.awt.Color;
import java.awt.Font;
import org.blackchip.widget.Anchor;
import org.blackchip.widget.layer.BackSplit;
import org.blackchip.widget.layer.ClockNumbers;
import org.blackchip.widget.layer.FaceCircle;
import org.blackchip.widget.layer.NeedleLine;
import org.blackchip.widget.layer.NeedleTriangle;
import org.blackchip.widget.Split;
import org.blackchip.widget.Style;
import org.blackchip.widget.Styler;
import org.blackchip.widget.Theme;
import org.blackchip.widget.TimeModel;
import org.blackchip.widget.WidgetPanel;

/**
 *
 * @author mcgann
 */
public class ClockMacDashPanel extends WidgetPanel
{
    private static int RADIUS_FACE = 100;
    private static int RADIUS_NUMBERS = RADIUS_FACE - 20;
    private static int RADIUS_SECONDS = RADIUS_NUMBERS;
    private static int RADIUS_MINUTES = RADIUS_SECONDS - 10;
    private static int RADIUS_HOURS   = RADIUS_MINUTES - 20;

    private static Color DAY_NEEDLE_BORDER   = new Color(32, 32, 32);
    private static Color NIGHT_NEEDLE_BORDER = new Color(225, 225, 225);

    private Theme dayTheme;
    private Theme nightTheme;

    public ClockMacDashPanel(TimeModel model)
    {
        dayTheme = new Theme("Day");
        nightTheme = new Theme("Night");

        Styler baseStyles = new Styler()
                .put(Style.ANCHOR, Anchor.CENTER)
                .put(Style.ANCHOR_OFFSET_X, 0)
                .put(Style.ANCHOR_OFFSET_Y, 0);

        BackSplit back = new BackSplit();
        Styler backStyles = new Styler(baseStyles)
                  .put(Style.SPLIT, Split.HORIZONTAL);
        dayTheme  .put(back, Style.COLOR_TOP,    new Color(200, 200, 255))
                  .put(back, Style.COLOR_BOTTOM, new Color(200, 255, 200));
        nightTheme.put(back, Style.COLOR_TOP,    new Color(64, 64, 64))
                  .put(back, Style.COLOR_BOTTOM, Color.BLACK);
        back.setStyles(backStyles);
        this.addLayer(back);

        FaceCircle face = new FaceCircle();
        Styler faceStyles = new Styler(baseStyles)
                  .put(Style.BORDER_COLOR, new Color(128, 128, 128))
                  .put(Style.BORDER_WIDTH, 2f)
                  .put(Style.RADIUS, RADIUS_FACE);
        dayTheme  .put(face, Style.COLOR, Color.WHITE);
        nightTheme.put(face, Style.COLOR, Color.BLACK);
        face.setStyles(faceStyles);
        this.addLayer(face);

        ClockNumbers numbers = new ClockNumbers();
        Styler numberStyles = new Styler(baseStyles)
                  .put(Style.FONT, new Font(Font.SERIF, Font.PLAIN, 20))
                  .put(Style.RADIUS, RADIUS_NUMBERS);
        dayTheme  .put(numbers, Style.COLOR, Color.BLACK);
        nightTheme.put(numbers, Style.COLOR, Color.WHITE);
        numbers.setStyles(numberStyles);
        this.addLayer(numbers);

        NeedleTriangle hours = new NeedleTriangle(model.getHourModel());
        Styler hourStyles = new Styler(baseStyles)
                  .put(Style.BORDER_COLOR, new Color(200, 200, 200))
                  .put(Style.BORDER_WIDTH, 2f)
                  .put(Style.RADIUS, RADIUS_HOURS)
                  .put(Style.WIDTH, 15);
        dayTheme  .put(hours, Style.COLOR, Color.BLACK)
                  .put(hours, Style.BORDER_COLOR, DAY_NEEDLE_BORDER);
        nightTheme.put(hours, Style.COLOR, Color.WHITE)
                  .put(hours, Style.BORDER_COLOR, NIGHT_NEEDLE_BORDER);
        hours.setStyles(hourStyles);
        this.addLayer(hours);

        NeedleTriangle minutes = new NeedleTriangle(model.getMinuteModel());
        Styler minuteStyles = new Styler(baseStyles)
                  .put(Style.BORDER_WIDTH, 2f)
                  .put(Style.RADIUS, RADIUS_MINUTES)
                  .put(Style.WIDTH, 15);
        dayTheme  .put(minutes, Style.COLOR, Color.BLACK)
                  .put(minutes, Style.BORDER_COLOR, DAY_NEEDLE_BORDER);
        nightTheme.put(minutes, Style.COLOR, Color.WHITE)
                  .put(minutes, Style.BORDER_COLOR, NIGHT_NEEDLE_BORDER);
        minutes.setStyles(minuteStyles);
        this.addLayer(minutes);

        FaceCircle firstCap = new FaceCircle();
        Styler firstCapStyles = new Styler(baseStyles)
                  .put(Style.BORDER_COLOR, new Color(220, 220, 220))
                  .put(Style.RADIUS, 10);
        dayTheme  .put(firstCap, Style.COLOR, Color.BLACK);
        nightTheme.put(firstCap, Style.COLOR, Color.WHITE);
        firstCap.setStyles(firstCapStyles);
        this.addLayer(firstCap);

        NeedleLine seconds = new NeedleLine(model.getSecondModel());
        Styler secondStyles = new Styler(baseStyles)
                .put(Style.COLOR, Color.RED)
                .put(Style.WIDTH, 2f)
                .put(Style.RADIUS, RADIUS_SECONDS);
        seconds.setStyles(secondStyles);
        this.addLayer(seconds);

        FaceCircle secondCap = new FaceCircle();
        Styler secondCapStyles = new Styler(baseStyles)
                .put(Style.COLOR, Color.RED)
                .put(Style.RADIUS, 4);
        secondCap.setStyles(secondCapStyles);
        this.addLayer(secondCap);

        day();
    }

    public void day()
    {
        dayTheme.apply();
        repaint();
    }

    public void night()
    {
        nightTheme.apply();
        repaint();
    }

}
