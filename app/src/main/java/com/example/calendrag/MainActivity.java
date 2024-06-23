package com.example.calendrag;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String DEFAULT_EMAIL = "12345678@utfv.edu.mx";
    private static final String DEFAULT_PASSWORD = "1234567890";

    private EditText edtEmail;
    private EditText edtPassword;

    private String email;
    private String password;

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
    }

    public void send(View view) {
        getInformation();

        if (isValid()) {
            //Resend to the next sheet
            Toast.makeText(this, "Exito al iniciar.", Toast.LENGTH_LONG).show();
        } else {
            //Send an error message
            Toast.makeText(this, "Error al iniciar sesion intenta de nuevo.", Toast.LENGTH_LONG).show();
        }
        clean();
    }

    private void assignInformation() {
        this.email = this.edtEmail.getText().toString();
        this.password = this.edtPassword.getText().toString();
    }

    private void getInformation() {
        this.edtEmail = findViewById(R.id.editTextTextEmailAddress);
        this.edtPassword = findViewById(R.id.editTextTextPassword);
        assignInformation();
    }

    private boolean isValid() {
        return this.email.equals(DEFAULT_EMAIL) && this.password.equals(DEFAULT_PASSWORD);
    }

    private void clean() {
        resetDisplay();
        resetVariables();
    }

    private void resetDisplay() {
        this.edtEmail.setText("");
        this.edtPassword.setText("");
    }

    private void resetVariables() {
        this.edtEmail = null;
        this.edtPassword = null;

        this.email = null;
        this.password = null;
    }
}