package com.coe.kku.ac.kkucolostomy;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ComplicationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn ;
    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complication);

        backBtn = (ImageButton) findViewById(R.id.compli_back_btn);

        oneBtn = (Button) findViewById(R.id.compli_menu_one_btn);
        twoBtn = (Button) findViewById(R.id.compli_menu_two_btn);
        threeBtn = (Button) findViewById(R.id.compli_menu_three_btn);
        fourBtn = (Button) findViewById(R.id.compli_menu_four_btn);
        fiveBtn = (Button) findViewById(R.id.compli_menu_five_btn);
        sixBtn = (Button) findViewById(R.id.compli_menu_six_btn);
        sevenBtn = (Button) findViewById(R.id.compli_menu_seven_btn);
        eightBtn = (Button) findViewById(R.id.compli_menu_eight_btn);

        backBtn.setOnClickListener(this);
        oneBtn.setOnClickListener(this);
        twoBtn.setOnClickListener(this);
        threeBtn.setOnClickListener(this);
        fourBtn.setOnClickListener(this);
        fiveBtn.setOnClickListener(this);
        sixBtn.setOnClickListener(this);
        sevenBtn.setOnClickListener(this);
        eightBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == backBtn) {
            finish();
        }
        else if (view == oneBtn) {
            Intent i = new Intent(ComplicationActivity.this, ComplicationContentActivity.class);
            i.putExtra("content", 1);
            startActivity(i);
        }
        else if (view == twoBtn) {
            Intent i = new Intent(ComplicationActivity.this, ComplicationContentActivity.class);
            i.putExtra("content", 2);
            startActivity(i);
        }
        else if (view == threeBtn) {
            Intent i = new Intent(ComplicationActivity.this, ComplicationContentActivity.class);
            i.putExtra("content", 3);
            startActivity(i);
        }
        else if (view == fourBtn) {
            Intent i = new Intent(ComplicationActivity.this, ComplicationContentActivity.class);
            i.putExtra("content", 4);
            startActivity(i);
        }
        else if (view == fiveBtn) {
            Intent i = new Intent(ComplicationActivity.this, ComplicationContentActivity.class);
            i.putExtra("content", 5);
            startActivity(i);
        }
        else if (view == sixBtn) {
            Intent i = new Intent(ComplicationActivity.this, ComplicationContentActivity.class);
            i.putExtra("content", 6);
            startActivity(i);
        }
        else if (view == sevenBtn) {
            Intent i = new Intent(ComplicationActivity.this, ComplicationContentActivity.class);
            i.putExtra("content", 7);
            startActivity(i);
        }
        else if (view == eightBtn) {
            Intent i = new Intent(ComplicationActivity.this, ComplicationContentDoctorActivity.class);
            startActivity(i);
        }
    }
}




//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });