package com.galileo.diegusweb.tipcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSubmit) public void handleClickSubmit() {
        Toast.makeText(getApplicationContext(),"Hello Android Butter Knife", Toast.LENGTH_LONG).show();


    }
}
