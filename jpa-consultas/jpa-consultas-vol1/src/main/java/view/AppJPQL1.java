package view;

import domain.AlunoVO;
import domain.Livro;
import domain.Professor;
import domain.Telefone;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Date;

public class AppJPQL1 {

    public static void main(String[] args) {

        EntityManager em = Persistence
                .createEntityManagerFactory("AtividadeVol1")
                .createEntityManager();
        new IniciandorBancoDados(em).dadosIniciais();
        
        letraA(em); //Feito
//        letraB(em); //Feito
//        letraC(em); //Feito
//        letraD(em); //Feito
//        letraE(em); //Feito
//        letraF(em); //Feito
    }

    //Uma consulta que selecione todos os livros dos autores que não nasceram no dia
    //21/11/1982.
    private static void letraA(EntityManager em) {
        String jpql="SELECT l FROM Livro l WHERE NOT EXISTS (SELECT a FROM l.autores a WHERE " +
                "a.dataNascimento='1982-11-21')";
        TypedQuery<Livro> query = em.createQuery(jpql,Livro.class);
        query.getResultList().forEach(
                l -> System.out.println(l.getNome())
        );

    }

    //Uma consulta que selecione todos os professores que possuem Telefone e residem
    //na rua “Que atividade fácil”.
    private static void letraB(EntityManager em) {
        String jpql = "SELECT  p FROM Professor p  WHERE p.endereco.rua='Que atividade facil' AND p.telefones IS NOT EMPTY";
        TypedQuery<Professor> query = em.createQuery(jpql,Professor.class);
        query.getResultList().forEach(
                pr-> System.out.println(pr.getNome())
        );
    }

    //Uma classe, AlunoVO, que representa o nome, CPF e idade do Aluno. Crie uma
    //consulta, que retorna uma lista de todos os AlunoVO, selecionando todos os alunos
    //que pertencem a turma de 2019.1.
    private static void letraC(EntityManager em) {
        String jpql ="SELECT NEW domain.AlunoVO(a.matricula,a.nome,a.idade)" +
                " FROM Aluno a WHERE a.turma='2019.1'" ;
        TypedQuery<AlunoVO> query = em.createQuery(jpql, AlunoVO.class);
        query.getResultList().forEach(
                a-> System.out.println("Aluno: "+a.getNome()+" \nCom Matricula: "+
                        a.getMatricula()+"\nCom idade: "+a.getIdade()+" anos.")
        );
    }

    //Uma consulta que seleciona todas os Professores que possuem algum telefone
    //que termina em 8.
    private static void letraD(EntityManager em) {
        String jpql="SELECT p FROM Professor p LEFT JOIN p.telefones t " +
                "WHERE t.numero LIKE '%8'";
        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.getResultList().forEach(
                p -> System.out.println("Professor: "+p.getNome())
        );
    }

    //Uma consulta que seleciona todos os livros dos Autores da cidade de Cajazeiras e
    //tiveram seu lançamento entre os dias 01/01/2019 e 12/12/2019.
    private static void letraE(EntityManager em) {
        String jpql="SELECT l FROM Livro l, IN(l.autores) a WHERE a.endereco.cidade LIKE '%Cajazeiras%' " +
                "AND l.lancamento BETWEEN '2019-01-01' AND '2019-12-12'";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.getResultList().forEach(
                l-> System.out.println("Livro:"+l.getNome())
        );
    }

    //Uma consulta que selecione os Livros dos Autores que começam com a letra “J”.
    private static void letraF(EntityManager em) {
        String jpql="SELECT l FROM Livro l, IN(l.autores) a WHERE LOWER(a.nome) LIKE 'j%' ";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.getResultList().forEach(
                l-> System.out.println("Livro: "+l.getNome())
        );
    }

}
