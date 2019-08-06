package view;

import domain.Revisor;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

public class AppJPQL2 {
    public static void main(String[] args) {

        EntityManager em = Persistence
                .createEntityManagerFactory("AtividadeVol2")
                .createEntityManager();
        new IniciadorBancoDeDados(em).dadosIniciais();

//        letraA(em); //Feito
//        letraB(em); //Feito
//        letraC(em); //Feito
//        letraD(em); //Feito
    }

    //O nome da pessoa, o título da publicação e o nome da área em que a pessoa tem o
    //atributo id igual a 3.
    private static void letraA(EntityManager em) {
        String jpql="SELECT r.nome, pu.titulo, a.nome FROM Revisor r, IN(r.publicacoes) pu, IN(pu.areas) a " +
                "WHERE r.id=3 UNION SELECT e.nome, pu2.titulo, a2.nome FROM Escritor e, " +
                "IN(e.publicacoes) pu2, IN(pu2.areas) a2 WHERE e.id=3";
        TypedQuery<Object[]> query = em.createQuery(jpql,Object[].class);
        query.getResultList().forEach(
                p-> System.out.println("Nome: "+p[0]+"\nPublicação: "+p[1]+"\nArea: "+p[2]+"\n")
        );
    }

    //O título da publicação e o nome do revisor que tenham alguma publicação na área
    //de indústria.
    private static void letraB(EntityManager em) {
        String jpql="SELECT p.titulo, r.nome FROM Revisor r, IN (r.publicacoes) p,IN(p.areas) a " +
                "WHERE LOWER(a.nome) like '%industria%' ";
        TypedQuery<Object[]> query = em.createQuery(jpql,Object[].class);
        query.getResultList().forEach(
                p-> System.out.println("Publicação: "+p[0]+"\nRevisor: "+p[1]+"\n")
        );
    }

    //O nome dos Revisores que possuem alguma publicação começando com Java.
    private static void letraC(EntityManager em) {
        String jpql="SELECT r.nome FROM Revisor r, IN(r.publicacoes) p WHERE LOWER(p.titulo) LIKE 'java%'";
        TypedQuery<String> query = em.createQuery(jpql, String.class);
        query.getResultList().forEach(System.out::println);
    }

    //O nome e a quantidade de Publicações escritas por Escritores com mais que três
    //prêmios.
    private static void letraD(EntityManager em) {
        String jpql = "SELECT e.nome, count(p) FROM Escritor e, in(e.publicacoes) p " +
                "WHERE e.premios>3 GROUP BY e.nome";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        query.getResultList().forEach(
                e-> System.out.println("Escritor: "+e[0]+" com "+e[1]+" publicação(ões)")
        );

    }
}
