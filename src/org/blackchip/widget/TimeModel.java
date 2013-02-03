/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.blackchip.widget;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.blackchip.widget.util.Check;

/**
 *
 * @author mcgann
 */
public class TimeModel
{
    private ValueModel hourModel;
    private ValueModel minuteModel;
    private ValueModel secondModel;

    public TimeModel()
    {
        hourModel   = new ValueModel(0, 12, 0, 360);
        minuteModel = new ValueModel(0, 60, 0, 360);
        secondModel = new ValueModel(0, 60, 0, 360);


    }

    public void addListener(ValueListener listener)
    {
        Check.notNull(listener);
        hourModel.addListener(listener);
        minuteModel.addListener(listener);
        secondModel.addListener(listener);
    }


    public void setTime(Date date)
    {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);

        int seconds = gc.get(Calendar.SECOND);
        int minutes = gc.get(Calendar.MINUTE);
        int hours   = gc.get(Calendar.HOUR  );

        setSecond(seconds);
        setMinute(minutes);
        setHour(hours);
    }

    public void setCurrentTime()
    {
        setTime(new Date());
    }

    public void setHour(int hour)
    {
        hourModel.setValue(hour + (minuteModel.getValue() / 60f));
    }

    public void setMinute(int minute)
    {
        minuteModel.setValue(minute);
        setHour((int)hourModel.getValue());
    }

    public void setSecond(int second)
    {
        secondModel.setValue(second);
    }

    public ValueModel getHourModel()
    {
        return hourModel;
    }

    public ValueModel getMinuteModel()
    {
        return minuteModel;
    }

    public ValueModel getSecondModel()
    {
        return secondModel;
    }

}
