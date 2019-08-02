package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Area implements Serializable {

	@Id
    private int cod;
    private String nome;

    @Id
    @ManyToOne
    @JoinColumn(name = "publicacao_id")
    private Publicacao publicacao;

    public Area(int cod, String nome, Publicacao publicacao) {
        this.cod = cod;
        this.nome = nome;
        this.publicacao=publicacao;

    }

    public Area() {
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
