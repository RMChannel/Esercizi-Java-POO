package it.unisa.compagniaaerea.passeggero;

public class PasseggeroBusiness extends Passeggero {
    public PasseggeroBusiness(String nome, String cognome, int puntiFedeltà, int annoIscrizionePianoFedeltà) {
        super(nome,cognome,puntiFedeltà,annoIscrizionePianoFedeltà);
    }
    public PasseggeroBusiness(String nome, String cognome, int annoIscrizionePianoFedeltà) {
        super(nome,cognome,annoIscrizionePianoFedeltà);
    }

    @Override
    public void guadagnaPunti(int miglia) throws LimitePuntiFedeltaException {
        int punti=(miglia/100)*5;
        if(super.getPuntiFedeltà()>5000) {
            punti+=(punti*25)/100;
        }
        super.addPunti(punti);
    }
}