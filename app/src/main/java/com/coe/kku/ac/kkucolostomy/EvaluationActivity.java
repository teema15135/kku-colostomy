package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EvaluationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button p1B, p2B, p3B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

        findViewById(R.id.evaluation_period1_button).setOnClickListener(this);
        findViewById(R.id.evaluation_period2_button).setOnClickListener(this);
        findViewById(R.id.evaluation_period3_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = new Intent(EvaluationActivity.this, EvaluationContentActivity.class);
        switch (id) {
            case R.id.evaluation_period1_button:
                intent.putExtra("period", EvaluationPeriod.ONE_WEEK);
                break;
            case R.id.evaluation_period2_button:
                intent.putExtra("period", EvaluationPeriod.EIGHT_WEEK);
                break;
            case R.id.evaluation_period3_button:
                intent.putExtra("period", EvaluationPeriod.MORE_THAN_EIGHT_WEEK);
                break;
            default:
        }
        startActivity(intent);
    }
}
