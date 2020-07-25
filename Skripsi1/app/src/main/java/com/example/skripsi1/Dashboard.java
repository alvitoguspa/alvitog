package com.example.skripsi1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

    ImageView kipas;
    ImageView lampu;
    CardView suhu;
    CardView pompa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        kipas = findViewById(R.id.kipas);
        suhu = findViewById(R.id.suhu);
        lampu = findViewById(R.id.lampu);
        pompa = findViewById(R.id.pompa);

        kipas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(Dashboard.this, Kipas.class);
                startActivity(k);
            }
        });

        lampu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l = new Intent(Dashboard.this, Lampu.class);
                startActivity(l);
            }
        });

        suhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(Dashboard.this, Termometer.class);
                startActivity(s);
            }
        });

        pompa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(Dashboard.this, PompaActivity.class);
                startActivity(p);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
