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
        Intent intent = new Intent(RoutineActivity.this, RoutineContentActivity.class);
        if (view == routineBathing) {
            intent.putExtra("topic", RoutineContentTopic.BATHING);
        } else if (view == routineWorkOut) {
            intent.putExtra("topic", RoutineContentTopic.WORK_OUT);
        } else if (view == routineEating) {
            intent.putExtra("topic", RoutineContentTopic.EATING);
        } else if (view == routineSex) {
            intent.putExtra("topic", RoutineContentTopic.SEX);
        }

        startActivity(intent);
    }
}
