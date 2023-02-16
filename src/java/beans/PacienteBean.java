package beans;

import entities.Paciente;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.PacienteService;

@Named(value = "pacienteBean")
@ViewScoped
public class PacienteBean implements Serializable {

    @EJB
    private PacienteService pacienteService;
    @Inject
    private RequestParameters parameters;
    private Paciente value;
    private boolean consultar;
    List<Paciente> pacientesFiltrados;

    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) {
            value = new Paciente();
        } else {
            value = pacienteService.find(Long.valueOf(id));
        }
    }

    public List<Paciente> getPacientesFiltrados() {
        return pacientesFiltrados;
    }

    public void setPacientesFiltrados(List<Paciente> pacientesFiltrados) {
        this.pacientesFiltrados = pacientesFiltrados;
    }

    public PacienteService getPacienteService() {
        return pacienteService;
    }

    public void setPacienteService(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public RequestParameters getParameters() {
        return parameters;
    }

    public void setParameters(RequestParameters parameters) {
        this.parameters = parameters;
    }

    public boolean isConsultar() {
        boolean consultar = this.consultar;
        return consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public void consultar(Paciente value) {
        setValue(value);
        this.consultar = true;
    }

    public Paciente getValue() {
        return value;
    }

    public void setValue(Paciente value) {
        this.value = value;
    }

    public void reset() {
        value = new Paciente();
    }

    public void inserir() {
        reset();
    }

    public List<Paciente> getAll() {
        return pacienteService.getAll();
    }

    public String save() {
        pacienteService.create(value);
        reset();
        return null;
    }

    public String update() {
        pacienteService.edit(value);
        return null;
    }

    public String delete() {
        pacienteService.remove(value);
        return null;
    }

}
