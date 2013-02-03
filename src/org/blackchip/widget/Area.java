/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget;

/**
 *
 * @author mcgann
 */
public class Area
{

    private int width;
    private int height;


    private Area()
    {
    }

    public Area(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int getCenterX()
    {
        return width / 2;
    }

    public int getCenterY()
    {
        return height / 2;
    }
}
