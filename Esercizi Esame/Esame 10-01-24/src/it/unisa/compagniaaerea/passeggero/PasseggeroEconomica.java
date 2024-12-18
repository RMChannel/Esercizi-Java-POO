package it.unisa.compagniaaerea.passeggero;

import java.time.Year;

public class PasseggeroEconomica extends Passeggero {
    public PasseggeroEconomica(String nome, String cognome, int puntiFedeltà, int annoIscrizionePianoFedeltà) {
        super(nome,cognome,puntiFedeltà,annoIscrizionePianoFedeltà);
    }
    public PasseggeroEconomica(String nome, String cognome, int annoIscrizionePianoFedeltà) {
        super(nome,cognome,annoIscrizionePianoFedeltà);
    }

    @Override
    public void guadagnaPunti(int miglia) throws LimitePuntiFedeltaException {
        int punti=miglia/100;
        if((Year.now().getValue()-super.getAnnoIscrizionePianoFedeltà())>=10) {
            punti*=2;
        }
        super.addPunti(punti);
    }
}