package com.example.exercise1b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnRegister;
    EditText eduser, edpassword;
    String nama,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btSignin);
        btnRegister = findViewById(R.id.btRegister);
        eduser = findViewById(R.id.edEmail);
        edpassword = findViewById(R.id.edPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Activity_Daftar.class);
                startActivity(i);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = eduser.getText().toString();
                password = edpassword.getText().toString();

                String name = "anggi";
                String pass = "051001";

                if (nama.isEmpty() || password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Nama dan Password wajib diisi!!!",
                            Toast.LENGTH_LONG);
                }else {
                    if (nama.equals(name) && pass.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());

                        Intent i = new Intent(getApplicationContext(), Activity_Isi_Todo.class);
                        i.putExtras(b);
                        startActivity(i);
                    }else {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });

    }
}