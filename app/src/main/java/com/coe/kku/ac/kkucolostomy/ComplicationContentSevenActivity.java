package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ComplicationContentSevenActivity extends AppCompatActivity {

    private ImageButton backBtn;
    private MediaPlayer mPlayer;

    private static final String TAG = "ComplicationSeven";

    private View currentPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complication_content_seven);

        findViewById(R.id.compli_content_seven_home_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComplicationContentSevenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        backBtn = (ImageButton) findViewById(R.id.compli_content_seven_back_btn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.complication_fab_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPlaying != findViewById(R.id.complication_fab_7)) {
                    playMedia(R.raw.sound417);
                    currentPlaying = findViewById(R.id.complication_fab_7);
                    ((FloatingActionButton) currentPlaying).setImageResource(R.drawable.pause);
                } else {
                    mPlayer.stop();
                    ((FloatingActionButton) currentPlaying).setImageResource(R.drawable.speaker_transparent);
                    currentPlaying = null;
                }
            }
        });
    }

    private void playMedia(int rawResourceId) {
        if (mPlayer == null)
            mPlayer = MediaPlayer.create(ComplicationContentSevenActivity.this, rawResourceId);
        if (mPlayer.isPlaying())
            mPlayer.stop();
        mPlayer = MediaPlayer.create(ComplicationContentSevenActivity.this, rawResourceId);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d(TAG, "onCompletion: ");
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
