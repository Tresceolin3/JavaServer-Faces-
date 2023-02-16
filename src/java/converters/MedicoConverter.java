package converters;

import entities.Medico;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@FacesConverter(forClass = Medico.class)
@Named
public class MedicoConverter extends EntityConverter<Medico> {
    
    public MedicoConverter() {
        super(Medico.class);
    }
}
