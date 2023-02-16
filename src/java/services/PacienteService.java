package services;

import entities.Paciente;
import javax.ejb.Stateless;

@Stateless
public class PacienteService extends EntityService<Paciente> {
    public PacienteService() { super(Paciente.class); }
}
