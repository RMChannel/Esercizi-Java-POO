package it.unisa.compagniaaerea.compagnia;

import it.unisa.compagniaaerea.passeggero.InserimentoPasseggeroException;
import it.unisa.compagniaaerea.passeggero.LimitePuntiFedeltaException;
import it.unisa.compagniaaerea.passeggero.Passeggero;
import it.unisa.compagniaaerea.volo.ClasseIndisponibileException;
import it.unisa.compagniaaerea.volo.InserimentoVoloException;
import it.unisa.compagniaaerea.volo.Volo;

import java.util.ArrayList;
import java.util.List;

public class CompagniaAerea {
    private List<Passeggero> passeggeri;
    private List<Volo> voli;
    private String nome;
    private double guadagno;
    private int numeroPasseggeri;
    public CompagniaAerea(String nome) {
        this.nome = nome;
        passeggeri = new ArrayList<>();
        voli = new ArrayList<>();
        guadagno = 0;
        numeroPasseggeri = 0;
    }

    public List<Passeggero> getPasseggeri() {
        return passeggeri;
    }

    public List<Volo> getVoli() {
        return voli;
    }

    public String getNome() {
        return nome;
    }

    public double getGuadagno() {
        return guadagno;
    }

    public int getNumeroPasseggeri() {
        return numeroPasseggeri;
    }

    public void aggiungiPasseggero(Passeggero p) throws InserimentoPasseggeroException {
        if(passeggeri.contains(p)) {
            throw new InserimentoPasseggeroException("Il passeggero è già presente nel database della compagnia");
        }
        passeggeri.add(p);
        passeggeri.sort(Passeggero::compareTo);
    }

    public void aggiungiVolo(Volo v) throws InserimentoVoloException {
        if(voli.contains(v)) {
            throw new InserimentoVoloException("Il volo è già presente nel database");
        }
        voli.add(v);
        voli.sort(Volo::compareTo);
    }

    public void prenotaVolo(String codiceVolo, Passeggero p, String classe) throws OverbookingException {
        for(Volo v : voli) {
            if(v.getCodiceVolo().equals(codiceVolo)) {
                try {
                    guadagno+=v.calcolaPrezzoBiglietto(classe);
                    v.getPosto(classe);
                    p.guadagnaPunti(v.getMiglia());
                    numeroPasseggeri++;
                } catch (ClasseIndisponibileException e) {
                    throw new OverbookingException("Non ci sono più posti disponibili");
                } catch (LimitePuntiFedeltaException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
