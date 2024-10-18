import java.util.ArrayList;

public class Archivio {
    ArrayList<Action> archivio;
    public Archivio() {
        archivio = new ArrayList<>();
    }

    public void addAction(Action action) {
        archivio.add(action);
    }

    public void removeAction(Action action) {
        archivio.remove(action);
    }

    public double getTotaleAzioni() {
        double result=0.0;
        for(Action azione : archivio) {
            result+=azione.getImporto();
        }
        return result;
    }
    public double getInformazioneAzione(Action azione) {
        for(Action azione1 : archivio) {
            if (azione.equals(azione1)) {
                return azione1.getImporto();
            }
        }
        return 0;
    }
    public ArrayList<Action> getAzioniTipologia(char tipologia) {
        ArrayList<Action> azioni=new ArrayList<>();
        for(Action azione : archivio) {
            if(azione.getType()==tipologia) azioni.add(azione);
        }
        return azioni;
    }

    public Action AzionePiùAlta() {
        Action max=new Action("temp",0,0,'B');
        for (Action azione : archivio) {
            if(azione.getImporto()>max.getImporto()) max=azione;
        }
        return max;
    }

    public ArrayList<Action> cercaRangeAzioni(int max) {
        ArrayList<Action> azioni=new ArrayList<>();
        for(Action azione : archivio) {
            if(azione.getImporto()<max) azioni.add(azione);
        }
        return azioni;
    }
}
