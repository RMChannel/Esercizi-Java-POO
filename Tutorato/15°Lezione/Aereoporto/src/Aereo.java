public class Aereo {
    private int id;
    private int capienza;
    private int annoDiProduzione;

    public Aereo(int id, int capienza, int annoDiProduzione) {
        this.id = id;
        this.capienza = capienza;
        this.annoDiProduzione = annoDiProduzione;
    }

    public int getId() {
        return id;
    }

    public int getCapienza() {
        return capienza;
    }

    public int getAnnoDiProduzione() {
        return annoDiProduzione;
    }

    public int getNPasseggeri(int passeggeri) {
        return capienza - passeggeri;
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass()==(Aereo.class)) {
            Aereo aereo = (Aereo) o;
            return aereo.id == this.id && aereo.capienza==this.capienza && aereo.annoDiProduzione==this.annoDiProduzione;
        }
        return false;
    }
}
