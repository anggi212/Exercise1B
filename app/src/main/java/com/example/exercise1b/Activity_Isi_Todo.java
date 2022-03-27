package com.example.exercise1b;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import javax.xml.transform.Result;

public class Activity_Isi_Todo extends AppCompatActivity {

    //mendeklarasikan variabel dengan tipe data TextView
    TextView txEmail, enama;

    //deklrasi variabel untuk EditText
    EditText edtask1, edjenisTask1, edtimetask1;

    //deklarasi variabel untuk menyimpan task jtask ttask
    String task, jtask, ttask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_todo);

        //menghubungkan variabel edemail dengan componen button pada layout
        edtask1=findViewById (R.id.edtask);
        //menghubungkan variabel edpassword dengan componen button pada Layout
        edjenisTask1= findViewById(R.id.edjenisTask);
        edtimetask1= findViewById(R.id.edtimetask);

        txEmail = findViewById(R.id.nama);

        //membuat objek bundle dan mengambil data yang dikirimkan dari activity sebelumnya
        Bundle bundle = getIntent().getExtras();

        //Membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci "a"
        task= bundle.getString("a");
        txEmail.setText(task);


        FloatingActionButton fab = findViewById(R.id.simpan);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = edtask1.getText().toString();
                jtask = edjenisTask1.getText().toString();
                ttask = edtimetask1.getText().toString();

                edtask1.setError("Nama Diperlukan");

                //inisiasi
                Bundle bn = new Bundle();

                //memasukkan value dari variabel nama dengan kunci "a" dan dimasukkan kedalam bundle
                bn.putString("b", task.trim());

                //memasukkan value dari variabel password dengan kunci "b" dan dimasukkan kedalam bundle
                bn.putString("c", jtask.trim());

                //memasukkan value dari variabel password dengan kunci "b" dan dimasukkan kedalam bundle
                bn.putString("d", ttask.trim());

                //membuat objek intent berpindah activity dari mainactivity ke ActivityKedua
                Intent i = new Intent(getApplicationContext(), Result.class);

                //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityKedua
                i.putExtras(bn);

                //berpindah ke ActivityKedua
                startActivity(i);
            }
        });
    }
}
