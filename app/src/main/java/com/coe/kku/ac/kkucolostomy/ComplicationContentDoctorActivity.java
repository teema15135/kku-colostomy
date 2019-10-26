package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ComplicationContentDoctorActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton backBtn;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complication_content_doctor);

        backBtn = (ImageButton) findViewById(R.id.compli_content_doctor_back_btn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.complication_doctor_sound1).setOnClickListener(this);
        findViewById(R.id.complication_doctor_sound2).setOnClickListener(this);
        findViewById(R.id.complication_doctor_sound3).setOnClickListener(this);
        findViewById(R.id.complication_doctor_sound4).setOnClickListener(this);
        findViewById(R.id.complication_doctor_sound5).setOnClickListener(this);
    }

    private void playMedia(int rawResourceId) {
        if (mPlayer == null)
            mPlayer = MediaPlayer.create(ComplicationContentDoctorActivity.this, rawResourceId);
        if (mPlayer.isPlaying())
            mPlayer.stop();
        mPlayer = MediaPlayer.create(ComplicationContentDoctorActivity.this, rawResourceId);
        mPlayer.start();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            default:
            case R.id.complication_doctor_sound1:
                playMedia(R.raw.sound421);
                break;
            case R.id.complication_doctor_sound2:
                playMedia(R.raw.sound422);
                break;
            case R.id.complication_doctor_sound3:
                playMedia(R.raw.sound423);
                break;
            case R.id.complication_doctor_sound4:
                playMedia(R.raw.sound424);
                break;
            case R.id.complication_doctor_sound5:
                playMedia(R.raw.sound425);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null && mPlayer.isPlaying()) mPlayer.stop();
    }
}
