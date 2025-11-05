package com.katza.nettasapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.RandomAccess;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View btn1;
    private View btn2;

    private ImageView star;
    private View btn3;
    private Button btn4;
    private int num;

    private EditText editTextText;
    private Switch switch2;
    private ImageView imageView3;

    SeekBar seekBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        intViews();
    }


    private void intViews() {
        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        star = findViewById(R.id.imageView2);
        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
            }
        });
        btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        imageView3 = findViewById(R.id.imageView3);
        switch2 = findViewById(R.id.switch2);
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Click Switch2", Toast.LENGTH_SHORT).show();
                    imageView3.setVisibility(View.VISIBLE);
                } else
                    imageView3.setVisibility(View.INVISIBLE);
            }




        });

        seekBar2 = findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            Toast.makeText(this, "Click BTN1", Toast.LENGTH_SHORT).show();
            star.setVisibility(View.VISIBLE);
        } else if (v == btn2) {
            Toast.makeText(this, "Click BTN2", Toast.LENGTH_SHORT).show();
            star.setVisibility(View.INVISIBLE);
        } else
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

    }
}