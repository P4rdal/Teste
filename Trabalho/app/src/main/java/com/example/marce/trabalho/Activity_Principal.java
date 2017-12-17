package com.example.marce.trabalho;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;



public class Activity_Principal extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__principal);
        new DownloadDados().execute();

        Button bt_todos = (Button)findViewById(R.id.princia_l_todos);
        bt_todos.setOnClickListener(this);

        Button bt_histoico = (Button)findViewById(R.id.princia_l_historico);
        bt_histoico.setOnClickListener(this);

        Button bt_favoritos = (Button)findViewById(R.id.princia_l_favoritos);
        bt_favoritos.setOnClickListener(this);

        Button bt_creditos = (Button)findViewById(R.id.princia_l_creditos);
        bt_creditos.setOnClickListener(this);










    }

    @Override

    public void onClick(View v) {
        //Se houvesse mais de um botão seria necessário colocar um switch
        switch (v.getId()){

            case R.id.princia_l_historico:

                Intent intenthistorico = new Intent(Activity_Principal.this,Activity_Historico.class);
                startActivity(intenthistorico);

            break;

            case R.id.princia_l_todos:

                Intent intenttodos = new Intent(Activity_Principal.this,Activity_Todos.class);
                startActivity(intenttodos);

            break;




            case R.id.princia_l_favoritos:

                Intent intentfavoritos = new Intent(Activity_Principal.this,Activity_Favoritos.class);
                startActivity(intentfavoritos);

            break;

            case R.id.princia_l_creditos:

                Intent intentcreditos = new Intent(Activity_Principal.this,Activity_Creditos.class);
                startActivity(intentcreditos);

            break;


        }

    }






}


