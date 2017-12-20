package com.example.marce.teste;

import retrofit2.Response;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Callback;

import com.example.marce.teste.adapter.MoviesAdapter;
import com.example.marce.teste.model.Movie;
import com.example.marce.teste.model.MoviesResponse;
import com.example.marce.teste.rest.ApiClient;
import com.example.marce.teste.rest.ApiInterface;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;


import static java.lang.Boolean.FALSE;

public class Lista_todos extends AppCompatActivity {

    String teste;

    TextView textContatos;
    MovieDao movieDao;
    private static final String TAG = MainActivity.class.getSimpleName();
    private final static String API_KEY = "f96f35dad2d93764c36ed623ec9148ff";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_todos);
        textContatos = (TextView) findViewById(R.id.textContatos);

        movieDao = new MovieDao(this);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Coloque sua chave", Toast.LENGTH_LONG).show();
            return;


        }


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                int statusCode = response.code();
                List<Movie> movies = response.body().getResults();

                for (Movie filme : movies){

                   movieDao.insert(filme.getTitle(),filme.getOverview());

                }

                textContatos.setText("teste");





              }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }
}


