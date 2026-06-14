package com.example.buscacep;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Referencias
        EditText etCep = findViewById(R.id.txtCep);
        EditText btnPesquisa = findViewById(R.id.btnPesquisar);
        TextView tvResultado = findViewById(R.id.txtResposta);

        btnPesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cep = etCep.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constantes.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create((Api.class));

                Call<Endereco> call = api.getEndereco(cep, Constantes.TOKEN);

                call.enqueue(new Callback<Endereco>() {
                    @Override
                    public void onResponse(Call<Endereco> call, Response<Endereco> response) {
                        if (response.isSuccessful()){
                            Endereco e = response.body();
                            tvResultado.setText(e.toString());
                        }
                        else{

                        }

                    }

                    @Override
                    public void onFailure(Call<Endereco> call, Throwable throwable) {
                        Toast.makeText(MainActivity.this, "Erro ao realizar requisição", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}