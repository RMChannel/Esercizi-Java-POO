package it.unisa.compagniaaerea.passeggero;

public abstract class Passeggero implements Comparable<Passeggero> {
    private String nome;
    private String cognome;
    private int puntiFedeltà;
    private int annoIscrizionePianoFedeltà;
    public Passeggero(String nome, String cognome, int puntiFedeltà, int annoIscrizionePianoFedeltà) {
        this.nome = nome;
        this.cognome = cognome;
        this.puntiFedeltà = puntiFedeltà;
        this.annoIscrizionePianoFedeltà = annoIscrizionePianoFedeltà;
    }
    public Passeggero(String nome, String cognome, int annoIscrizionePianoFedeltà) {
        this.nome = nome;
        this.cognome = cognome;
        this.annoIscrizionePianoFedeltà = annoIscrizionePianoFedeltà;
        this.puntiFedeltà = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getPuntiFedeltà() {
        return puntiFedeltà;
    }

    public int getAnnoIscrizionePianoFedeltà() {
        return annoIscrizionePianoFedeltà;
    }

    public void addPunti(int punti) throws LimitePuntiFedeltaException {
        if(this.puntiFedeltà + punti > 10000) {
            this.puntiFedeltà=10000;
            throw new LimitePuntiFedeltaException("Limite punti fedeltà raggiunto");
        }
        else {
            this.puntiFedeltà+=punti;
        }
    }

    public abstract void guadagnaPunti(int miglia) throws LimitePuntiFedeltaException;

    @Override
    public int compareTo(Passeggero o) {
        return this.getCognome().compareTo(o.getCognome());
    }
}
