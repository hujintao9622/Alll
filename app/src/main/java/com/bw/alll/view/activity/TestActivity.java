package com.bw.alll.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.blankj.utilcode.util.EncryptUtils;
import com.bw.alll.R;
import com.bw.alll.util.EncryptUtil;
import com.bw.alll.util.MD5ToString;
import com.bw.alll.util.RsaCoder;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        String pw="a12345";
        String s = null;
        try {
            s = RsaCoder.encryptByPublicKey(pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("pwd",s);
    }
}
