package view;

import domain.Livro;
import domain.Professor;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppJPQL1 {

    public static void main(String[] args) {

        EntityManager em = Persistence
                .createEntityManagerFactory("AtividadeVol1")
                .createEntityManager();
        new IniciandorBancoDados(em).dadosIniciais();
        
//        letraA(em);
//        letraB(em); //Feito
//        letraC(em);
//        letraD(em);
//        letraE(em);
//        letraF(em);
    }

    //Uma consulta que selecione todos os livros dos autores que não nasceram no dia
    //21/11/1982.
    private static void letraA(EntityManager em) {
        String jpql="SELECT l FROM Livro l WHERE NOT " +
                "(SELECT a.datanascimento FROM Autor a WHERE a.datanascimento='1982-11-21')";
        TypedQuery<Livro> query = em.createQuery(jpql,Livro.class);
        query.getResultList().forEach(
                l -> System.out.printf(l.getNome())
        );

    }

    //Uma consulta que selecione todos os professores que possuem Telefone e residem
    //na rua “Que atividade fácil”.
    private static void letraB(EntityManager em) {
        String jpql = "SELECT DISTINCT p FROM Professor p LEFT JOIN p.telefones t WHERE p.endereco.rua='Que atividade facil' AND t.numero IS NOT NULL";
        TypedQuery<Professor> query = em.createQuery(jpql,Professor.class);
        query.getResultList().forEach(
                pr-> System.out.println(pr.getNome())
        );
    }

    //Uma classe, AlunoVO, que representa o nome, CPF e idade do Aluno. Crie uma
    //consulta, que retorna uma lista de todos os AlunoVO, selecionando todos os alunos
    //que pertencem a turma de 2019.1.
    private static void letraC(EntityManager em) {
    }

    //Uma consulta que seleciona todas os Professores que possuem algum telefone
    //que termina em 8.
    private static void letraD(EntityManager em) {
    }

    //Uma consulta que seleciona todos os livros dos Autores da cidade de Cajazeiras e
    //tiveram seu lançamento entre os dias 01/01/2019 e 12/12/2019.
    private static void letraE(EntityManager em) {
    }

    //Uma consulta que selecione os Livros dos Autores que começam com a letra “J”.
    private static void letraF(EntityManager em) {
    }

}
