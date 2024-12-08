public abstract class Esercizio implements Comparable<Esercizio> {
    private String nome;
    private double durata;
    private int ripetizioni;
    private int difficoltà;
    private String descrizione;

    public Esercizio(String nome, double durata, int ripetizioni, int difficoltà, String descrizione) {
        if(difficoltà>3 || difficoltà<1) throw new IllegalArgumentException("La difficoltà dev'essere compresa tra 1 e 3");
        else this.difficoltà=difficoltà;
        this.nome = nome;
        this.durata = durata;
        this.ripetizioni = ripetizioni;
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public double getDurata() {
        return durata;
    }

    public int getRipetizioni() {
        return ripetizioni;
    }

    public int getDifficoltà() {
        return difficoltà;
    }

    public String eseguiEsercizio() {
        return descrizione;
    }

    public int compareTo(Esercizio o) {
        return this.getNome().compareTo(o.getNome());
    }
}
