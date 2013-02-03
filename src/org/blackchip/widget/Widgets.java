/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget;

/**
 *
 * @author mcgann
 */
public class Widgets
{
    public static int getAnchorX(Area a, Styler s)
    {
        Anchor anchor = s.getAnchor(Style.ANCHOR, Anchor.CENTER);
        int offsetX   = s.getInt   (Style.ANCHOR_OFFSET_X, 0);

        int base = 0;
        switch ( anchor )
        {
            case TOP:
            case BOTTOM:
            case CENTER:
                base = a.getCenterX();
                break;
            case LEFT:
                base = 0;
                break;
            case RIGHT:
                base = a.getWidth();
                break;
            default:
                throw new IllegalArgumentException("Invalid anchor: " + anchor);
        }
        return base + offsetX;
    }

    public static int getAnchorY(Area a, Styler s)
    {
        Anchor anchor = s.getAnchor(Style.ANCHOR, Anchor.CENTER);
        int offsetY   = s.getInt   (Style.ANCHOR_OFFSET_Y, 0);

        int base = 0;
        switch ( anchor )
        {
            case LEFT:
            case RIGHT:
            case CENTER:
                base = a.getCenterY();
                break;
            case TOP:
                base = 0;
                break;
            case BOTTOM:
                base = a.getHeight();
                break;
            default:
                throw new IllegalArgumentException("Invalid anchor: " + anchor);
        }
        return base + offsetY;
    }
}
