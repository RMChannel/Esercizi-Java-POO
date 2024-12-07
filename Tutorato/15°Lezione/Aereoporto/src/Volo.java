import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Volo {
    private String codice;
    private Aereo aereo;
    private String destinazione;
    private GregorianCalendar orarioDiPartenza;
    private GregorianCalendar orarioDiArrivo;
    private ArrayList<Persona> passeggeri;
    private boolean PA;

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public void setOrarioDiPartenza(GregorianCalendar orarioDiPartenza) {
        this.orarioDiPartenza = orarioDiPartenza;
    }

    public void setOrarioDiArrivo(GregorianCalendar orarioDiArrivo) {
        this.orarioDiArrivo = orarioDiArrivo;
    }

    public void setPA(boolean PA) {
        this.PA = PA;
    }

    public Volo(String codice, String destinazione, GregorianCalendar orarioDiPartenza, GregorianCalendar orarioDiArrivo, boolean PA) {
        this.codice = codice;
        this.destinazione = destinazione;
        this.orarioDiPartenza = orarioDiPartenza;
        this.orarioDiArrivo = orarioDiArrivo;
        passeggeri = new ArrayList<>();
        this.aereo = null;
        this.PA = PA;
    }

    public Volo(String codice, Aereo aereo, String destinazione, GregorianCalendar orarioDiPartenza, GregorianCalendar orarioDiArrivo, boolean PA) {
        this.codice = codice;
        this.aereo = aereo;
        this.destinazione = destinazione;
        this.orarioDiPartenza = orarioDiPartenza;
        this.orarioDiArrivo = orarioDiArrivo;
        passeggeri = new ArrayList<>();
        this.PA = PA;
    }

    public String getCodice() {
        return codice;
    }

    public boolean isPA() {
        return PA;
    }

    public Aereo getAereo() {
        return aereo;
    }

    public void setAereo(Aereo aereo) {
        this.aereo = aereo;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public GregorianCalendar getOrarioDiPartenza() {
        return orarioDiPartenza;
    }

    public GregorianCalendar getOrarioDiArrivo() {
        return orarioDiArrivo;
    }

    public ArrayList<Persona> getPasseggeri() {
        return passeggeri;
    }

    public int getNPasseggeri() {
        int n=0;
        for(Persona p : passeggeri) {
            if(p.getClass()==Passeggero.class) {
                n++;
            }
        }
        return n;
    }

    public int getNStaff() {
        int n=0;
        for(Persona p : passeggeri) {
            if(p.getClass()==Staff.class) {
                n++;
            }
        }
        return n;
    }

    public boolean isCompleto() {
        return aereo.getNPasseggeri(getNPasseggeri())==0;
    }

    public void aggiungiPassegero(Passeggero passeggero) {
        if(isCompleto()) {
            throw new MaxCapienzaAereo("L'aereo è al massimo della capienza");
        }
    }

    public void rimuoviPassegero(Passeggero passeggero) {
        if(!passeggeri.contains(passeggero)) {
            throw new IllegalArgumentException("Il passeggero non è presente nel volo");
        }
        else passeggeri.remove(passeggero);
    }

    public void aggiungiStaff(Staff staff) {
        passeggeri.add(staff);
    }

    public void rimuoviStaff(Staff staff) {
        if(!passeggeri.contains(staff)) {
            throw new IllegalArgumentException("Lo staff non è presente nel volo");
        }
        else passeggeri.remove(staff);
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass()==Volo.class) {
            Volo volo = (Volo) o;
            return volo.aereo.equals(aereo) && volo.destinazione.equals(destinazione) && volo.orarioDiPartenza.equals(orarioDiPartenza) && volo.orarioDiArrivo.equals(orarioDiArrivo) && volo.codice.equals(codice);
        }
        return false;
    }

    @Override
    public String toString() {
        String pa;
        if(PA) {
            pa="In partenza";
        }
        else pa="In arrivo";
        return "Tipo: "+pa+" Codice: "+codice+" Destinazione: "+destinazione+" Orario Di Partenza: "+orarioDiPartenza.getTime()+" Orario Di Arrivo: "+orarioDiArrivo.getTime()+" Passeggeri/Max "+getNPasseggeri()+"/"+aereo.getCapienza()+" N°Staff: "+getNStaff();
    }
}