package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Pessoa  {


    @OneToMany(mappedBy = "professor",cascade = CascadeType.PERSIST)
    private List<Telefone> telefones;

    private Double salario;

    public Professor() { }

	public Professor(String nome, String cpf, int idade, Date dataNascimento, Endereco endereco,
			List<Telefone> telefones, Double salario) {
		super(nome, cpf, idade, dataNascimento, endereco);
		this.telefones = telefones;
		this.salario = salario;
	}

	public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
