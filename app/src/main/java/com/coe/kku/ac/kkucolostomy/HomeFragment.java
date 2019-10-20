package com.coe.kku.ac.kkucolostomy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;


public class HomeFragment extends Fragment {

    private Button complicatoinBtn, communicationBtn, routineBtn;

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
            }
        });
        communicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommunicationActivity.class);
                getActivity().startActivity(intent);
            }
        });
        complicatoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ComplicationActivity.class);
                getActivity().startActivity(intent);
            }
        });


        return view;
    }
}
