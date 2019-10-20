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

public class EvaluationFragment extends Fragment implements View.OnClickListener {

    private Button p1B, p2B, p3B;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evaluation, container, false);

        p1B = (Button) view.findViewById(R.id.evaluation_period1_button);
        p2B = (Button) view.findViewById(R.id.evaluation_period2_button);
        p3B = (Button) view.findViewById(R.id.evaluation_period3_button);

        p1B.setOnClickListener(this);
        p2B.setOnClickListener(this);
        p3B.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), EvaluationContentActivity.class);
        if (view == p1B) {
            intent.putExtra("period", EvaluationPeriod.ONE_WEEK);
        } else if (view == p2B) {
            intent.putExtra("period", EvaluationPeriod.EIGHT_WEEK);
        } else if (view == p3B) {
            intent.putExtra("period", EvaluationPeriod.MORE_THAN_EIGHT_WEEK);
        }
        getActivity().startActivity(intent);
    }
}
