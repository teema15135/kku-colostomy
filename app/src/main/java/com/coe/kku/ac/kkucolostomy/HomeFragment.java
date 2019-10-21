package com.coe.kku.ac.kkucolostomy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button complicatoinBtn, communicationBtn, routineBtn;
    private ImageButton whatColostomy, whyColostomy, whoColostomy, positionColostomy;

    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        routineBtn = (Button) view.findViewById(R.id.home_routine_btn);
        communicationBtn = (Button) view.findViewById(R.id.home_commu_btn);
        complicatoinBtn = (Button) view.findViewById(R.id.home_compli_btn);

        routineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RoutineActivity.class);
                getActivity().startActivity(intent);
                if (mediaPlayer != null && mediaPlayer.isPlaying()) mediaPlayer.stop();
            }
        });
        communicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommunicationActivity.class);
                getActivity().startActivity(intent);
                if (mediaPlayer != null && mediaPlayer.isPlaying()) mediaPlayer.stop();
            }
        });
        complicatoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ComplicationActivity.class);
                getActivity().startActivity(intent);
                if (mediaPlayer != null && mediaPlayer.isPlaying()) mediaPlayer.stop();
            }
        });

        whatColostomy = (ImageButton) view.findViewById(R.id.home_what_is_colostomy_speaker);
        whyColostomy = (ImageButton) view.findViewById(R.id.home_why_colostomy_speaker);
        whoColostomy = (ImageButton) view.findViewById(R.id.home_who_need_colostomy);
        positionColostomy = (ImageButton) view.findViewById(R.id.home_position_colostomy_speaker);

        whatColostomy.setOnClickListener(this);
        whyColostomy.setOnClickListener(this);
        whoColostomy.setOnClickListener(this);
        positionColostomy.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == whatColostomy) {
            playSound(R.raw.sound_1_1_meaning);
        } else if (view == whyColostomy) {
            playSound(R.raw.sound_1_2_purpose);
        } else if (view == whoColostomy) {
            playSound(R.raw.sound_1_3_who);
        } else if (view == positionColostomy) {
            playSound(R.raw.sound_1_4_position);
        }
    }

    private void playSound(int rawResourceId) {
        if (mediaPlayer == null)
            mediaPlayer = MediaPlayer.create(getActivity(), rawResourceId);
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(getActivity(), rawResourceId);
        mediaPlayer.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) mediaPlayer.stop();
    }
}
