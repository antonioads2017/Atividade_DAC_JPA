package domain;

import domain.Professor;
import domain.TelefoneType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-01T14:42:50")
@StaticMetamodel(Telefone.class)
public class Telefone_ { 

    public static volatile SingularAttribute<Telefone, TelefoneType> tipo;
    public static volatile SingularAttribute<Telefone, Professor> professor;
    public static volatile SingularAttribute<Telefone, String> numero;

}