import java.util.GregorianCalendar;

public class RegaloBambino extends Regalo {
    private String nome;
    private int età;
    private String messaggio;
    public RegaloBambino(GregorianCalendar dataDiConsegna, double peso, String regione, String nome, int età, String messaggio) {
        super(dataDiConsegna,peso,regione);
        this.nome = nome;
        this.età = età;
        this.messaggio = messaggio;
    }
    @Override
    public String toString() {
        return "HoHoHo "+messaggio;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(this.getClass())) {
            RegaloBambino regalo = (RegaloBambino) obj;
            return regalo.nome.equals(this.nome) && regalo.età == this.età && regalo.messaggio == this.messaggio && super.equals(obj);
        }
        else return false;
    }
    @Override
    public Object clone() {
        return new RegaloBambino(super.getDataDiConsegna(),super.getPeso(),super.getRegione(),this.nome,this.età,this.messaggio);
    }

    public String getNome() {
        return nome;
    }

    public int getEtà() {
        return età;
    }

    public String getMessaggio() {
        return messaggio;
    }
}
