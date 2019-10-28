package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TakingCareContentOneActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton backBtn;
    private ImageButton overAllSound, sound1, sound2, sound3, sound4, sound5, sound6, sound7;

    private MediaPlayer mPlayer;

    private View currentPlaying;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taking_care_content_one);

        findViewById(R.id.tc_content_1_home_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TakingCareContentOneActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        backBtn = (ImageButton) findViewById(R.id.tc_one_back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//
//        overAllSound = (TextView) findViewById(R.id.taking_care_one_overall_sound);
        sound1 = (ImageButton) findViewById(R.id.taking_care_one_sound_1);
        sound2 = (ImageButton) findViewById(R.id.taking_care_one_sound_2);
        sound3 = (ImageButton) findViewById(R.id.taking_care_one_sound_3);
        sound4 = (ImageButton) findViewById(R.id.taking_care_one_sound_4);
        sound5 = (ImageButton) findViewById(R.id.taking_care_one_sound_5);
        sound6 = (ImageButton) findViewById(R.id.taking_care_one_sound_6);
        sound7 = (ImageButton) findViewById(R.id.taking_care_one_sound_7);

//        overAllSound.setOnClickListener(this);
        sound1.setOnClickListener(this);
        sound2.setOnClickListener(this);
        sound3.setOnClickListener(this);
        sound4.setOnClickListener(this);
        sound5.setOnClickListener(this);
        sound6.setOnClickListener(this);
        sound7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (currentPlaying != view) {
            if (view == sound1) {
                playMedia(R.raw.sound21_1);
            } else if (view == sound2) {
                playMedia(R.raw.sound21_2);
            } else if (view == sound3) {
                playMedia(R.raw.sound21_3);
            } else if (view == sound4) {
                playMedia(R.raw.sound21_4);
            } else if (view == sound5) {
                playMedia(R.raw.sound21_5);
            } else if (view == sound6) {
                playMedia(R.raw.sound21_6);
            } else if (view == sound7) {
                playMedia(R.raw.sound21_7);
            } else if (view == fab) {
                playMedia(R.raw.sound21_0);
            }
            if (currentPlaying != null) {
                ((ImageButton) currentPlaying).setImageResource(R.drawable.speaker_red);
                if (currentPlaying == fab)
                    fab.setImageResource(R.drawable.speaker_transparent);
            }
            currentPlaying = view;
            ((ImageButton) currentPlaying).setImageResource(R.drawable.pause);
        } else {
            mPlayer.stop();
            ((ImageButton) currentPlaying).setImageResource(R.drawable.speaker_red);
            if (currentPlaying == fab)
                fab.setImageResource(R.drawable.speaker_transparent);
            currentPlaying = null;
        }
    }

    private void playMedia(int rawResourceId) {
        if (mPlayer == null)
            mPlayer = MediaPlayer.create(TakingCareContentOneActivity.this, rawResourceId);
        if (mPlayer.isPlaying())
            mPlayer.stop();
        mPlayer = MediaPlayer.create(TakingCareContentOneActivity.this, rawResourceId);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                ((ImageButton) currentPlaying).setImageResource(R.drawable.speaker_red);
                if (currentPlaying == fab)
                    ((FloatingActionButton) currentPlaying).setImageResource(R.drawable.speaker_transparent);
                currentPlaying = null;
            }
        });
        mPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null && mPlayer.isPlaying()) mPlayer.stop();
    }
}
