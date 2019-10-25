package com.coe.kku.ac.kkucolostomy;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.main_1_know_colostomy).setOnClickListener(this);
        findViewById(R.id.main_2_taking_care).setOnClickListener(this);
        findViewById(R.id.main_3_evaluation).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent;
        switch (id) {
            default:
            case R.id.main_1_know_colostomy:
                intent = new Intent(MainActivity.this, KnowingColostomyActivity.class);
                break;
            case R.id.main_2_taking_care:
                intent = new Intent(MainActivity.this, TakingCareActivity.class);
                break;
            case R.id.main_3_evaluation:
                intent = new Intent(MainActivity.this, EvaluationActivity.class);
                break;
        }
        if (intent != null) startActivity(intent);
    }
}
