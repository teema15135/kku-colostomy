package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GeneralKnowledgeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton whatColostomy, whyColostomy, whoColostomy, positionColostomy;
    private View currentPlaying;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_knowledge);

        whatColostomy = (ImageButton) findViewById(R.id.general_knowledge_what);
        whyColostomy = (ImageButton) findViewById(R.id.general_knowledge_why);
        whoColostomy = (ImageButton) findViewById(R.id.general_knowledge_who);
        positionColostomy = (ImageButton) findViewById(R.id.general_knowledge_position);

        whatColostomy.setOnClickListener(this);
        whyColostomy.setOnClickListener(this);
        whoColostomy.setOnClickListener(this);
        positionColostomy.setOnClickListener(this);
    }

    private void playSound(int rawResourceId) {
        if (mPlayer == null)
            mPlayer = MediaPlayer.create(GeneralKnowledgeActivity.this, rawResourceId);
        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        }
        mPlayer = MediaPlayer.create(GeneralKnowledgeActivity.this, rawResourceId);
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
    public void onClick(View v) {
        if (currentPlaying != v) {
            if (v == whatColostomy) {
                playSound(R.raw.sound_1_1_meaning);
            } else if (v == whyColostomy) {
                playSound(R.raw.sound_1_2_purpose);
            } else if (v == whoColostomy) {
                playSound(R.raw.sound_1_3_who);
            } else if (v == positionColostomy) {
                playSound(R.raw.sound_1_4_position);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null && mPlayer.isPlaying()) mPlayer.stop();
    }
}
