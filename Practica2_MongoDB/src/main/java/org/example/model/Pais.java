package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collation = "pais")
public class Pais {
    @Id
    private String nome;
    private String organizacion;
    private String [] partidos;
    private String id_presidente;

    public Pais() { }

    public Pais(String nome, String organizacion, String[] partidos, String id_presidente) {
        this.nome = nome;
        this.organizacion = organizacion;
        this.partidos = partidos;
        this.id_presidente = id_presidente;
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

    public String getId_presidente() {
        return id_presidente;
    }

    public void setId_presidente(String id_presidente) {
        this.id_presidente = id_presidente;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                ", organizacion='" + organizacion + '\'' +
                ", partidos=" + Arrays.toString(partidos) +
                ", presidente=" + id_presidente +
                '}';
    }
}
