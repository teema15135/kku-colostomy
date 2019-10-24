package com.coe.kku.ac.kkucolostomy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link DialogFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TakingCareDialogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TakingCareDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TakingCareDialogFragment extends DialogFragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private VideoView videoView;
    private MediaController mediaController;
    private Uri uri;

    private ImageButton playPauseButton;

    private Button close;

    private int stopPosition;

    private boolean pauseCauseOfFullscreen = false;

    public static final int BACK_FORWARD_MILLI = 10000;

    public static final int FULLSCREEN_REQUEST_CODE = 5930;

    public TakingCareDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TakingCareDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TakingCareDialogFragment newInstance() {
        TakingCareDialogFragment fragment = new TakingCareDialogFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().setCanceledOnTouchOutside(false);
        return inflater.inflate(R.layout.fragment_taking_care_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme);

        stopPosition = 0;

        close = (Button) view.findViewById(R.id.taking_care_dialog_close_button);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        playPauseButton = (ImageButton) view.findViewById(R.id.taking_care_dialog_video_pause_play);

        playPauseButton.setOnClickListener(this);
        view.findViewById(R.id.taking_care_dialog_video_back).setOnClickListener(this);
        view.findViewById(R.id.taking_care_dialog_video_forward).setOnClickListener(this);
        view.findViewById(R.id.taking_care_dialog_fullscreen_button).setOnClickListener(this);

        videoView = (VideoView) view.findViewById(R.id.taking_care_dialog_video);
        mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(videoView);

        uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.taking_care);

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == FullscreenVideoActivity.OUT_FULLSCREEN_CODE) {
            videoView.seekTo(data.getIntExtra("continue", 1000) - 1000);
            videoView.start();
            pauseCauseOfFullscreen = true;
        }
    }

    private void goFullscreen() {
        videoView.pause();
        Intent intent = new Intent(getActivity(), FullscreenVideoActivity.class);
        intent.putExtra("continue", videoView.getCurrentPosition());
        startActivityForResult(intent, FULLSCREEN_REQUEST_CODE);
        pauseCauseOfFullscreen = true;
    }

    private void pausePlayVideo() {
        if (videoView.isPlaying()) {
            videoView.pause();
            playPauseButton.setImageResource(R.drawable.play);
        }
        else {
            videoView.start();
            playPauseButton.setImageResource(R.drawable.pause);
        }
    }

    private void backward() {
        int curr = videoView.getCurrentPosition();
        if (curr - BACK_FORWARD_MILLI < 0)
            videoView.seekTo(0);
        else
            videoView.seekTo(curr - BACK_FORWARD_MILLI);
    }

    private void forward() {
        int curr = videoView.getCurrentPosition();
        if (curr + BACK_FORWARD_MILLI > videoView.getDuration())
            videoView.seekTo(videoView.getDuration() - 1000);
        else
            videoView.seekTo(curr + BACK_FORWARD_MILLI);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        videoView.stopPlayback();
    }

    @Override
    public void onPause() {
        super.onPause();
        stopPosition = videoView.getCurrentPosition();
        videoView.pause();
        pauseCauseOfFullscreen = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!pauseCauseOfFullscreen) videoView.seekTo(stopPosition);
        videoView.start();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.taking_care_dialog_video_pause_play:
                pausePlayVideo();
                break;
            case R.id.taking_care_dialog_video_forward:
                forward();
                break;
            case R.id.taking_care_dialog_video_back:
                backward();
                break;
            case R.id.taking_care_dialog_fullscreen_button:
                goFullscreen();
                break;
            default:
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
