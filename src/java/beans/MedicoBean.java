package beans;

import entities.Medico;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import services.MedicoService;

@Named(value = "medicoBean")
@ViewScoped
public class MedicoBean implements Serializable {

    @EJB
    private MedicoService medicoService;
    @Inject
    private RequestParameters parameters;
    private Medico value;
    private boolean consultar;
    List<Medico> medicosFiltrados;

    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) {
            value = new Medico();
        } else {
            value = medicoService.find(Long.valueOf(id));
        }
    }

    public List<Medico> getMedicosFiltrados() {
        return medicosFiltrados;
    }

    public void setMedicosFiltrados(List<Medico> medicosFiltrados) {
        this.medicosFiltrados = medicosFiltrados;
    }

    public MedicoService getMedicoService() {
        return medicoService;
    }

    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
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

    public void consultar(Medico value) {
        setValue(value);
        this.consultar = true;
    }

    public Medico getValue() {
        return value;
    }

    public void setValue(Medico value) {
        this.value = value;
    }

    public void reset() {
        value = new Medico();
    }

    public void inserir() {
        reset();
    }

    public List<Medico> getAll() {
        return medicoService.getAll();
    }

    public String save() {
        medicoService.create(value);
        reset();
        return null;
    }

    public String update() {
        medicoService.edit(value);
        return null;
    }

    public String delete() {
        medicoService.remove(value);
        return null;
    }

}
