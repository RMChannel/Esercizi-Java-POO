public class Prenotazione {
    private int id;
    private Utente utente;
    private Attivita attivita;
    public Prenotazione(int id, Utente utente, Attivita attivita) {
        this.id = id;
        this.utente = utente;
        this.attivita = attivita;
    }

    public Attivita getAttivita() {
        return attivita;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(Prenotazione.class)) {
            Prenotazione p = (Prenotazione) obj;
            return p.utente.equals(this.utente) && p.attivita.equals(this.attivita);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.id + " " + this.utente.getId() + " " + this.attivita.getNome();
    }
}
