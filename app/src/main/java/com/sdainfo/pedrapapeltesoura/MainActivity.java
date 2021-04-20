package com.sdainfo.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageMaquina;
    private TextView tv_maquina, tv_usuario, tv_resultado;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageMaquina = findViewById(R.id.iv_maquina);
        tv_maquina = findViewById(R.id.tv_maquina);
        tv_usuario = findViewById(R.id.tv_jogador);
        tv_resultado = findViewById(R.id.tvResultado);

        mp = MediaPlayer.create(this, R.raw.som);

    }

    private void playerSom(){
        if(mp != null){
            mp.start();
        }
    }

    public  void opcaoSelecionada(String usuario){

        String[] opcoes = {"pedra","papel","tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "pedra":
                imageMaquina.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageMaquina.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageMaquina.setImageResource(R.drawable.tesoura);
                break;
        }

        if ((escolhaApp.equals("pedra") && usuario.equals("tesoura"))||(escolhaApp.equals("papel") && usuario.equals("pedra"))||(escolhaApp.equals("tesoura") && usuario.equals("papel"))){//mqna ganha
            tv_maquina.setText("App : "+ escolhaApp);
            tv_usuario.setText("Usuário : " + usuario);
            tv_resultado.setText("App -> you win");
        }else if((escolhaApp.equals("tesoura") && usuario.equals("pedra"))||(escolhaApp.equals("pedra") && usuario.equals("papel"))||(escolhaApp.equals("papel") && usuario.equals("tesoural"))){//user ganha
            tv_maquina.setText("App : "+ escolhaApp);
            tv_usuario.setText("Usuário : " + usuario);
            tv_resultado.setText("Usuário -> you win");
        }else{//empate
            tv_maquina.setText("App : "+ escolhaApp);
            tv_usuario.setText("Usuário : " + usuario);
            tv_resultado.setText("Empatou");

        }

    }

    public  void pedraSelecionada(View view){
        opcaoSelecionada("pedra");
        playerSom();
    }

    public  void papelSelecionada(View view){
        opcaoSelecionada("papel");
        playerSom();
    }

    public  void tesouraSelecionada(View view){
        opcaoSelecionada("tesoura");
        playerSom();
    }



}