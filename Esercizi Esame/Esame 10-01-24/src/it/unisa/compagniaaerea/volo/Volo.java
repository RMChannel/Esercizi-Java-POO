package it.unisa.compagniaaerea.volo;

import java.util.GregorianCalendar;

public abstract class Volo implements Comparable<Volo> {
    private String codiceVolo;
    private int ore;
    private GregorianCalendar data;
    private final int postiTotaliEconomy;
    private final int postiTotaliBusiness;
    private int postiDisponibiliEconomy;
    private int postiDisponibiliBusiness;
    private int miglia;
    public Volo(String codiceVolo, int ore, GregorianCalendar data, int postiDisponibiliEconomy, int postiDisponibiliBusiness, int miglia) {
        this.codiceVolo = codiceVolo;
        this.ore = ore;
        this.data = data;
        this.postiDisponibiliEconomy = postiDisponibiliEconomy;
        this.postiDisponibiliBusiness = postiDisponibiliBusiness;
        this.postiTotaliEconomy = postiDisponibiliEconomy;
        this.postiTotaliBusiness = postiDisponibiliBusiness;
        this.miglia = miglia;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public int getOre() {
        return ore;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public int getPostiDisponibiliEconomy() {
        return postiDisponibiliEconomy;
    }

    public int getPostiDisponibiliBusiness() {
        return postiDisponibiliBusiness;
    }

    public int getPostiTotaliEconomy() {
        return postiTotaliEconomy;
    }

    public int getPostiTotaliBusiness() {
        return postiTotaliBusiness;
    }

    public int getMiglia() {
        return miglia;
    }

    public void getPosto(int classe) throws ClasseIndisponibileException {
        if(classe==0) {
            if(postiDisponibiliEconomy==0) throw new ClasseIndisponibileException("Non ci sono posti disponibili nella classe economica");
        }
        else if(classe==1) {
            if(postiDisponibiliBusiness==0)  throw new ClasseIndisponibileException("Non ci sono posti disponibili nella classe business");
        }
        else throw new IllegalArgumentException("Classe non valida");
    }

    public void getPosto(String classe) {
        if(classe.equalsIgnoreCase("economy")) {
            postiDisponibiliEconomy--;
        }
        else if(classe.equalsIgnoreCase("business")) {
            postiDisponibiliBusiness--;
        }
        else throw new IllegalArgumentException("Classe non valida");
    }

    @Override
    public int compareTo(Volo o) {
        return o.getData().compareTo((this.getData()));
    }

    public abstract double calcolaPrezzoBiglietto(String classe) throws ClasseIndisponibileException;
}
