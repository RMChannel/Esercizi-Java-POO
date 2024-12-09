import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Aeromobile implements Serializable {
    private GregorianCalendar dataUltimaRevisione;
    private GregorianCalendar dataProssimoVolo;
    private int numeroPasseggeriPrenotati;
    public Aeromobile() {
        dataUltimaRevisione = new GregorianCalendar();
        dataProssimoVolo = null;
        numeroPasseggeriPrenotati = 0;
    }
    public Aeromobile(GregorianCalendar dataUltimaRevisione, GregorianCalendar dataProssimoVolo, int numeroPasseggeriPrenotati) {
        if(dataUltimaRevisione.compareTo(new GregorianCalendar()) > 0) {
            throw new IllegalArgumentException("La revisione risulta fatta nel futuro");
        }
        this.dataUltimaRevisione = dataUltimaRevisione;
        if(dataProssimoVolo.compareTo(new GregorianCalendar()) < 0) {
            throw new IllegalArgumentException("Il volo risulta programmato nel passato");
        }
        this.dataProssimoVolo = dataProssimoVolo;
        this.numeroPasseggeriPrenotati = numeroPasseggeriPrenotati;
    }

    public GregorianCalendar getDataUltimaRevisione() {
        return dataUltimaRevisione;
    }

    public GregorianCalendar getDataProssimoVolo() {
        return dataProssimoVolo;
    }

    public int getNumeroPasseggeriPrenotati() {
        return numeroPasseggeriPrenotati;
    }

    public void setDataUltimaRevisione(GregorianCalendar dataUltimaRevisione) {
        this.dataUltimaRevisione = dataUltimaRevisione;
    }

    public void setDataProssimoVolo(GregorianCalendar dataProssimoVolo) {
        this.dataProssimoVolo = dataProssimoVolo;
    }

    public void setNumeroPasseggeriPrenotati(int numeroPasseggeriPrenotati) {
        this.numeroPasseggeriPrenotati = numeroPasseggeriPrenotati;
    }

    @Override
    public String toString() {
        String toReturn="";
        if(dataUltimaRevisione == null) {
            toReturn+="Data ultim revisione: non settata";
        }
        else {
            Date temp = dataUltimaRevisione.getTime();
            String tempString = temp.toString();
            tempString=tempString.substring(0,10)+" "+tempString.substring(24);
            toReturn+="Data ultim revisione: "+tempString;
        }
        if(dataProssimoVolo == null) {
            toReturn+=" Data volo programmato: non settata";
        }
        else {
            Date temp=dataProssimoVolo.getTime();
            String tempString = temp.toString();
            tempString=tempString.substring(0,10)+" "+tempString.substring(24);
            toReturn+=" Data volo programmato: "+tempString;
        }
        return toReturn+" Numero di passeggeri prenotati: "+numeroPasseggeriPrenotati;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(obj.getClass().getName().equals(this.getClass().getName())) {
            Aeromobile other = (Aeromobile) obj;
            return this.dataProssimoVolo.equals(other.dataProssimoVolo) && this.dataUltimaRevisione.equals(other.dataUltimaRevisione) && numeroPasseggeriPrenotati == other.numeroPasseggeriPrenotati;
        }
        return false;
    }

    public boolean isExpiredRevision() {
        if(dataUltimaRevisione == null) {
            return true;
        }
        Date today=new GregorianCalendar().getTime();
        Date revisionTime=dataUltimaRevisione.getTime();
        revisionTime.setYear(revisionTime.getYear()+3);
        if(revisionTime.compareTo(today)<=0) {
            return true;
        }
        else return false;
    }
}