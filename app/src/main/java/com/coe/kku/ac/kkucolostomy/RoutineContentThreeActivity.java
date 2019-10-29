package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        findViewById(R.id.routine_content_3_home_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoutineContentThreeActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        ((TextView) findViewById(R.id.routine_content_describe)).setText(Html.fromHtml(String.format(
                getString(R.string.eating_1))));

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
