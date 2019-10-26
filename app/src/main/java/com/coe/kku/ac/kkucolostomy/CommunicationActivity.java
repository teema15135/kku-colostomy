package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;

public class CommunicationActivity extends AppCompatActivity {

    private ImageButton backBtn, mediaPlay;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        backBtn = (ImageButton) findViewById(R.id.commu_content_back_btn);
        mediaPlay = (ImageButton) findViewById(R.id.commu_content_media_play);
        mPlayer = MediaPlayer.create(CommunicationActivity.this, R.raw.sound51);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mediaPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.start();
            }
        });

        findViewById(R.id.communication_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMedia(R.raw.sound5);
            }
        });
    }

    private void playMedia(int rawResourceId) {
        if (mPlayer == null)
            mPlayer = MediaPlayer.create(CommunicationActivity.this, rawResourceId);
        if (mPlayer.isPlaying())
            mPlayer.stop();
        mPlayer = MediaPlayer.create(CommunicationActivity.this, rawResourceId);
        mPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null && mPlayer.isPlaying()) mPlayer.stop();
    }
}
