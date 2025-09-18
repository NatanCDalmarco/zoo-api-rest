package api_rest.zoologico.entity;

import jakarta.persistence.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 private String nome;

    public Long getId() {
        return id;
    }

public String getNome() {
        return nome;
    }

}