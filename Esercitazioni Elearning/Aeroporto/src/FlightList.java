import java.util.ArrayList;

public class FlightList {
    private ArrayList<Volo> voli;
    public FlightList() {
        voli = new ArrayList<>();
    }

    public void addFlight(Volo volo) throws BadCodeException {
        for(Volo v : voli) {
            if(v.getCodice().equals(volo.getCodice())) {
                throw new BadCodeException();
            }
        }
        voli.add(volo);
    }

    public ArrayList<Volo> getVoli() {
        return voli;
    }

    public FlightList search(String o, String d) {
        FlightList fl = new FlightList();
        for(Volo v : voli) {
            if(v.getAeroportoDiPartenza().equals(o) && v.getAeroportoDiArrivo().equals(d)) {
                try {
                    fl.addFlight(v);
                } catch (BadCodeException e) {
                    System.err.println("è successo qualcosa che è teoricamente impossibile, nel caso, distruggere Intellij, grazie");
                }
            }
        }
        return fl;
    }
}
