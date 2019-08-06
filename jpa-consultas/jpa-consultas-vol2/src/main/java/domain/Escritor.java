package domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Escritor extends Pessoa implements Serializable {

    private int premios;

    @OneToMany(mappedBy = "escritor")
    private List<Publicacao> publicacoes;

    public Escritor(){
    }

    public Escritor(int id, String nome, Date dataNascimento, int premios, List<Publicacao> publicacoes) {
        super(id, nome, dataNascimento);
        this.premios = premios;
        this.publicacoes = publicacoes;
    }

    public int getPremios() {
        return premios;
    }

    public void setPremios(int premios) {
        this.premios = premios;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }
}

