package com.example.skripsi1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;


public class Lampu extends AppCompatActivity {

    SwitchCompat switchCompat;
    ImageView imageView;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lampu);

        database = FirebaseDatabase.getInstance();
        switchCompat = findViewById(R.id.switchButton);
        imageView = findViewById(R.id.imageView);

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.lampuoff));

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.getReference("lampu").setValue(1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (switchCompat.isChecked()){
                            Toast.makeText(Lampu.this, "Lampu Menyala", Toast.LENGTH_SHORT).show();
                            imageView.setImageDrawable(getResources().getDrawable(R.drawable.lampuon));
                        }else{
                            database.getReference("lampu").setValue(0).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(Lampu.this, "Lampu Mati", Toast.LENGTH_SHORT).show();
                                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.lampuoff));
                                }
                            });
                        }
                    }
                });
            }

        });
    }
}
