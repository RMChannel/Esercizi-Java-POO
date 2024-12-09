import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Aeroplano extends Aeromobile implements Serializable {
    private String modello;
    private String codiceVolo;
    private ArrayList<String> rotta;
    private int durataVolo;

    public Aeroplano() {
        super();
        modello = "";
        codiceVolo = "";
        rotta = new ArrayList<>();
        durataVolo = 0;
    }

    public Aeroplano(GregorianCalendar dataUltimaRevisione, GregorianCalendar dataProssimoVolo, int numeroDiPasseggeriPrenotati, String modello, String codiceVolo, ArrayList<String> rotta, int durataVolo) {
        super(dataUltimaRevisione,dataProssimoVolo,numeroDiPasseggeriPrenotati);
        this.modello = modello;
        this.codiceVolo = codiceVolo;
        this.rotta = rotta;
        this.durataVolo = durataVolo;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(obj.getClass().getName().equals(this.getClass().getName())) {
            Aeroplano a = (Aeroplano) obj;
            Aeromobile temp = (Aeromobile) obj;
            return super.equals(temp) && modello.equals(a.modello) && codiceVolo.equals(a.codiceVolo) && rotta.equals(a.rotta) && durataVolo == a.durataVolo;
        }
        return false;
    }

    public String getModello() {
        return modello;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public ArrayList<String> getRotta() {
        return rotta;
    }

    public int getDurataVolo() {
        return durataVolo;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setCodiceVolo(String codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

    public void setRotta(ArrayList<String> rotta) {
        this.rotta = rotta;
    }

    public void setDurataVolo(int durataVolo) {
        this.durataVolo = durataVolo;
    }

    @Override
    public String toString() {
        String toReturn="";
        if(modello=="") {
            toReturn="Modello: non settato";
        }
        else {
            toReturn="Modello: "+modello;
        }
        if(codiceVolo=="") {
            toReturn+=" Codice volo: non settato";
        }
        else {
            toReturn+=" Codice volo: "+codiceVolo;
        }
        if(rotta.isEmpty()) {
            toReturn+=" Rotta: non settato";
        }
        else {
            toReturn+=" Rotta: ";
            for(String rotta:rotta) {
                toReturn+=rotta+", ";
            }
        }
        if(durataVolo==0) {
            toReturn+=" Durata volo: non settato";
        }
        else {
            toReturn+=" Durata volo: "+durataVolo;
        }
        return toReturn+" "+super.toString();
    }
}
