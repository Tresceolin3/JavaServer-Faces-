package beans;

import entities.Atendimento;
import java.io.Serializable;
import util.RequestParameters;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.FlowEvent;
import services.AtendimentoService;

@Named(value = "atendimentoBean")
@ViewScoped
public class AtendimentoBean implements Serializable {

    @EJB
    private AtendimentoService atendimentoService;
    @Inject
    private RequestParameters parameters;
    private Atendimento value;
    private boolean consultar;
    List<Atendimento> atendimentosFiltrados;

    @PostConstruct
    public void init() {
        String id = parameters.get("id");
        if (id == null) {
            value = new Atendimento();
        } else {
            value = atendimentoService.find(Long.valueOf(id));
        }
    }

    public List<Atendimento> getAtendimentosFiltrados() {
        return atendimentosFiltrados;
    }

    public void setAtendimentosFiltrados(List<Atendimento> atendimentosFiltrados) {
        this.atendimentosFiltrados = atendimentosFiltrados;
    }

    public AtendimentoService getAtendimentoService() {
        return atendimentoService;
    }

    public void setAtendimentoService(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
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

    public void consultar(Atendimento value) {
        setValue(value);
        this.consultar = true;
    }

    public Atendimento getValue() {
        return value;
    }

    public void setValue(Atendimento value) {
        this.value = value;
    }

    public void reset() {
        value = new Atendimento();
    }

    public void inserir() {
        reset();
    }

    public List<Atendimento> getAll() {
        return atendimentoService.getAll();
    }

    public String save() {
        atendimentoService.create(value);
        reset();
        return null;
    }

    public String update() {
        atendimentoService.edit(value);
        return null;
    }

    public String delete() {
        atendimentoService.remove(value);
        return null;
    }

    public SelectItem[] getModalide(boolean filtrar) {
        SelectItem[] items;
        int length = Atendimento.Modalidade.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else {
            items = new SelectItem[length];
        }
        for (Atendimento.Modalidade modalidade : Atendimento.Modalidade.values()) {
            items[n++] = new SelectItem(modalidade, modalidade.getLabel());
        }
        return items;
    }

     public SelectItem[] getPlanoSaude(boolean filtrar) {
        SelectItem[] items;
        int length = Atendimento.PlanoSaude.values().length;
        int n = 0;
        if (filtrar) {
            items = new SelectItem[length + 1];
            items[0] = new SelectItem("", "");
            n++;
        } else {
            items = new SelectItem[length];
        }
        for (Atendimento.PlanoSaude plano_saude : Atendimento.PlanoSaude.values()) {
            items[n++] = new SelectItem(plano_saude, plano_saude.getLabel());
        }
        return items;
    }


    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

}
