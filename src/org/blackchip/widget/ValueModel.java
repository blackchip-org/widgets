/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget;

import java.util.LinkedList;
import java.util.List;
import org.blackchip.widget.util.Check;

/**
 *
 * @author mcgann
 */
public class ValueModel
{
    private double value;
    private double minValue;
    private double maxValue;
    private double minAngle;
    private double maxAngle;

    private List<ValueListener> listeners = new LinkedList<ValueListener>();

    private ValueModel()
    {
    }

    public ValueModel(double minValue, double maxValue,
                      double minAngle, double maxAngle)
    {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;

        this.value = minValue;
    }

    public double getValue()
    {
        return value;
    }

    public double getAngleDegrees()
    {
        double scale = (value - minValue) / (maxValue - minValue);
        return (maxAngle - minAngle) * scale + minAngle;
    }

    public double getAngleRadians()
    {
        return Math.toRadians(getAngleDegrees());
    }

    public void setValue(double value)
    {
        this.value = value;
        for ( ValueListener listener: listeners )
        {
            listener.valueChanged();
        }
    }

    public void addListener(ValueListener listener)
    {
        this.listeners.add(Check.notNull(listener));
    }

}
