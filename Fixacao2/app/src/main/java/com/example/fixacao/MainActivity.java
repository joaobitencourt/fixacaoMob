package com.example.fixacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    private Button Email, Telefone, End  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Email = findViewById(R.id.btnemail);
        setContentView(R.layout.activity_main);
    }

    public void enviaremail (View view){
        //Intent intent = new Intent(MainActivity.this, StringActivity.class); // intent usado para abrir outra activity
        //intent.putExtra("resultado", txtResu);
        Intent intent = new Intent(MainActivity.this, EnviarEmail.class);
        startActivity(intent);
    }

    public void fazerligacao (View view){
        Intent intent = new Intent(MainActivity.this, Telefone.class);
        startActivity(intent);
    }

    public void eomapa (View view){
        Intent intent = new Intent(MainActivity.this, Endereco.class);
        startActivity(intent);
    }

    public void foto (View view){
        Intent intent = new Intent(MainActivity.this, FotoActivity.class);
        startActivity(intent);
    }

}
