import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Aereoporto {
    private ArrayList<Volo> voli;
    private ArrayList<Aereo> aerei;
    private ArrayList<Persona> persone;
    public Aereoporto() {
        voli=new ArrayList<>();
        aerei=new ArrayList<>();
        persone=new ArrayList<>();
    }

    public ArrayList<Volo> getVoli() {
        return voli;
    }

    public ArrayList<Aereo> getAerei() {
        return aerei;
    }

    public ArrayList<Persona> getPersone() {
        return persone;
    }

    public void newVolo(String codice, Aereo aereo, String destinazione, GregorianCalendar orarioDiPartenza, GregorianCalendar orarioDiArrivo, boolean PA) {
        voli.add(new Volo(codice,aereo,destinazione,orarioDiPartenza,orarioDiArrivo,PA));
    }

    public void newVolo(String codice, String destinazione, GregorianCalendar orarioDiPartenza, GregorianCalendar orarioDiArrivo, boolean PA) {
        voli.add(new Volo(codice,destinazione,orarioDiPartenza,orarioDiArrivo,PA));
    }

    public void assegnaAereo(Volo volo, Aereo aereo) {
        for(Volo v: voli) {
            if(v.equals(volo)) {
                v.setAereo(aereo);
                break;
            }
        }
        throw new NotFound("Il volo non è registrato nell'aereoporto");
    }

    public void checkIn(Passeggero passeggero, Volo volo) {
        if(!persone.contains(passeggero)) {
            throw new NotRegistred("La passeggero non è registrata nell'aereoporto, registrare prima la passeggero");
        }
        for(Volo v: voli) {
            if(v.equals(volo)) {
                v.aggiungiPassegero(passeggero);
            }
        }
        throw new NotFound("Il volo non è registrato nell'aereoporto");
    }

    public void aggiungiAereo(Aereo aereo) {
        aerei.add(aereo);
    }

    public void aggiungiPersona(Persona persona) {
        persone.add(persona);
    }

    public void printVoli() {
        for(Volo v: voli) {
            System.out.println(v.toString());
        }
    }
}
