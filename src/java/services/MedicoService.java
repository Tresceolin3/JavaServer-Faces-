package services;

import entities.Medico;
import javax.ejb.Stateless;

@Stateless
public class MedicoService extends EntityService<Medico> {
    public MedicoService() { super(Medico.class); }
}
