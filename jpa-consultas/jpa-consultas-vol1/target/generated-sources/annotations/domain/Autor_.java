package domain;

import domain.Livro;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-01T14:02:37")
@StaticMetamodel(Autor.class)
public class Autor_ extends Pessoa_ {

    public static volatile ListAttribute<Autor, Livro> livros;
    public static volatile SingularAttribute<Autor, String> instituicaoVInculada;

}