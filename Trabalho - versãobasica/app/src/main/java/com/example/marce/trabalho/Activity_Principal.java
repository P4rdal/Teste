package com.example.marce.trabalho;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.http.HTTP;

public class Activity_Principal extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__principal);



        Button bt_todos = (Button)findViewById(R.id.princia_l_todos);
        bt_todos.setOnClickListener(this);


        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {




            }
        });




    }

    @Override

    public void onClick(View v) {
        //Se houvesse mais de um botão seria necessário colocar um switch

        Intent intent = new Intent(Activity_Principal.this,Activity_Todos.class);
        startActivity(intent);
    }






}


