package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CommunicationActivity extends AppCompatActivity {

    private ImageButton backBtn, mediaPlay;
    private MediaPlayer mPlayer;

    private View currentPlaying;

    private static final String TAG = "CommunicationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        findViewById(R.id.commu_home_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommunicationActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        backBtn = (ImageButton) findViewById(R.id.commu_content_back_btn);
        mediaPlay = (ImageButton) findViewById(R.id.commu_content_media_play);
        mPlayer = MediaPlayer.create(CommunicationActivity.this, R.raw.sound5); // sound51

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
                if (currentPlaying != findViewById(R.id.communication_fab)) {
                    playMedia(R.raw.sound5);
                    currentPlaying = findViewById(R.id.communication_fab);
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
            mPlayer = MediaPlayer.create(CommunicationActivity.this, rawResourceId);
        if (mPlayer.isPlaying())
            mPlayer.stop();
        mPlayer = MediaPlayer.create(CommunicationActivity.this, rawResourceId);
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
