package view;

import domain.Area;
import domain.Escritor;
import domain.Publicacao;
import domain.Revisor;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

public class AppCriteria2 {
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

    //O nome do escritor, o título da publicação e o nome da área em que o escritor tem o
    //atributo id igual a 3.
    private static void letraA(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Escritor> root = criteria.from(Escritor.class);

        Join<Escritor,Publicacao> escritorPublicacaoJoin = root.join("publicacoes");
        Join<Publicacao,Area> publicacaoAreaJoin = escritorPublicacaoJoin.join("areas");

        Predicate id = builder.equal(root.get("id"),3);

        criteria.where(id).multiselect(root.get("nome"),escritorPublicacaoJoin.get("titulo"),
                publicacaoAreaJoin.get("nome"));

        em.createQuery(criteria).getResultList().forEach(
                p-> System.out.println("Nome: "+p[0]+"\nPublicação: "+p[1]+"\nArea: "+p[2]+"\n")
        );

    }

    //O título da publicação e o nome do revisor que tenham alguma publicação na área
    //de indústria.
    private static void letraB(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Revisor> root = criteria.from(Revisor.class);

        Join<Revisor,Publicacao> revisorPublicacaoJoin = root.join("publicacoes");
        Join<Publicacao, Area> publicacaoAreaJoin = revisorPublicacaoJoin.join("areas");

        Predicate area = builder.like(builder.lower(publicacaoAreaJoin.get("nome")),"%industria%");

        criteria.multiselect(revisorPublicacaoJoin.get("titulo"),
                root.get("nome"))
                .where(area);
        em.createQuery(criteria).getResultList().forEach(
                p-> System.out.println("Publicação: "+p[0]+"\nRevisor: "+p[1]+"\n")
        );


    }

    //O nome dos Revisores que possuem alguma publicação começando com Java.
    private static void letraC(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<String> criteria = builder.createQuery(String.class);
        Root<Revisor> root = criteria.from(Revisor.class);
        Join<Revisor, Publicacao> join = root.join("publicacoes");
        Predicate predicate = builder.like(builder.lower(join.get("titulo")),"java%");
        criteria.where(predicate).select(root.get("nome"));
        em.createQuery(criteria).getResultList().forEach(
                System.out::println
        );


    }

    //O nome e a quantidade de Publicações escritas por Escritores com mais que três
    //prêmios.
    private static void letraD(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Escritor> root = criteria.from(Escritor.class);
        Join<Escritor,Publicacao> join = root.join("publicacoes");

        Predicate maiorQue3 = builder.gt(root.get("premios"),3);

        criteria.multiselect(root.get("nome"),builder.count(join))
                .where(maiorQue3)
                .groupBy(root.get("nome"));

        em.createQuery(criteria).getResultList().forEach(
                e-> System.out.println("Escritor: "+e[0]+" com "+e[1]+" publicação(ões)")
        );


    }
}
