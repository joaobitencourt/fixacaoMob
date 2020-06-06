package com.example.fixacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Telefone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone);
    }

    public void ligar (View view)
    {
        Uri uri = Uri.parse("tel:123456789");
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);

    }
}
