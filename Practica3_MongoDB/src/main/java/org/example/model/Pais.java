package org.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collation = "pais")
public class Pais {
    private String nome;
    private String organizacion;
    private String [] partidos;
    private Presidente presidente;

    public Pais() { }

    public Pais(String nome, String organizacion, String[] partidos, Presidente presidente) {
        this.nome = nome;
        this.organizacion = organizacion;
        this.partidos = partidos;
        this.presidente = presidente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String[] getPartidos() {
        return partidos;
    }

    public void setPartidos(String[] partidos) {
        this.partidos = partidos;
    }

    public Presidente getPresidente() {
        return presidente;
    }

    public void setPresidente(Presidente presidente) {
        this.presidente = presidente;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                ", organizacion='" + organizacion + '\'' +
                ", partidos=" + Arrays.toString(partidos) +
                ", presidente=" + presidente +
                '}';
    }
}
