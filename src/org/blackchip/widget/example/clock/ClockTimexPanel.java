/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget.example.clock;

import java.awt.Color;
import java.awt.Font;
import org.blackchip.widget.Anchor;
import org.blackchip.widget.layer.ClockNumbers;
import org.blackchip.widget.layer.FaceCircle;
import org.blackchip.widget.Style;
import org.blackchip.widget.Styler;
import org.blackchip.widget.TimeModel;
import org.blackchip.widget.WidgetPanel;
import org.blackchip.widget.layer.Back;
import org.blackchip.widget.layer.CircleTicks;
import org.blackchip.widget.layer.NeedleLine;

/**
 *
 * @author mcgann
 */
public class ClockTimexPanel extends WidgetPanel
{
    private static int RADIUS_FACE = 100;
    private static int RADIUS_NUMBERS = RADIUS_FACE - 20;
    private static int RADIUS_SECONDS = RADIUS_NUMBERS;
    private static int RADIUS_MINUTES = RADIUS_SECONDS - 10;
    private static int RADIUS_HOURS   = RADIUS_MINUTES - 20;

//    private static Color DAY_NEEDLE_BORDER   = new Color(32, 32, 32);
//    private static Color NIGHT_NEEDLE_BORDER = new Color(225, 225, 225);


    public ClockTimexPanel(TimeModel model)
    {

        Styler baseStyles = new Styler()
                .put(Style.ANCHOR, Anchor.CENTER)
                .put(Style.ANCHOR_OFFSET_X, 0)
                .put(Style.ANCHOR_OFFSET_Y, 0);

        Back back = new Back();
        back.setStyle(Style.COLOR, new Color(80, 80, 80));
        this.addLayer(back);
        
        FaceCircle face = new FaceCircle();
        Styler faceStyles = new Styler(baseStyles)
                  .put(Style.BORDER_COLOR, new Color(128, 128, 128))
                  .put(Style.BORDER_WIDTH, 2f)
                  .put(Style.RADIUS, RADIUS_FACE)
                  .put(Style.COLOR, Color.WHITE);
        face.setStyles(faceStyles);
        this.addLayer(face);

        CircleTicks ticks = new CircleTicks();
        Styler tickStyles = new Styler(baseStyles);
        ticks.setStyles(tickStyles);
        this.addLayer(ticks);
        
        ClockNumbers numbers = new ClockNumbers();
        Styler numberStyles = new Styler(baseStyles)
                  .put(Style.FONT, new Font(Font.SERIF, Font.PLAIN, 20))
                  .put(Style.RADIUS, RADIUS_NUMBERS)
                  .put(Style.COLOR, Color.BLACK);
        numbers.setStyles(numberStyles);
        this.addLayer(numbers);

        NeedleLine hours = new NeedleLine(model.getHourModel());
        Styler hourStyles = new Styler(baseStyles)
                .put(Style.COLOR, Color.BLACK)
                .put(Style.WIDTH, 5f)
                .put(Style.RADIUS, RADIUS_HOURS)
                .put(Style.TAIL_LENGTH, 20);
        hours.setStyles(hourStyles);
        this.addLayer(hours);

        NeedleLine minutes = new NeedleLine(model.getMinuteModel());
        Styler minuteStyles = new Styler(baseStyles)
                .put(Style.COLOR, Color.BLACK)
                .put(Style.WIDTH, 5f)
                .put(Style.RADIUS, RADIUS_MINUTES)
                .put(Style.TAIL_LENGTH, 20);
        minutes.setStyles(minuteStyles);
        this.addLayer(minutes);

        FaceCircle firstCap = new FaceCircle();
        Styler firstCapStyles = new Styler(baseStyles)
                  .put(Style.BORDER_COLOR, Color.BLACK)
                  .put(Style.RADIUS, 5)
                  .put(Style.COLOR, Color.BLACK);
        firstCap.setStyles(firstCapStyles);
        this.addLayer(firstCap);

        Color SECONDS_COLOR = new Color(128, 128, 128);

        NeedleLine seconds = new NeedleLine(model.getSecondModel());
        Styler secondStyles = new Styler(baseStyles)
                .put(Style.COLOR, SECONDS_COLOR)
                .put(Style.WIDTH, 1.5f)
                .put(Style.RADIUS, RADIUS_SECONDS)
                .put(Style.TAIL_LENGTH, 20);
        seconds.setStyles(secondStyles);
        this.addLayer(seconds);

        FaceCircle secondCap = new FaceCircle();
        Styler secondCapStyles = new Styler(baseStyles)
                  .put(Style.BORDER_COLOR, SECONDS_COLOR)
                  .put(Style.BORDER_WIDTH, 2f)
                  .put(Style.RADIUS, 2)
                  .put(Style.COLOR, SECONDS_COLOR);
        secondCap.setStyles(secondCapStyles);
        this.addLayer(secondCap);

//        NeedleTriangle hours = new NeedleTriangle(model.getHourModel());
//        Styler hourStyles = new Styler(baseStyles)
//                  .put(Style.BORDER_COLOR, new Color(200, 200, 200))
//                  .put(Style.BORDER_WIDTH, 2f)
//                  .put(Style.RADIUS, RADIUS_HOURS)
//                  .put(Style.WIDTH, 15);
//        dayTheme  .put(hours, Style.COLOR, Color.BLACK)
//                  .put(hours, Style.BORDER_COLOR, DAY_NEEDLE_BORDER);
//        nightTheme.put(hours, Style.COLOR, Color.WHITE)
//                  .put(hours, Style.BORDER_COLOR, NIGHT_NEEDLE_BORDER);
//        hours.setStyles(hourStyles);
//        this.addLayer(hours);
//
//        NeedleTriangle minutes = new NeedleTriangle(model.getMinuteModel());
//        Styler minuteStyles = new Styler(baseStyles)
//                  .put(Style.BORDER_WIDTH, 2f)
//                  .put(Style.RADIUS, RADIUS_MINUTES)
//                  .put(Style.WIDTH, 15);
//        dayTheme  .put(minutes, Style.COLOR, Color.BLACK)
//                  .put(minutes, Style.BORDER_COLOR, DAY_NEEDLE_BORDER);
//        nightTheme.put(minutes, Style.COLOR, Color.WHITE)
//                  .put(minutes, Style.BORDER_COLOR, NIGHT_NEEDLE_BORDER);
//        minutes.setStyles(minuteStyles);
//        this.addLayer(minutes);
//
//        FaceCircle firstCap = new FaceCircle();
//        Styler firstCapStyles = new Styler(baseStyles)
//                  .put(Style.BORDER_COLOR, new Color(220, 220, 220))
//                  .put(Style.RADIUS, 10);
//        dayTheme  .put(firstCap, Style.COLOR, Color.BLACK);
//        nightTheme.put(firstCap, Style.COLOR, Color.WHITE);
//        firstCap.setStyles(firstCapStyles);
//        this.addLayer(firstCap);
//
//        NeedleLine seconds = new NeedleLine(model.getSecondModel());
//        Styler secondStyles = new Styler(baseStyles)
//                .put(Style.COLOR, Color.RED)
//                .put(Style.WIDTH, 2f)
//                .put(Style.RADIUS, RADIUS_SECONDS);
//        seconds.setStyles(secondStyles);
//        this.addLayer(seconds);
//
//        FaceCircle secondCap = new FaceCircle();
//        Styler secondCapStyles = new Styler(baseStyles)
//                .put(Style.COLOR, Color.RED)
//                .put(Style.RADIUS, 4);
//        secondCap.setStyles(secondCapStyles);
//        this.addLayer(secondCap);

    }


}
