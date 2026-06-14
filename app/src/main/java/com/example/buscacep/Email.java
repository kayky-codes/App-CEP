package com.example.buscacep;

import androidx.annotation.NonNull;

public class Email {
    private String email;
    private boolean valid_format;
    private boolean valid_mx;
    private  boolean disposable;

    public String getEmail() {
        return email;
    }
    public boolean getValidFormat() {
        return valid_format;
    }
    public boolean getValidMX() {
        return valid_mx;
    }
    public boolean getDisposable() {
        return disposable;
    }

    @NonNull
    @Override
    public String toString() {
        String formato, mx, descartavel;

        if (this.getValidFormat()){
            formato = "Valido";
        }
        else {
            formato = "Invalido";
        }

        if (this.getValidMX()){
            mx = "Valido";
        }
        else {
            mx = "Invalido";
        }

        if (this.getDisposable()){
            descartavel = "Temporario";
        }
        else {
            descartavel = "Não temporario";
        }

        return "*Informações do Email*\n" +
                "\nEndereco do Email: " + this.getEmail() +
                "\nFormato do email: " + formato +
                "\nDominio do email: " + mx +
                "\nEmail Temporaraio: " + descartavel;
    }
}
