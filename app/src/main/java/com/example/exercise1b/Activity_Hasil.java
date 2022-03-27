package com.example.exercise1b;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class Activity_Hasil extends AppCompatActivity {
    //mendeklarasikan variabel dengan tipe data TextView
    TextView hasilinputTask,hasilinputjenis,hasilinputwaktu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil); //ini buat nyambungin

        //Menghubungkan variabel txEmail dengan componen TextView pada Layout
        hasilinputTask = findViewById(R.id.hasilTask);
        hasilinputjenis = findViewById(R.id.jenisTask);
        hasilinputwaktu = findViewById(R.id.waktuTask);

        //membuat objek bundle dan mengambil data yang dikirimkan dari activity sebelumnya
        Bundle bundle = getIntent().getExtras();

        //Membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci "a"
        String task = bundle.getString("a");
        String task2 = bundle.getString("b");
        String task3 = bundle.getString("c");

        //menampilkan value dari variabel email kedalam txEmail
        hasilinputTask.setText(task);
        hasilinputjenis.setText(task2);
        hasilinputwaktu.setText(task3);
    }
}
