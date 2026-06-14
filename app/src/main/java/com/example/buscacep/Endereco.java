package com.example.buscacep;

import androidx.annotation.NonNull;

public class Endereco {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;

    private String street;
    private String complement;
    private String ibge;

    public String getState() {
        return state;
    }

    public String getCep() {
        return cep;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getIbge() {
        return ibge;
    }

    public String getStreet() {
        return street;
    }

    public String getComplement() {
        return complement;
    }

    @NonNull
    @Override
    public String toString() {
        return "*Informações do Endereço*\n" +
                "\nCEP: " + this.getCep() +
               "\nEndereco: " + this.getStreet() +
               "\nCidade: " + this.getCity() +
               "\nBairro: " + this.getNeighborhood() +
               "\nIBGE: " + this.getIbge();
    }
}
