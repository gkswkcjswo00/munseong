package com.munseong.hs.kr.activity;

import android.app.*;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import com.munseong.hs.kr.R;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle.*;
import android.view.View.OnClickListener.*;
import android.widget.Button.*;
import android.content.*;
import android.view.View.*;

/**
 * Created by Administrator on 2016-06-24.
 */

public class school extends AppCompatActivity
{

    private MediaPlayer mp;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school);



    } public void srun(View view) {
    boolean on = ((Switch) view).isChecked();
    if (on) {
// 스위치 온

        mp = MediaPlayer.create(getApplicationContext(), R.raw.mu);
        mp.setLooping(true);
        mp.start();
    }

     else {
// 스위치 오프

mp.stop();



}



}





      }
