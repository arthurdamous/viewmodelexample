package com.pronto.viewmodelexample.data;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Usuario {

    private String nome;
    private String idade;
    private int id;

    public Usuario() {
    }

    public Usuario(String nome, String idade, int id) {
        this.nome = nome;
        this.idade = idade;
        this.id = id;
    }

    public String getIdNome() {
        return id + ". " + nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public static DiffUtil.ItemCallback<Usuario> getItemCallback() {
        return new DiffUtil.ItemCallback<Usuario>() {
            @Override
            public boolean areItemsTheSame(@NonNull Usuario oldItem, @NonNull Usuario newItem) {
                return oldItem.id == newItem.id;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Usuario oldItem, @NonNull Usuario newItem) {
                return oldItem.equals(newItem);
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(idade, usuario.idade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, id);
    }

    @Override
    public String toString() {
        return "Nome= " + nome + "\n" +
                "Idade= " + idade;
    }
}
