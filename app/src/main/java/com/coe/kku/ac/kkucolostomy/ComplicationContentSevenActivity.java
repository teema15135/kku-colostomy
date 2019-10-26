package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ComplicationContentSevenActivity extends AppCompatActivity {

    private ImageButton backBtn;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complication_content_seven);

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
                playMedia(R.raw.sound417);
            }
        });
    }

    private void playMedia(int rawResourceId) {
        if (mPlayer == null)
            mPlayer = MediaPlayer.create(ComplicationContentSevenActivity.this, rawResourceId);
        if (mPlayer.isPlaying())
            mPlayer.stop();
        mPlayer = MediaPlayer.create(ComplicationContentSevenActivity.this, rawResourceId);
        mPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null && mPlayer.isPlaying()) mPlayer.stop();
    }
}
