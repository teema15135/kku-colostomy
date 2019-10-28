package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class RoutineActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout routineBathing, routineWorkOut, routineEating, routineSex;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        findViewById(R.id.routine_home_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoutineActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        routineBathing = (LinearLayout) findViewById(R.id.routine_bathing);
        routineWorkOut = (LinearLayout) findViewById(R.id.routine_work_out);
        routineEating = (LinearLayout) findViewById(R.id.routine_eating);
        routineSex = (LinearLayout) findViewById(R.id.routine_sex);
        backButton = (ImageButton) findViewById(R.id.routine_back_button);

        routineBathing.setOnClickListener(this);
        routineWorkOut.setOnClickListener(this);
        routineEating.setOnClickListener(this);
        routineSex.setOnClickListener(this);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(RoutineActivity.this, RoutineContentOneActivity.class);
        if (view == routineBathing) {
            intent = new Intent(RoutineActivity.this, RoutineContentOneActivity.class);
        } else if (view == routineWorkOut) {
            intent = new Intent(RoutineActivity.this, RoutineContentTwoActivity.class);
        } else if (view == routineEating) {
            intent = new Intent(RoutineActivity.this, RoutineContentThreeActivity.class);
        } else if (view == routineSex) {
            intent = new Intent(RoutineActivity.this, RoutineContentFourActivity.class);
        }
        startActivity(intent);
    }
}
