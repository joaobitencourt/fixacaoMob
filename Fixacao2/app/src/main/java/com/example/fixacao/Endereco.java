package com.example.fixacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Endereco extends AppCompatActivity {
    private EditText local;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);
        local = findViewById(R.id.etEndereco);
    }

    public void verMapaLocal(View view)
    {
        String locale = local.getText().toString();
        // Localização georreferenciada é possível efetuar a busca ou informar as coordenadas
        // busca de localiza&ccedil;&atilde;o : (geo:0,0?q="parametros de busca")
        Uri location= Uri.parse("geo:0,0?q=" + locale);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }

}
