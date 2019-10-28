package com.coe.kku.ac.kkucolostomy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RoutineContentActivity extends AppCompatActivity {

    private RoutineContentTopic topic;
    private TextView topicTextView, describeTextView;
    private LinearLayout imageSection;

    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_content);

        findViewById(R.id.routine_content_home_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoutineContentActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        topic = (RoutineContentTopic) getIntent().getSerializableExtra("topic");

        initializeView();
        topicResolver();
    }

    private void initializeView() {
        topicTextView = (TextView) findViewById(R.id.routine_content_topic);
        describeTextView = (TextView) findViewById(R.id.routine_content_describe);
        imageSection = (LinearLayout) findViewById(R.id.routine_content_image_section);
        backButton = (ImageButton) findViewById(R.id.routine_content_back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void topicResolver() {
        switch (topic) {
            case BATHING:
                addTopic(R.string.bathing);
                addDescribe(R.string.bathing_describe);
                break;
            case WORK_OUT:
                addTopic(R.string.work_out);
                addDescribe(R.string.work_out_describe);
                addImage(new int[]{R.drawable.img_3_32_a, R.drawable.img_3_32_b});
                break;
            case EATING:
                addTopic(R.string.eating);
                addDescribe(R.string.eating_describe);
                break;
            case SEX:
                addTopic(R.string.sex);
                addDescribe(R.string.sex_describe);
                break;
            default:
        }
    }

    private void addTopic(int resource) {
        topicTextView.setText(resource);
    }

    private void addDescribe(int resource) {
        describeTextView.setText(resource);
    }

    private void addImage(int[] resources) {
        int numberOfImage = resources.length;
        imageSection.removeAllViewsInLayout();

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, 20);

        for (int i = 0; i < numberOfImage; i++) {
            ImageView im = new ImageView(RoutineContentActivity.this);
            im.setAdjustViewBounds(true);
            im.setScaleType(ImageView.ScaleType.FIT_CENTER);
            im.setImageResource(resources[i]);
            im.setLayoutParams(layoutParams);
            imageSection.addView(im);
        }

    }

}

enum RoutineContentTopic {
    BATHING, WORK_OUT, EATING, SEX
}