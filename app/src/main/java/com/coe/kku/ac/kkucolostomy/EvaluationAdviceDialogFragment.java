package com.coe.kku.ac.kkucolostomy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link EvaluationAdviceDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EvaluationAdviceDialogFragment extends DialogFragment {

    private static final String TAG = "AdviceDialogFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String STRING_ID = "string_id";
    private static final String COMPLICATION_NUMBER = "complication";

    private static final int NO_COMPLICATION = -1;

    // TODO: Rename and change types of parameters
    private int stringId;
    private int complicationNumber;
    private Intent intent;

    private TextView advertiseTextView;
    private TextView toComplicationTextView;
    private Button closeButton;

    private View currentView;

    public EvaluationAdviceDialogFragment() {
        // Required empty public constructor
    }

    public static EvaluationAdviceDialogFragment newInstance(int stringId, int complicationNumber) {
        EvaluationAdviceDialogFragment fragment = new EvaluationAdviceDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(STRING_ID, stringId);
        bundle.putInt(COMPLICATION_NUMBER, complicationNumber);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stringId = getArguments().getInt(STRING_ID);
            complicationNumber = getArguments().getInt(COMPLICATION_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().setCanceledOnTouchOutside(false);
        return inflater.inflate(R.layout.fragment_evaluation_advice, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme);
        bindView(view);
        setupView(view);
    }

    private void bindView(View view) {
        advertiseTextView = (TextView) view.findViewById(R.id.evaluation_dialog_advice_text);
        toComplicationTextView = (TextView) view.findViewById(R.id.evaluation_dialog_complication_link);
        closeButton = (Button) view.findViewById(R.id.evaluation_dialog_close_button);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    private void setupView(View view) {
        advertiseTextView.setText(stringId);

        switch (complicationNumber) {
            case 1:
                toComplicationTextView.setText(Html.fromHtml(String.format(
                        getString(R.string.click_here_complication_1))));
                intent = new Intent(getActivity(), ComplicationContentActivity.class);
                break;
            case 2:
                toComplicationTextView.setText(Html.fromHtml(String.format(
                        getString(R.string.click_here_complication_2))));
                intent = new Intent(getActivity(), ComplicationContentActivity.class);
                break;
            case 3:
                toComplicationTextView.setText(Html.fromHtml(String.format(
                        getString(R.string.click_here_complication_3))));
                intent = new Intent(getActivity(), ComplicationContentActivity.class);
                break;
            case 4:
                toComplicationTextView.setText(Html.fromHtml(String.format(
                        getString(R.string.click_here_complication_4))));
                intent = new Intent(getActivity(), ComplicationContentActivity.class);
                break;
            case  6:
                toComplicationTextView.setText(Html.fromHtml(String.format(
                        getString(R.string.click_here_complication_6))));
                intent = new Intent(getActivity(), ComplicationContentActivity.class);
                break;
            case 7:
                toComplicationTextView.setText(Html.fromHtml(String.format(
                        getString(R.string.click_here_complication_7))));
                intent = new Intent(getActivity(), ComplicationContentSevenActivity.class);
                break;
            default:
                toComplicationTextView.setText("");
        }

        toComplicationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToComplicationActivity();
                Log.d(TAG, "onClick: Goto complication " + complicationNumber);
            }
        });

        switch (stringId) {
            case R.string.choice12:
            case R.string.choice13:
            case R.string.choice22:
            case R.string.choice32:
            case R.string.choice42:
            case R.string.choice43:
            case R.string.choice54:
            case R.string.choice63:
                view.findViewById(R.id.evaluation_dialog_alert_image).setVisibility(View.VISIBLE);
            default:
        }
    }

    private void goToComplicationActivity() {
        if (intent != null) {
            intent.putExtra("content", complicationNumber);
            getActivity().startActivity(intent);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STRING_ID, stringId);
        outState.putInt(COMPLICATION_NUMBER, complicationNumber);
    }
}
