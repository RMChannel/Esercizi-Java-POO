import java.io.Serializable;
import java.util.GregorianCalendar;

public class Elicottero extends Aeromobile implements Serializable {
    private String destinazione;
    private String identificativo;

    public Elicottero() {
        super();
        destinazione = "";
        identificativo = "";
    }

    public Elicottero(GregorianCalendar dataUltimaRevisione, GregorianCalendar dataProssimoVolo, int numeroPasseggeriPrenotati, String destinazione, String identificativo) {
        super(dataUltimaRevisione,dataProssimoVolo,numeroPasseggeriPrenotati);
        this.destinazione = destinazione;
        this.identificativo = identificativo;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public void setIdentificativo(String identificativo) {
        this.identificativo = identificativo;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public String getIdentificativo() {
        return identificativo;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(Elicottero.class)) {
            Elicottero other = (Elicottero) obj;
            Aeromobile temp = (Aeromobile) obj;
            return super.equals(temp) && other.destinazione.equals(destinazione) && other.identificativo.equals(identificativo);
        }
        return false;
    }

    @Override
    public String toString() {
        String toReturn="";
        if(destinazione.equals("")) {
            toReturn="Destinazione: non settata";
        }
        else {
            toReturn="Destinazione: "+destinazione;
        }
        if(identificativo.equals("")) {
            toReturn="Identificativo: non settato";
        }
        else {
            toReturn="Identificativo: "+identificativo;
        }
        return toReturn+" "+super.toString();
    }
}
