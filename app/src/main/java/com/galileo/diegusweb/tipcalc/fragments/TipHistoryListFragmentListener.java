package com.galileo.diegusweb.tipcalc.fragments;

import com.galileo.diegusweb.tipcalc.model.TipRecord;

/**
 * Created by HP on 04/06/2016.
 */
public interface TipHistoryListFragmentListener {

    void addToList(TipRecord record);
    void clearList();
}
