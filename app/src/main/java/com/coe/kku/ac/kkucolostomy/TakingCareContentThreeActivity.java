package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TakingCareContentThreeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton backBtn;
    private TextView playMedia;

    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taking_care_content_three);

        mPlayer = MediaPlayer.create(TakingCareContentThreeActivity.this, R.raw.sound23);

        backBtn = (ImageButton) findViewById(R.id.tc_three_back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mPlayer.isPlaying())
                    mPlayer.start();
            }
        });

        findViewById(R.id.taking_care_three_231_speaker).setOnClickListener(this);
        findViewById(R.id.taking_care_three_232_speaker).setOnClickListener(this);

//        playMedia = (TextView) findViewById(R.id.taking_care_three_overall_sound);
//        playMedia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!mPlayer.isPlaying())
//                    mPlayer.start();
//            }
//        });
    }

    private void playSound(int rawResourceId) {
        if (mPlayer == null)
            mPlayer = MediaPlayer.create(TakingCareContentThreeActivity.this, rawResourceId);
        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        }
        mPlayer = MediaPlayer.create(TakingCareContentThreeActivity.this, rawResourceId);
        mPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null && mPlayer.isPlaying()) mPlayer.stop();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            default:
            case R.id.taking_care_three_231_speaker:
                playSound(R.raw.sound231);
                break;
            case R.id.taking_care_three_232_speaker:
                playSound(R.raw.sound232);
                break;
        }
    }
}
