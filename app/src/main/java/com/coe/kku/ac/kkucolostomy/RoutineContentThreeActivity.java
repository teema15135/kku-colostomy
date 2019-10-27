package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RoutineContentThreeActivity extends AppCompatActivity {

    private LinearLayout playMedia;
    private MediaPlayer mPlayer;

    private ImageButton backButton;

    private View currentPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_content_three);

//        playMedia = (LinearLayout) findViewById(R.id.routine_content_three_media_play);
//        playMedia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                playMedia(R.raw.sound33);
//            }
//        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPlaying != findViewById(R.id.fab)) {
                    playMedia(R.raw.sound33);
                    currentPlaying = findViewById(R.id.fab);
                    ((FloatingActionButton) currentPlaying).setImageResource(R.drawable.pause);
                } else {
                    mPlayer.stop();
                    ((FloatingActionButton) currentPlaying).setImageResource(R.drawable.speaker_transparent);
                    currentPlaying = null;
                }
            }
        });

        backButton = (ImageButton) findViewById(R.id.routine_content_three_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void playMedia(int rawResourceId) {
        if (mPlayer == null)
            mPlayer = MediaPlayer.create(RoutineContentThreeActivity.this, rawResourceId);
        if (mPlayer.isPlaying())
            mPlayer.stop();
        mPlayer = MediaPlayer.create(RoutineContentThreeActivity.this, rawResourceId);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
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
