package ElencoAnimali;

import Animale.Animale;

import java.util.ArrayList;

public class ElencoAnimali {
    private ArrayList<Animale> animali;
    public ElencoAnimali() {
        animali = new ArrayList<Animale>();
    }

    public void addAnimale(Animale a) {
        animali.add(a);
    }

    public int getNumeroZampe() {
        int result=0;
        for(Animale a : animali) {
            result+=a.getZampe();
        }
        return result;
    }

    public int getCounter(String tipoAnimale) {
        int result=0;
        if(!tipoAnimale.equalsIgnoreCase("uccello") && !tipoAnimale.equalsIgnoreCase("pesce") && !tipoAnimale.equalsIgnoreCase("cane")) {
            throw new BadAnimalException();
        }
        for(Animale a : animali) {
            if(a.getClass().getSimpleName().equalsIgnoreCase(tipoAnimale)) {
                result++;
            }
        }
        return result;
    }

    public int alimenta() {
        int nInvocazioni=0;
        for(Animale a : animali) {
            for(int i=0;i<3;i++) {
                while(!a.vuoiMangiare()) nInvocazioni++;
                a.mangia();
            }
        }
        return nInvocazioni;
    }
}
