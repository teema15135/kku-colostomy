package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TakingCareActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taking_care);

        findViewById(R.id.taking_care_one_btn).setOnClickListener(this);
        findViewById(R.id.taking_care_two_btn).setOnClickListener(this);
        findViewById(R.id.taking_care_three_btn).setOnClickListener(this);
        findViewById(R.id.taking_care_goto_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent;
        switch (id) {
            default:
            case R.id.taking_care_one_btn:
                intent = new Intent(TakingCareActivity.this, TakingCareContentOneActivity.class);
                break;
            case R.id.taking_care_two_btn:
                intent = new Intent(TakingCareActivity.this, TakingCareContentTwoActivity.class);
                break;
            case R.id.taking_care_three_btn:
                intent = new Intent(TakingCareActivity.this, TakingCareContentThreeActivity.class);
                break;
        }
        startActivity(intent);
    }
}
