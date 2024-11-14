import java.util.ArrayList;
import java.util.Comparator;

public class SlittaDiBabboNatale {
    private ArrayList<Regalo> lista;
    private final double maxPeso;
    private double peso;
    public SlittaDiBabboNatale(ArrayList lista, double maxPeso) {
        this.lista = lista;
        this.maxPeso = maxPeso;
        peso = getTotalPeso();
    }
    public SlittaDiBabboNatale(double maxPeso) {
        this.maxPeso = maxPeso;
        this.lista = new ArrayList();
    }
    private double getTotalPeso() {
        double total = 0;
        for(Regalo r: lista) {
            total+=r.getPeso();
        }
        return total;
    }
    public boolean aggiungiRegalo(Regalo regalo) {
        if((peso+regalo.getPeso())>maxPeso) {
            return false;
        }
        else {
            lista.add(regalo);
            peso+=regalo.getPeso();
            return true;
        }
    }
    public double calcolaCosto() {
        double costo = 0;
        for(Regalo r: lista) {
            costo+=r.calcolaCosto();
        }
        return costo;
    }

    public ArrayList getLista() {
        return lista;
    }

    public double getMaxPeso() {
        return maxPeso;
    }

    private int getResultFromRegion(Regalo regalo) {
        switch (regalo.getRegione()) {
            case("Nord"):
                return 0;
            case("Centro"):
                return 1;
            case("Sud"):
                return 2;
            default:
                return -1;
        }
    }
    public String spedisci() {
        ArrayList<Regalo> temp = (ArrayList) lista.clone();
        temp.sort(new Comparator<Regalo>() {
            public int compare(Regalo o1, Regalo o2) {
                return getResultFromRegion(o1) - getResultFromRegion(o2);
            }
        });
        String result="";
        for(Regalo r: temp) {
            result+=r.toString()+"\n";
        }
        return result;
    }
}
