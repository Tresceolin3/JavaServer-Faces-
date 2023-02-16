package converters;

import entities.Atendimento;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Atendimento.class)
@Named
public class AtendimentoConverter extends EntityConverter<Atendimento> {
    
    public AtendimentoConverter() {
        super(Atendimento.class);
    }
}
