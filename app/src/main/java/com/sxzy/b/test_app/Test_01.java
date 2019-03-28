package com.sxzy.b.test_app;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

//zbc

public class Test_01 extends AppCompatActivity {
    private VideoView vd_fm01;
    private int cor_pos;
    private boolean isPaly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_01);
        vd_fm01=findViewById(R.id.ff1);
        vd_fm01.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+ R.raw.videoviewdemo));
        vd_fm01.setMediaController( new MediaController(this));

        Log.e("TAG","onCreate");

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG","onRestart");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG","onStart");
    }

    @Override
    public void onResume() {

        vd_fm01.seekTo(cor_pos);
        super.onResume();
        Log.e("TAG","onResume");

        if (!isPaly) {
            vd_fm01.start();
        }
    }

    @Override
    public void onPause() {


        super.onPause();
        cor_pos = vd_fm01.getCurrentPosition();
        isPaly = !vd_fm01.isPlaying();
        Log.e("TAG","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG","onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key_con_pos",cor_pos);
        outState.putBoolean("key_is_paly",isPaly);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cor_pos= savedInstanceState.getInt("key_con_pos");
        isPaly= savedInstanceState.getBoolean("key_is_paly");
    }
}
