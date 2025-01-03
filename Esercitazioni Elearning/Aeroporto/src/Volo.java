import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Volo implements Cloneable {
    private String aeroportoDiPartenza;
    private String aeroportoDiArrivo;
    private String codice;
    private String compagniaAerea;
    private int[] tipiDiBiglietti;
    private List<Seat> posti;

    public Volo(String aeroportoDiPartenza, String aeroportoDiArrivo, String codice, String compagniaAerea, int[] tipiDiBiglietti) {
        this.aeroportoDiPartenza = aeroportoDiPartenza;
        this.aeroportoDiArrivo = aeroportoDiArrivo;
        this.codice = codice;
        this.compagniaAerea = compagniaAerea;
        this.tipiDiBiglietti = tipiDiBiglietti;
        posti = new ArrayList<Seat>();
        char[] alfabeto={'A','B','C','D','E','F','G','H'};
        for (int i = 0; i < 20; i++) {
            for(char c:alfabeto) {
                posti.add(new Seat(i,c,false));
            }
        }
    }

    public Volo() {
        aeroportoDiPartenza = "";
        aeroportoDiArrivo = "";
        codice = "";
        compagniaAerea = "";
        tipiDiBiglietti = new int[20];
        posti = null;
    }

    public String getAeroportoDiPartenza() {
        return aeroportoDiPartenza;
    }

    public String getAeroportoDiArrivo() {
        return aeroportoDiArrivo;
    }

    public String getCodice() {
        return codice;
    }

    public String getCompagniaAerea() {
        return compagniaAerea;
    }

    public int[] getTipiDiBiglietti() {
        return tipiDiBiglietti;
    }

    public List<Seat> getPosti() {
        return posti;
    }

    public void setAeroportoDiPartenza(String aeroportoDiPartenza) {
        this.aeroportoDiPartenza = aeroportoDiPartenza;
    }

    public void setAeroportoDiArrivo(String aeroportoDiArrivo) {
        this.aeroportoDiArrivo = aeroportoDiArrivo;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setCompagniaAerea(String compagniaAerea) {
        this.compagniaAerea = compagniaAerea;
    }

    public void setTipiDiBiglietti(int[] tipiDiBiglietti) {
        this.tipiDiBiglietti = tipiDiBiglietti;
    }

    public void setPosti(List<Seat> posti) {
        this.posti = posti;
    }

    @Override
    public String toString() {
        return "Volo{" +
                "aeroportoDiPartenza='" + aeroportoDiPartenza + '\'' +
                ", aeroportoDiArrivo='" + aeroportoDiArrivo + '\'' +
                ", codice='" + codice + '\'' +
                ", compagniaAerea='" + compagniaAerea + '\'' +
                ", tipiDiBiglietti=" + Arrays.toString(tipiDiBiglietti) +
                ", posti=" + posti +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Volo volo = (Volo) o;
        return Objects.equals(aeroportoDiPartenza, volo.aeroportoDiPartenza) && Objects.equals(aeroportoDiArrivo, volo.aeroportoDiArrivo) && Objects.equals(codice, volo.codice) && Objects.equals(compagniaAerea, volo.compagniaAerea) && Objects.deepEquals(tipiDiBiglietti, volo.tipiDiBiglietti) && Objects.equals(posti, volo.posti);
    }

    @Override
    public Volo clone() throws CloneNotSupportedException {
        Volo v=(Volo) super.clone();
        v.setAeroportoDiPartenza(aeroportoDiPartenza);
        v.setAeroportoDiArrivo(codice);
        v.setCodice(codice);
        v.setCompagniaAerea(compagniaAerea);
        v.setTipiDiBiglietti(tipiDiBiglietti);
        v.setPosti(posti);
        return v;
    }

    List<Seat> filterSeats(Filter f) {
        ArrayList<Seat> seats=new ArrayList<>();
        for(Seat seat:seats) {
            if(f.apply(seat)) {
                seats.add(seat);
            }
        }
        return seats;
    }
}
