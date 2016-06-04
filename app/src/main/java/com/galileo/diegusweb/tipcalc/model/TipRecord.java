package com.galileo.diegusweb.tipcalc.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HP on 04/06/2016.
 */
public class TipRecord {
    private double tip;
    private double bill;
    private int tipPercentage;
    private Date timestamp;

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }


    public double getTip() {

        return getBill()*(getTipPercentage()/100d);
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
