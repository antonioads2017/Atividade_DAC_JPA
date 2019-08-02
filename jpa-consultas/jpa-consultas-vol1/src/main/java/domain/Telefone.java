package domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Telefone implements Serializable {

    @Id
	private String numero;
	@Enumerated(EnumType.STRING)
    private TelefoneType tipo;

	@ManyToOne
    @JoinColumn(name="professor_cpf")
	private Professor professor;

    public Telefone() { }

    public Telefone(String numero, TelefoneType tipo,Professor professor) {
        this.numero = numero;
        this.tipo = tipo;
        this.professor=professor;

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneType getTipo() {
        return tipo;
    }

    public void setTipo(TelefoneType tipo) {
        this.tipo = tipo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return  numero;
    }
}
