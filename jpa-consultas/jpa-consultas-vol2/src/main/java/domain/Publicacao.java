package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Publicacao implements Serializable {

    @Id
    private int codPublicacao;
    private String titulo;

    @OneToMany(mappedBy = "publicacao")
    private List<Area> areas;

    @ManyToOne
    @JoinColumn(name = "revisor_id")
    private Revisor revisor;

    @ManyToOne
    @JoinColumn(name = "escritor_id")
    private Escritor escritor;

    public Publicacao() {
    }

    public Publicacao(int codPublicacao, String titulo, List<Area> areas, Revisor revisor, Escritor escritor) {
        this.codPublicacao = codPublicacao;
        this.titulo = titulo;
        this.areas = areas;
        this.revisor = revisor;
        this.escritor = escritor;
    }

    public int getCodPublicacao() {
        return codPublicacao;
    }

    public void setCodPublicacao(int codPublicacao) {
        this.codPublicacao = codPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public Revisor getRevisor() {
        return revisor;
    }

    public void setRevisor(Revisor revisor) {
        this.revisor = revisor;
    }

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }
}
