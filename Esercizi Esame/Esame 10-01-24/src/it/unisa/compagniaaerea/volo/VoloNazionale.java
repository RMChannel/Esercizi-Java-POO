package it.unisa.compagniaaerea.volo;

import java.util.GregorianCalendar;

public class VoloNazionale extends Volo {
    public VoloNazionale(String codiceVolo, int ore, GregorianCalendar data, int postiDisponibiliEconomy, int postiDisponibiliBusiness, int miglia) {
        super(codiceVolo, ore, data, postiDisponibiliEconomy, postiDisponibiliBusiness, miglia);
    }

    @Override
    public double calcolaPrezzoBiglietto(String classe) throws ClasseIndisponibileException {
        if(classe.toLowerCase().equals("economy")) {
            super.getPosto(0);
            if((super.getPostiTotaliEconomy()-super.getPostiDisponibiliEconomy())>30) {
                return 60;
            }
            else {
                return 30;
            }
        }
        else if(classe.toLowerCase().equals("business")) {
            super.getPosto(1);
            return 100;
        }
        else {
            throw new IllegalArgumentException("Classe non riconosciuta");
        }
    }
}
