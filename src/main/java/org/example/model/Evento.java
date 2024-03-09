package org.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
	
    private String nome;
    private String endereco;
    private String categoria;
    private LocalDateTime horario;
	private String descricao;
    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", categoria='" + categoria + '\'' +
                ", horario=" + horario +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}