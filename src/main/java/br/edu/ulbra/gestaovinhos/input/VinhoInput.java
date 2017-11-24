package br.edu.ulbra.gestaovinhos.input;

import java.util.Set;

import br.edu.ulbra.gestaovinhos.model.Avaliacao;

public class VinhoInput {

    private Long id;
    private String nome;
    private String nomeImagem;
    private String vinicola;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public String getVinicola() {
		return vinicola;
	}

	public void setVinicola(String vinicola) {
		this.vinicola = vinicola;
	}
}
