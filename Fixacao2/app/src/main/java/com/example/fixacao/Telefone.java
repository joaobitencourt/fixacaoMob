package com.example.fixacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Telefone extends AppCompatActivity {
        private EditText tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone);
        tel= findViewById(R.id.editText);
    }

    public void ligar (View view)
    {
        String telstring = tel.getText().toString();
        Uri uri = Uri.parse("tel:"+telstring);
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);

    }
}
