package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.HashMap;

public class EvaluationContentActivity extends AppCompatActivity implements View.OnClickListener {

    private EvaluationPeriod period;

    private ImageButton choice11, choice12, choice13;
    private ImageButton choice21, choice22;
    private ImageButton choice31, choice32;
    private ImageButton choice41, choice42, choice43;
    private ImageButton choice51, choice52, choice53, choice54;
    private ImageButton choice61, choice62, choice63;
    private ImageButton choice71, choice72, choice73, choice74, choice75, choice76, choice77;

    HashMap<ImageButton, Integer> stringIdMap;
    HashMap<ImageButton, Integer> complicationNumberMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_content);

        period = (EvaluationPeriod) getIntent().getSerializableExtra("period");

        initializeView();
        addViewListener();
        makeStringIdMap();
        makeComplicationNumberMap();
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

    private void makeStringIdMap() {
        stringIdMap = new HashMap<>();
        stringIdMap.put(choice11, R.string.choice11);
        stringIdMap.put(choice11, R.string.choice11);
        stringIdMap.put(choice12, R.string.choice12);
        stringIdMap.put(choice13, R.string.choice13);
        stringIdMap.put(choice21, R.string.choice21);
        stringIdMap.put(choice22, R.string.choice22);
        stringIdMap.put(choice31, R.string.choice31);
        stringIdMap.put(choice32, R.string.choice32);
        stringIdMap.put(choice41, R.string.choice41);
        stringIdMap.put(choice42, R.string.choice42);
        stringIdMap.put(choice43, R.string.choice43);
        stringIdMap.put(choice51, R.string.choice51);

        if (period == EvaluationPeriod.ONE_WEEK)
            stringIdMap.put(choice52, R.string.choice52a);
        else
            stringIdMap.put(choice52, R.string.choice52bc);

        stringIdMap.put(choice53, R.string.choice53);
        stringIdMap.put(choice54, R.string.choice54);
        stringIdMap.put(choice61, R.string.choice61);

        if (period != EvaluationPeriod.MORE_THAN_EIGHT_WEEK)
            stringIdMap.put(choice62, R.string.choice62ab);
        else
            stringIdMap.put(choice62, R.string.choice62c);

        stringIdMap.put(choice63, R.string.choice63);
        stringIdMap.put(choice71, R.string.choice71);
        stringIdMap.put(choice72, R.string.choice72);
        stringIdMap.put(choice73, R.string.choice73);
        stringIdMap.put(choice74, R.string.choice74);
        stringIdMap.put(choice75, R.string.choice75);
        stringIdMap.put(choice76, R.string.choice76);
        stringIdMap.put(choice77, R.string.choice77);
    }

    private void makeComplicationNumberMap() {
        complicationNumberMap = new HashMap<>();
        complicationNumberMap.put(choice11, -1);
        complicationNumberMap.put(choice12, -1);
        complicationNumberMap.put(choice13, -1);
        complicationNumberMap.put(choice21, -1);
        complicationNumberMap.put(choice22, -1);
        complicationNumberMap.put(choice31, -1);
        complicationNumberMap.put(choice32, -1);
        complicationNumberMap.put(choice41, -1);
        complicationNumberMap.put(choice42, -1);
        complicationNumberMap.put(choice43, -1);
        complicationNumberMap.put(choice51, -1);
        complicationNumberMap.put(choice52, 7);
        complicationNumberMap.put(choice53, 7);
        complicationNumberMap.put(choice54, 7);
        complicationNumberMap.put(choice61, -1);
        complicationNumberMap.put(choice62, -1);
        complicationNumberMap.put(choice63, -1);
        complicationNumberMap.put(choice71, -1);
        complicationNumberMap.put(choice72, 1);
        complicationNumberMap.put(choice73, 2);
        complicationNumberMap.put(choice74, 3);
        complicationNumberMap.put(choice75, 4);
        complicationNumberMap.put(choice76, -1);
        complicationNumberMap.put(choice77, -1);
    }

    @Override
    public void onClick(View view) {
        String tag = "EvaluationAdviceDialogFragment";
        int stringId = stringIdMap.get((ImageButton) view);
        int complicationNumber = complicationNumberMap.get((ImageButton) view);

        EvaluationAdviceDialogFragment fragment = EvaluationAdviceDialogFragment.newInstance(stringId, complicationNumber);
        fragment.show(getSupportFragmentManager(), tag);

        if (view == choice11 || view == choice12 || view == choice13) {
            choice11.setImageResource(R.drawable.check_circle_unchecked);
            choice12.setImageResource(R.drawable.check_circle_unchecked);
            choice13.setImageResource(R.drawable.check_circle_unchecked);
        } else if (view == choice21 || view == choice22) {
            choice21.setImageResource(R.drawable.check_circle_unchecked);
            choice22.setImageResource(R.drawable.check_circle_unchecked);
        } else if (view == choice31 || view == choice32) {
            choice31.setImageResource(R.drawable.check_circle_unchecked);
            choice32.setImageResource(R.drawable.check_circle_unchecked);
        } else if (view == choice41 || view == choice42 || view == choice43) {
            choice41.setImageResource(R.drawable.check_circle_unchecked);
            choice42.setImageResource(R.drawable.check_circle_unchecked);
            choice43.setImageResource(R.drawable.check_circle_unchecked);
        } else if (view == choice51 || view == choice52 || view == choice53 || view == choice54) {
            choice51.setImageResource(R.drawable.check_circle_unchecked);
            choice52.setImageResource(R.drawable.check_circle_unchecked);
            choice53.setImageResource(R.drawable.check_circle_unchecked);
            choice54.setImageResource(R.drawable.check_circle_unchecked);
        } else if (view == choice61 || view == choice62 || view == choice63) {
            choice61.setImageResource(R.drawable.check_circle_unchecked);
            choice62.setImageResource(R.drawable.check_circle_unchecked);
            choice63.setImageResource(R.drawable.check_circle_unchecked);
        } else if (view == choice71 || view == choice72 || view == choice73 || view == choice74
                || view == choice75 || view == choice76 || view == choice77) {
            choice71.setImageResource(R.drawable.check_circle_unchecked);
            choice72.setImageResource(R.drawable.check_circle_unchecked);
            choice73.setImageResource(R.drawable.check_circle_unchecked);
            choice74.setImageResource(R.drawable.check_circle_unchecked);
            choice75.setImageResource(R.drawable.check_circle_unchecked);
            choice76.setImageResource(R.drawable.check_circle_unchecked);
            choice77.setImageResource(R.drawable.check_circle_unchecked);
        }

        ((ImageButton) view).setImageResource(R.drawable.check_circle_checked);
    }
}

enum EvaluationPeriod {
    ONE_WEEK, EIGHT_WEEK, MORE_THAN_EIGHT_WEEK
}