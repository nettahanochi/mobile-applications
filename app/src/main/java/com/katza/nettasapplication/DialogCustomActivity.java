package com.katza.nettasapplication;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DialogCustomActivity extends AppCompatActivity {
    SharedPreferences sp;
    Dialog d;
    Button btnCustomLogin, btnLogin;
    EditText etuserName, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dialog_custom_activity);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createLoginDialog();
            }
        });
        sp = getSharedPreferences("details", 0);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void createLoginDialog() {
        d = new Dialog(this);
        d.setContentView(R.layout.custom_layout);
        d.setTitle("Login");
        d.setCancelable(true);
        etuserName = d.findViewById(R.id.etUserName);
        etPass = d.findViewById(R.id.etPassword);
        btnCustomLogin = d.findViewById(R.id.btnDialogLogin);
        btnCustomLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        d.show();

    }
}