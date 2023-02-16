package entities;

import entities.Atendimento.Modalidade;
import entities.Atendimento.PlanoSaude;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150916-rNA", date="2022-05-02T15:33:51")
@StaticMetamodel(Atendimento.class)
public class Atendimento_ { 

    public static volatile SingularAttribute<Atendimento, String> medicacao;
    public static volatile SingularAttribute<Atendimento, String> observacao;
    public static volatile SingularAttribute<Atendimento, PlanoSaude> plano_saude;
    public static volatile SingularAttribute<Atendimento, Date> data;
    public static volatile SingularAttribute<Atendimento, String> peso;
    public static volatile SingularAttribute<Atendimento, String> altura;
    public static volatile SingularAttribute<Atendimento, Long> id;
    public static volatile SingularAttribute<Atendimento, String> temperatura;
    public static volatile SingularAttribute<Atendimento, String> sintomas;
    public static volatile SingularAttribute<Atendimento, Modalidade> modalidade;

}