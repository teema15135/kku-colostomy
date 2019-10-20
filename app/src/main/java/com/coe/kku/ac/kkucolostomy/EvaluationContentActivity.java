package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EvaluationContentActivity extends AppCompatActivity implements View.OnClickListener {

    private EvaluationPeriod period;

    private ImageButton choice11, choice12, choice13;
    private ImageButton choice21, choice22;
    private ImageButton choice31, choice32;
    private ImageButton choice41, choice42, choice43;
    private ImageButton choice51, choice52, choice53, choice54;
    private ImageButton choice61, choice62, choice63;
    private ImageButton choice71, choice72, choice73, choice74, choice75, choice76, choice77;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_content);

        period = (EvaluationPeriod) getIntent().getSerializableExtra("period");

        initializeView();
        addViewListener();
    }

    private void initializeView() {
        choice11 = (ImageButton) findViewById(R.id.choice_11);
        choice12 = (ImageButton) findViewById(R.id.choice_12);
        choice13 = (ImageButton) findViewById(R.id.choice_13);
        choice21 = (ImageButton) findViewById(R.id.choice_21);
        choice22 = (ImageButton) findViewById(R.id.choice_22);
        choice31 = (ImageButton) findViewById(R.id.choice_31);
        choice32 = (ImageButton) findViewById(R.id.choice_32);
        choice41 = (ImageButton) findViewById(R.id.choice_41);
        choice42 = (ImageButton) findViewById(R.id.choice_42);
        choice43 = (ImageButton) findViewById(R.id.choice_43);
        choice51 = (ImageButton) findViewById(R.id.choice_51);
        choice52 = (ImageButton) findViewById(R.id.choice_52);
        choice53 = (ImageButton) findViewById(R.id.choice_53);
        choice54 = (ImageButton) findViewById(R.id.choice_54);
        choice61 = (ImageButton) findViewById(R.id.choice_61);
        choice62 = (ImageButton) findViewById(R.id.choice_62);
        choice63 = (ImageButton) findViewById(R.id.choice_63);
        choice71 = (ImageButton) findViewById(R.id.choice_71);
        choice72 = (ImageButton) findViewById(R.id.choice_72);
        choice73 = (ImageButton) findViewById(R.id.choice_73);
        choice74 = (ImageButton) findViewById(R.id.choice_74);
        choice75 = (ImageButton) findViewById(R.id.choice_75);
        choice76 = (ImageButton) findViewById(R.id.choice_76);
        choice77 = (ImageButton) findViewById(R.id.choice_77);
    }

    private void addViewListener() {
        choice11.setOnClickListener(this);
        choice12.setOnClickListener(this);
        choice13.setOnClickListener(this);
        choice21.setOnClickListener(this);
        choice22.setOnClickListener(this);
        choice31.setOnClickListener(this);
        choice32.setOnClickListener(this);
        choice41.setOnClickListener(this);
        choice42.setOnClickListener(this);
        choice43.setOnClickListener(this);
        choice51.setOnClickListener(this);
        choice52.setOnClickListener(this);
        choice53.setOnClickListener(this);
        choice54.setOnClickListener(this);
        choice61.setOnClickListener(this);
        choice62.setOnClickListener(this);
        choice63.setOnClickListener(this);
        choice71.setOnClickListener(this);
        choice72.setOnClickListener(this);
        choice73.setOnClickListener(this);
        choice74.setOnClickListener(this);
        choice75.setOnClickListener(this);
        choice76.setOnClickListener(this);
        choice77.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == choice11) {

        } else if (view == choice12) {

        } else if (view == choice13) {

        } else if (view == choice21) {

        } else if (view == choice22) {

        } else if (view == choice31) {

        } else if (view == choice32) {

        } else if (view == choice41) {

        } else if (view == choice42) {

        } else if (view == choice43) {

        } else if (view == choice51) {

        } else if (view == choice52) {

        } else if (view == choice53) {

        } else if (view == choice54) {

        } else if (view == choice61) {

        } else if (view == choice62) {

        } else if (view == choice63) {

        } else if (view == choice71) {

        } else if (view == choice72) {

        } else if (view == choice73) {

        } else if (view == choice74) {

        } else if (view == choice75) {

        } else if (view == choice76) {

        } else if (view == choice77) {

        }
    }
}

enum EvaluationPeriod {
    ONE_WEEK, EIGHT_WEEK, MORE_THAN_EIGHT_WEEK
}