package model;

import java.time.LocalDateTime;

public class Evento {
    private String nome;
    private String endereco;
    private Categoria categoria;
    private LocalDateTime horario;
    private String descricao;

    public Evento(String nome, String endereco, Categoria categoria,
                  LocalDateTime horario, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
    }

    public boolean estaOcorrendo() {
        return horario.isBefore(LocalDateTime.now()) &&
               horario.plusHours(2).isAfter(LocalDateTime.now());
    }

    public boolean jaOcorreu() {
        return horario.plusHours(2).isBefore(LocalDateTime.now());
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return nome + " | " + categoria + " | " + horario +
               " | " + endereco + "\nDescrição: " + descricao;
    }
}
