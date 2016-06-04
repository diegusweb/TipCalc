package com.galileo.diegusweb.tipcalc.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HP on 04/06/2016.
 */
public class TipRecord {
    private double Tip;
    private int tipPercentage;
    private Date timestamp

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getTipPercentage() {
        return tipPercentage;
    }

    public void setTipPercentage(int tipPercentage) {
        this.tipPercentage = tipPercentage;
    }

    public String getDateFormatted(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        return simpleDateFormat.format(timestamp);
    }

}
