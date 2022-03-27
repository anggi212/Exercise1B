package com.example.exercise1b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Daftar extends AppCompatActivity {

    //Deklrasi variabel dengan tipe data EditText
    EditText edtNama, edtEmail, edtPassword, edtepass;

    //Deklarasi variabel dengan tipe data Floating action button
    Button save;

    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        edtNama = findViewById(R.id.textInputNama);
        edtEmail = findViewById(R.id.textInputEmail);
        edtPassword = findViewById(R.id.textInputPassword);
        edtepass = findViewById(R.id.textInputRePassword);
        save = findViewById(R.id.buttonSave);

        //membuat method untuk event dari floating button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edtNama.getText().toString();
                if (edtNama.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtepass.getText().toString().isEmpty())
                {
                    edtNama.setError("Nama Harus diisi");
                    edtEmail.setError("Email Harus diisi");
                    edtPassword.setError("Password Harus diisi");
                    edtepass.setError("Re Password Harus diisi");



                    //menampilkan pesan notifikawsi jika seluruh Edittext wajib diisi
                    Toast.makeText(Activity_Daftar.this, "Password Incorrect", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //Membuat kondisi untuk mengecek apakah isi dari EditText password dan EditText repassword sama atau tidak
                    if (edtPassword.getText().toString().equals(edtepass.getText().toString()))
                    {
                        //inisiasi
                        Bundle bn = new Bundle();

                        //memasukkan value dari variabel nama dengan kunci "a" dan dimasukkan kedalam bundle
                        bn.putString("b", nama.trim());

                        //Menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(), "Register Sukses",
                                Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), Activity_Isi_Todo.class);

                        i.putExtras(bn);

                        startActivity(i);
                    }
                    else
                    {
                        //Menampilkan pesan bahwa isi dari EditText password dan EditText repassword tidak sama
                        Toast.makeText(Activity_Daftar.this, "Password Incorrect", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}