package AutoMezzo;

import java.util.GregorianCalendar;

public abstract class AutoMezzo {
    private String marca;
    private String modello;
    private String targa;
    private boolean disponibile;
    private GregorianCalendar dataInizioNoleggio;
    private int cavalliFiscali;

    public AutoMezzo(String marca, String modello, int cavalliFiscali, String targa) {
        this.marca = marca;
        this.modello = modello;
        this.cavalliFiscali = cavalliFiscali;
        this.targa = targa;
        disponibile = true;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String getTarga() {
        return targa;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public int getCavalliFiscali() {
        return cavalliFiscali;
    }

    public GregorianCalendar getDataInizioNoleggio() {
        return dataInizioNoleggio;
    }

    public void prestito() {
        if(disponibile) {
            disponibile = false;
            dataInizioNoleggio = new GregorianCalendar();
        }
        else throw new RuntimeException("Automezzo non disponibile");
    }

    public abstract double reso(GregorianCalendar dataFineNoleggio);

    @Override
    public String toString() {
        return "Marca: "+marca+" Modello: "+modello+" Disponibile: "+disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
}
