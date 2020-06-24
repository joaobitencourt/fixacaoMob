package com.example.fixacao;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GaleriaActivity extends AppCompatActivity {
    private static final int PegaImagem = 1;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
    }

    public void SelectGaleria(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 123)
        {
            Uri imagemSelecionada = data.getData();
            ImageView imageView = new ImageView(this);
            imageView.setImageURI(imagemSelecionada);
            LinearLayout ln = (LinearLayout)findViewById(R.id.lnHoriSelect);
            ln.addView(imageView);
        }
    }
}