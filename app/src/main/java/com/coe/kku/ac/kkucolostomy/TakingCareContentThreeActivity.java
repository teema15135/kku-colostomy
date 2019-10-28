package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    private View currentPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taking_care_content_three);

        findViewById(R.id.tc_content_3_home_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TakingCareContentThreeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mPlayer = MediaPlayer.create(TakingCareContentThreeActivity.this, R.raw.sound23);

        backBtn = (ImageButton) findViewById(R.id.tc_three_back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                ((ImageButton) currentPlaying).setImageResource(R.drawable.speaker_red);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (currentPlaying != v) {
            switch (id) {
                default:
                case R.id.taking_care_three_231_speaker:
                    playSound(R.raw.sound231);
                    break;
                case R.id.taking_care_three_232_speaker:
                    playSound(R.raw.sound232);
                    break;
            }
            if (currentPlaying != null)
                ((ImageButton) currentPlaying).setImageResource(R.drawable.speaker_red);
            currentPlaying = v;
            ((ImageButton) currentPlaying).setImageResource(R.drawable.pause);
        } else {
            mPlayer.stop();
            ((ImageButton) currentPlaying).setImageResource(R.drawable.speaker_red);
            currentPlaying = null;
        }
    }
}
