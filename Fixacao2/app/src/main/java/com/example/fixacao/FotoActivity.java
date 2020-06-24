package com.example.fixacao;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FotoActivity extends AppCompatActivity {
    private static final int PegaImagem = 1;
    private Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
    }

    public void capturarImagem(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, PegaImagem);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PegaImagem) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
                ImageView imageView = new ImageView(this);
                imageView.setImageBitmap(imageBitmap);
                mostrarMensagem("Imagem capturada!");
                adicionarNaGaleria();
                linear.addView(imageView);
            } else {
                mostrarMensagem("Imagem não capturada!");
            }
        }
       /* if (resultCode == Activity.RESULT_OK && requestCode == 123)
        {
            Uri imagemSelecionada = data.getData();
            //ImageView imageView = (ImageView) findViewById(R.id.imageView);

            imageView.setImageURI(imagemSelecionada);
            LinearLayout ln = (LinearLayout)findViewById(R.id.LinearLayoutFoto);
            ln.addView(imageView);
        }*/
    }


    private void mostrarMensagem(String msg){
        Toast.makeText(this, msg,
                Toast.LENGTH_LONG)
                .show();
    }

    private void adicionarNaGaleria() {
        Intent intent = new Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }

    public void Imagem(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "image/jpeg");
        startActivity(intent);
    }

    public void galeria (View view){
        Intent intent = new Intent(FotoActivity.this, GaleriaActivity.class);
        startActivity(intent);
    }

}