import java.util.ArrayList;

public class Moto {
    private String marca;
    private String modello;
    private int anno;
    private int cc;
    private String categoria;
    ArrayList<Componente> componenti;
    public Moto(String marca, String modello, int anno, int cc, String categoria) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.cc = cc;
        this.categoria = categoria;
        this.componenti = new ArrayList<>();
    }

    public String getModello() {
        return modello;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnno() {
        return anno;
    }

    public int getCc() {
        return cc;
    }

    public String getCategoria() {
        return categoria;
    }

    public ArrayList<Componente> getComponenti() {
        return componenti;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setComponenti(ArrayList<Componente> componenti) {
        this.componenti = componenti;
    }

    public void aggiungiComponente(Componente componente) {
        this.componenti.add(componente);
    }
    public void rimuoviComponente(Componente componente) {
        this.componenti.remove(componente);
    }
    public void visualizzaDettagli() {
        System.out.println("Dettagli Moto:\nMarca: "+this.marca+"\nModello: "+this.modello+"\nAnno: "+this.anno+"\nCc: "+this.cc+"\nCilindrata: "+this.cc+"\nCategoria: "+this.categoria+"\n");
        if(!this.componenti.isEmpty()) {
            int i=1;
            for(Componente componente : this.componenti) {
                System.out.print(i+". ");
                componente.visualizzaDettagliComponente();
                i++;
            }
        }
    }
}
