package domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Revisor extends Pessoa implements Serializable {

    private String nota;

    @OneToMany(mappedBy = "revisor")
    private List<Publicacao> publicacoes;

    public Revisor() {
    }

    public Revisor(int id, String nome, Date dataNascimento, String nota, List<Publicacao> publicacoes) {
        super(id, nome, dataNascimento);
        this.nota = nota;
        this.publicacoes = publicacoes;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    @Override
    public String toString() {
        return "Revisor{" +
                "nota='" + nota + '\'' +
                '}';
    }
}
