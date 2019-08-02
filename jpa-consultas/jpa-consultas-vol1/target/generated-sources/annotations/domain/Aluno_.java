package domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-01T15:25:49")
@StaticMetamodel(Aluno.class)
public class Aluno_ extends Pessoa_ {

    public static volatile SingularAttribute<Aluno, String> matricula;
    public static volatile SingularAttribute<Aluno, String> turma;
    public static volatile SingularAttribute<Aluno, Date> dataIngreso;

}