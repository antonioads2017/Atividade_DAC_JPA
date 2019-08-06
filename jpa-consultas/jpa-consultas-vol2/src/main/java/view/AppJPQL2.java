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

//        letraA(em);
//        letraB(em);
//        letraC(em); //Feito
//        letraD(em);
    }

    //O nome da pessoa, o título da publicação e o nome da área em que a pessoa tem o
    //atributo id igual a 3.
    private static void letraA(EntityManager em) {
        String jpql="";
        Query query = em.createQuery(jpql);
        System.out.println(query.getSingleResult());
    }

    //O título da publicação e o nome do revisor que tenham alguma publicação na área
    //de indústria.
    private static void letraB(EntityManager em) {
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
    }
}
