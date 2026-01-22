package org.example.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "presidente")
public class Presidente {

    @Id
    private String id;
    private String nome;
    private Integer idade;
    private String partido;


    public Presidente() { }

    public Presidente(String nome, Integer idade, String partido) {
        this.nome = nome;
        this.idade = idade;
        this.partido = partido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Presidente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", partido='" + partido + '\'' +
                '}';
    }
}
