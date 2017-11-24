package br.edu.ulbra.gestaovinhos.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Vinho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false)
    String nomeImagem;

    @Column(nullable = false)
    String vinicola;

    @ManyToOne(optional = true)
    TipoVinho tipo;

    @OneToMany(mappedBy = "vinho", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Avaliacao> avaliacoes;


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
    
    public String getVinicola() {
        return vinicola;
    }

    public void setVinicola(String vinicola) {
        this.vinicola = vinicola;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public TipoVinho getTipo() {
        return tipo;
    }

    public void setTipo(TipoVinho tipo) {
        this.tipo = tipo;
    }

    public Set<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Set<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
