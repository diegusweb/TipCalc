package com.galileo.diegusweb.tipcalc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.galileo.diegusweb.tipcalc.fragments.TipHistoryListFragment;
import com.galileo.diegusweb.tipcalc.model.TipRecord;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    /*@BindView(R.id.btnDecrease) EditText btnDecrease;
    @BindView(R.id.inputPercentage) EditText inputPercentage;
    @BindView(R.id.inputBill) EditText inputBill;
    @BindView(R.id.txtRip) TextView txtRip;*/
    @BindView(R.id.inputPercentage)
    EditText inputPercentage;

    @BindView(R.id.txtRip)
    TextView txtRip;

    @BindView(R.id.inputBill)
    EditText inputBill;

    private final static int TIP_STEP_CHANGE = 1;

    private final static int DEFAULT_TIP_PERCENTAGE =10;
    private TipHistoryListFragment fragmentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //init fragment
        TipHistoryListFragment fragment = (TipHistoryListFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragemntList);

        fragment.setRetainInstance(true);
        fragmentListener = fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_about){
            about();
        }
        return super.onOptionsItemSelected(item);
    }


    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (NullPointerException exp){
            Log.e(getLocalClassName(), Log.getStackTraceString(exp));
        }
    }

    private void about(){
        TipCalcApp app = (TipCalcApp) getApplication();
        String strUrl = app.getAboutUrl();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(strUrl));
        startActivity(intent);

    }

    @OnClick(R.id.btnSubmit) public void handleClickSubmit() {
        Toast.makeText(getApplicationContext(),"Hello Android Butter Knife", Toast.LENGTH_LONG).show();

        hideKeyboard();

        String strImputToal = inputBill.getText().toString().trim();
        if (!strImputToal.isEmpty()){
            double total = Double.parseDouble(strImputToal);
            int tipPercentage = getTipPercentage();
            //double tip = total*(tipPercentage/100d);

            TipRecord tipRecord = new TipRecord();

            tipRecord.setBill(total);
            tipRecord.setTipPercentage(tipPercentage);
            tipRecord.setTimestamp(new Date());

            String srtTop = String.format(getString(R.string.global_message_tip), tipRecord.getTip());

            fragmentListener.addToList(tipRecord);
            txtRip.setVisibility(View.VISIBLE);
            txtRip.setText(srtTop);
        }
    }

    @OnClick(R.id.btnIncrease)
    public void handleClickIncrease(){
        hideKeyboard();
        handleTipChange(TIP_STEP_CHANGE);
    }

    private void handleTipChange(int i) {
        int tipPercentage = getTipPercentage();
        tipPercentage += i;
        if (tipPercentage > 0){
            inputPercentage.setText(String.valueOf(tipPercentage));
        }
    }

    @OnClick(R.id.btnDecrease)
    public void handleClickDecrease(){
        hideKeyboard();
        handleTipChange(-TIP_STEP_CHANGE);
    }

    @OnClick(R.id.btnClear)
    public void handleClickClear(){
        fragmentListener.clearList();
    }

    private int getTipPercentage() {
        int tipPercentage = DEFAULT_TIP_PERCENTAGE;
        String strInputPercentage = inputPercentage.getText().toString().trim();
        if (!strInputPercentage.isEmpty()){
            tipPercentage = Integer.parseInt(strInputPercentage);
        }else{
            inputPercentage.setText(String.valueOf(tipPercentage));
        }
        return tipPercentage;
    }
}
