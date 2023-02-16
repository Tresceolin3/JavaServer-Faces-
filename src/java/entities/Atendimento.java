package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atendimento implements Serializable, PersistentEntity {

    public enum Modalidade {
        consulta("consulta"), retorno("retorno"), exame("exame");
        private final String label;

        private Modalidade(String label) {
            this.label = label;
        }

        public String getLabel() {
            return this.label;
        }
    };

    public enum PlanoSaude {
        unimed("unimed"), cassemes("cassemes");
        private final String label;

        private PlanoSaude(String label) {
            this.label = label;
        }

        public String getLabel() {
            return this.label;
        }
    };

    private String sintomas;
    private String medicacao;
    @Enumerated(EnumType.STRING)
    private PlanoSaude plano_saude;
    private Modalidade modalidade;
    @Temporal(TemporalType.DATE)
    private Date data;

    private String observacao;
    private String peso;
    private String altura;
    private String temperatura;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(String medicacao) {
        this.medicacao = medicacao;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public PlanoSaude getPlanoSaude() {
        return plano_saude;
    }

    public void setPlanoSaude(PlanoSaude plano_saude) {
        this.plano_saude = plano_saude;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atendimento)) {
            return false;
        }
        Atendimento other = (Atendimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return sintomas;
    }

}
