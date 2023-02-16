package services;

import entities.Atendimento;
import javax.ejb.Stateless;

@Stateless
public class AtendimentoService extends EntityService<Atendimento> {
    public AtendimentoService() { super(Atendimento.class); }
}
