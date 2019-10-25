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

        findViewById(R.id.knowing_general_knowledge_button).setOnClickListener(this);
        findViewById(R.id.knowing_complication_button).setOnClickListener(this);
        findViewById(R.id.knowing_communication_button).setOnClickListener(this);
        findViewById(R.id.knowing_routine_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent;
        switch (id) {
            default:
            case R.id.knowing_general_knowledge_button:
                intent = new Intent(KnowingColostomyActivity.this, GeneralKnowledgeActivity.class);
                break;
            case R.id.knowing_complication_button:
                intent = new Intent(KnowingColostomyActivity.this, ComplicationActivity.class);
                break;
            case R.id.knowing_communication_button:
                intent = new Intent(KnowingColostomyActivity.this, CommunicationActivity.class);
                break;
            case R.id.knowing_routine_button:
                intent = new Intent(KnowingColostomyActivity.this, RoutineActivity.class);
                break;
        }
        startActivity(intent);
    }
}
