package com.example.buscacep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    @GET("cep/{numero}")
    Call<Endereco> getEndereco(
            @Path("numero") String numero,
            @Query("token") String token
    );
}
