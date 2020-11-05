package com.project.cameraapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileInputStream;

public class SecondFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        Intent telaAnterior = getIntent();

        String nome = telaAnterior.getStringExtra("nome");
        String nomeFormatado = "O nome informado foi: " + nome;
        TextView txt_nome = (TextView) findViewById(R.id.txt_nome);
        txt_nome.setText(nomeFormatado);

        String email = telaAnterior.getStringExtra("email");
        String emailFormatado = "O e-mail informado foi: " + email;
        TextView txt_email = (TextView) findViewById(R.id.txt_email);
        txt_email.setText(emailFormatado);

        String telefone = telaAnterior.getStringExtra("telefone");
        String telefoneFormatado = "O telefone informado foi: " + telefone;
        TextView txt_telefone = (TextView) findViewById(R.id.txt_telefone);
        txt_telefone.setText(telefoneFormatado);


        Bitmap bmp = null;
        String filename = telaAnterior.getStringExtra("imagem");
        try {
            FileInputStream is = this.openFileInput(filename);
            bmp = BitmapFactory.decodeStream(is);
            is.close();
            ImageView imagemField = (ImageView)findViewById(R.id.imagem);
            imagemField.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}