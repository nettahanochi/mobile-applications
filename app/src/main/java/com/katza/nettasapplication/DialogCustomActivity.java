package com.katza.nettasapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DialogCustomActivity extends AppCompatActivity {
    SharedPreferences sp;
    Dialog d;
    Button btnCustomLogin, btnLogin, btnAlert;
    EditText etuserName, etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dialog_custom_activity);

        setContentView(R.layout.activity_main);
        btnAlert = (Button) findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogCustomActivity.this);
                builder.setTitle("Select name");
                builder.setMessage("this is a massage");
                builder.setCancelable(true);
                builder.setPositiveButton("I agree for the rules", new HandleAlertDialogListener());
                builder.setNegativeButton("No, I dont agree", new HandleAlertDialogListener());
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

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


    public class HandleAlertDialogListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(DialogCustomActivity.this, "U SELECTED" + which, Toast.LENGTH_SHORT).show();
        }
    }
}