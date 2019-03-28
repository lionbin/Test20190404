package com.sxzy.b.test_app.Test_02;
//HAHA

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


import com.sxzy.b.test_app.R;

public class Fm_01 extends Fragment {
    private VideoView vd_fm01;
    private int cor_pos;
    private boolean isPaly;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fm01, null);
        vd_fm01 = view.findViewById(R.id.vd_fm01);

        return view;
    }

    //resource
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vd_fm01.setVideoPath(String.valueOf(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.videoviewdemo)));
        vd_fm01.setMediaController(new MediaController(getContext()));

    }

    @Override
    public void onPause() {
        super.onPause();
        cor_pos = vd_fm01.getCurrentPosition();
        isPaly = !vd_fm01.isPlaying();
        Log.d("TAG", String.valueOf(isPaly));
    }

    @Override
    public void onResume() {
        vd_fm01.seekTo(cor_pos);
        super.onResume();

        if (!isPaly) {
            vd_fm01.start();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key_con_pos",cor_pos);
        outState.putBoolean("key_is_paly",isPaly);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        cor_pos= savedInstanceState.getInt("key_con_pos");
        isPaly= savedInstanceState.getBoolean("key_is_paly");
    }

}
