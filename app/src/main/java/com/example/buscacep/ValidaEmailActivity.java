package com.example.buscacep;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class ValidaEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_valida_email);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etEmail = findViewById(R.id.etEmail);
        Button btnPesquisa = findViewById(R.id.btnPesquisa);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        TextView tvResultado = findViewById(R.id.tvResultado);

        btnPesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constantes.url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create(Api.class);
                Call<Email> call = api.getValidEmail(
                        email, Constantes.TOKEN
                );

                call.enqueue(new Callback<Email>() {
                    @Override
                    public void onResponse(Call<Email> call, Response<Email> response) {
                        Email e = response.body();
                        tvResultado.setText(e.toString());
                    }

                    @Override
                    public void onFailure(Call<Email> call, Throwable throwable) {
                        Toast.makeText(
                                ValidaEmailActivity.this,
                                throwable.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                });
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}