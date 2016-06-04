package com.galileo.diegusweb.tipcalc;

import android.app.Application;

/**
 * Created by HP on 02/06/2016.
 */
public class TipCalcApp extends Application {
    private final static  String ABOUT_URL = "https://about.me/diegorueda";

    public static String getAboutUrl(){
        return ABOUT_URL;
    }
}
