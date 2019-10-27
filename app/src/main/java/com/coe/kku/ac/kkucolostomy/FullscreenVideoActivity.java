package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class FullscreenVideoActivity extends AppCompatActivity {

    public static final int OUT_FULLSCREEN_CODE = 6594;
    private static final String TAG = "FullscreenVideoActivity";

    private VideoView videoView;
    private MediaController mediaController;
    private Uri uri;

    private int stopPosition;
    private boolean pauseCauseOfNewActivity = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_fullscreen_video);

        int continuePosition = getIntent().getIntExtra("continue", 1000);

        videoView = (VideoView) findViewById(R.id.fullscreen_video_view);
        mediaController = new MediaController(FullscreenVideoActivity.this);
        mediaController.setAnchorView(videoView);

        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.taking_care);

        findViewById(R.id.fullscreen_out_fullscreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outFullscreen();
            }
        });

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.seekTo(continuePosition - 1000);
        videoView.start();

        Log.d(TAG, "onCreate: " + continuePosition);
    }

    private void outFullscreen() {
        Intent data = new Intent();
        data.putExtra("continue", videoView.getCurrentPosition());
        setResult(OUT_FULLSCREEN_CODE, data);
        finish();
    }

    @Override
    public void onBackPressed() {
        outFullscreen();
    }

    @Override
    public void onPause() {
        super.onPause();
        stopPosition = videoView.getCurrentPosition();
        videoView.pause();
        pauseCauseOfNewActivity = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!pauseCauseOfNewActivity) videoView.seekTo(stopPosition);
        videoView.start();
    }
}
