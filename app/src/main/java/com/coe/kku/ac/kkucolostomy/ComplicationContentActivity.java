package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ComplicationContentActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title, subtitle, care, careTitle;
    private ImageView img;
    private ImageButton backBtn;
    private int content;
    private int soundId;

    private View currentPlaying;

    private MediaPlayer mPlayer;

    private static final String TAG = "ComplicationContent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complication_content);

        findViewById(R.id.compli_content_home_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComplicationContentActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        backBtn = (ImageButton) findViewById(R.id.compli_content_back_btn);

        title = (TextView) findViewById(R.id.compli_content_title);
        subtitle = (TextView) findViewById(R.id.compli_content_subtitle);
        care = (TextView) findViewById(R.id.compli_content_care);
        careTitle = (TextView) findViewById(R.id.compli_content_title_care);
        img = (ImageView) findViewById(R.id.compli_content_img);

        backBtn.setOnClickListener(this);

        findViewById(R.id.complication_fab).setOnClickListener(this);

        //filter intent
        Intent intent = getIntent();
        content = (int) intent.getIntExtra("content", 0);
        if (content == 1) {
            img.setImageResource(R.drawable.img_4_1_1);
            title.setText(getString(R.string.compli_content_one_title));
            subtitle.setText(getString(R.string.compli_content_one_subtitle));
            care.setText(getString(R.string.compli_content_one_care));
            soundId = R.raw.sound411;
        }
        else if (content == 2) {
            img.getLayoutParams().height = 0;
            img.getLayoutParams().width = 0;
            img.requestLayout();
            title.setText(getString(R.string.compli_content_two_title));
            care.setText(getString(R.string.compli_content_two_care));
            soundId = R.raw.sound412;
        }
        else if (content == 3) {
            img.getLayoutParams().height = 0;
            img.getLayoutParams().width = 0;
            img.requestLayout();
            title.setText(getString(R.string.compli_content_three_title));
            care.setText(getString(R.string.compli_content_three_care));
            soundId = R.raw.sound413;
        }
        else if (content == 4) {
            img.setImageResource(R.drawable.img_4_1_4);
            title.setText(getString(R.string.compli_content_four_title));
            subtitle.setText(getString(R.string.compli_content_four_subtitle));
            care.setText(getString(R.string.compli_content_four_care));
            soundId = R.raw.sound414;
        }
        else if (content == 5) {
            img.getLayoutParams().height = 0;
            img.getLayoutParams().width = 0;
            img.requestLayout();
            title.setText(getString(R.string.compli_content_five_title));
            subtitle.setText(getString(R.string.compli_content_five_subtitle));
            care.setText(getString(R.string.compli_content_five_care));
            soundId = R.raw.sound415;
        }
        else if (content == 6) {
            img.setImageResource(R.drawable.img_4_1_6);
            title.setText(getString(R.string.compli_content_six_title));
            subtitle.setText(getString(R.string.compli_content_six_subtitle));
            care.setText(getString(R.string.compli_content_six_care));
            soundId = R.raw.sound416;
        }
        else if (content == 8) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer != null && mPlayer.isPlaying()) mPlayer.stop();
    }

    @Override
    public void onClick(View view) {
        if (view == backBtn) {
            finish();
        } else if (view.getId() == R.id.complication_fab) {
            if (currentPlaying != findViewById(R.id.complication_fab)) {
                playSound();
                currentPlaying = findViewById(R.id.complication_fab);
                ((FloatingActionButton) currentPlaying).setImageResource(R.drawable.pause);
            } else {
                mPlayer.stop();
                ((FloatingActionButton) currentPlaying).setImageResource(R.drawable.speaker_transparent);
                currentPlaying = null;
            }
        }
    }

    private void playSound() {
        if (mPlayer == null)
            mPlayer = MediaPlayer.create(ComplicationContentActivity.this, soundId);
        if (mPlayer.isPlaying())
            mPlayer.stop();
        mPlayer = MediaPlayer.create(ComplicationContentActivity.this, soundId);
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
}
