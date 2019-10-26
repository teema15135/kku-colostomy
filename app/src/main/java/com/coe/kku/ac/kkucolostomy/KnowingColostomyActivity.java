package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class KnowingColostomyActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowing_colostomy);

        findViewById(R.id.knowing_goto_general_knowledge).setOnClickListener(this);
        findViewById(R.id.knowing_goto_complication).setOnClickListener(this);
        findViewById(R.id.knowing_goto_communication).setOnClickListener(this);
        findViewById(R.id.knowing_goto_routine).setOnClickListener(this);

        findViewById(R.id.knowing_goto_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KnowingColostomyActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
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
            case R.id.knowing_goto_general_knowledge:
                intent = new Intent(KnowingColostomyActivity.this, GeneralKnowledgeActivity.class);
                break;
            case R.id.knowing_goto_complication:
                intent = new Intent(KnowingColostomyActivity.this, ComplicationActivity.class);
                break;
            case R.id.knowing_goto_communication:
                intent = new Intent(KnowingColostomyActivity.this, CommunicationActivity.class);
                break;
            case R.id.knowing_goto_routine:
                intent = new Intent(KnowingColostomyActivity.this, RoutineActivity.class);
                break;
        }
        startActivity(intent);
    }
}
