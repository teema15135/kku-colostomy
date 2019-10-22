package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TakingCareContentTwoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String tag = "TakingCareDialogFragment";

    private ImageButton backBtn, sound1, sound2, sound3, sound41, sound42, sound43;
    private ImageButton showVideo;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taking_care_content_two);

        backBtn = (ImageButton) findViewById(R.id.tc_two_back_btn);
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
                TakingCareDialogFragment fragment = TakingCareDialogFragment.newInstance();
                fragment.show(getSupportFragmentManager(), tag);
            }
        });

        showVideo = (ImageButton) findViewById(R.id.taking_care_two_show_video);
        showVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TakingCareDialogFragment fragment = TakingCareDialogFragment.newInstance();
                fragment.show(getSupportFragmentManager(), tag);
            }
        });

        sound1 = (ImageButton) findViewById(R.id.taking_care_two_1_speaker);
        sound2 = (ImageButton) findViewById(R.id.taking_care_two_2_speaker);
        sound3 = (ImageButton) findViewById(R.id.taking_care_two_3_speaker);
        sound41 = (ImageButton) findViewById(R.id.taking_care_two_41_speaker);
        sound42 = (ImageButton) findViewById(R.id.taking_care_two_42_speaker);
        sound43 = (ImageButton) findViewById(R.id.taking_care_two_43_speaker);

        sound1.setOnClickListener(this);
        sound2.setOnClickListener(this);
        sound3.setOnClickListener(this);
        sound41.setOnClickListener(this);
        sound42.setOnClickListener(this);
        sound43.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == sound1) {
            playSound(R.raw.sound22_14);
        } else if (view == sound2) {
            playSound(R.raw.sound22_24);
        } else if (view == sound3) {
            playSound(R.raw.sound22_34);
        } else if (view == sound41) {
            playSound(R.raw.sound22_41);
        } else if (view == sound42) {
            playSound(R.raw.sound22_42);
        } else if (view == sound43) {
            playSound(R.raw.sound22_43);
        }
    }

    private void playSound(int rawResourceId) {
        if (mPlayer == null)
            mPlayer = MediaPlayer.create(TakingCareContentTwoActivity.this, rawResourceId);
        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        }
        mPlayer = MediaPlayer.create(TakingCareContentTwoActivity.this, rawResourceId);
        mPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null && mPlayer.isPlaying()) mPlayer.stop();
    }
}
