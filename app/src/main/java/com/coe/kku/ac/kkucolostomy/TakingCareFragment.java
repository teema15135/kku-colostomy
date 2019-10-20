package com.coe.kku.ac.kkucolostomy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class TakingCareFragment extends Fragment implements View.OnClickListener {

    private Button tcOneBtn, tcTwoBtn, tcThreeBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_taking_care, container, false);

        tcOneBtn = (Button) view.findViewById(R.id.taking_care_one_btn);
        tcTwoBtn = (Button) view.findViewById(R.id.taking_care_two_btn);
        tcThreeBtn = (Button) view.findViewById(R.id.taking_care_three_btn);

        tcOneBtn.setOnClickListener(this);
        tcTwoBtn.setOnClickListener(this);
        tcThreeBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == tcOneBtn) {
            Intent intent = new Intent(getActivity(), TakingCareContentOneActivity.class);
            getActivity().startActivity(intent);
        } else if (view == tcTwoBtn) {
            Intent intent = new Intent(getActivity(), TakingCareContentTwoActivity.class);
            getActivity().startActivity(intent);
        } else if (view == tcThreeBtn) {
            Intent intent = new Intent(getActivity(), TakingCareContentThreeActivity.class);
            getActivity().startActivity(intent);
        }
    }
}