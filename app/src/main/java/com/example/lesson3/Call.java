package com.example.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class Call extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        ImageButton call = findViewById(R.id.call2);
        EditText editText = findViewById(R.id.num);
        call.setOnClickListener(v -> {
            if (editText.length() <= 0) {
                Intent calll = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + editText.getText().toString()));
                startActivity(calll);
            }
        });

    }
}