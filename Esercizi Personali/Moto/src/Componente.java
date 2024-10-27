import javax.lang.model.type.NullType;

public class Componente {
    public class Motore implements Printing {
        private int potenza;
        private int coppia;
        public Motore(int potenza, int coppia) {
            this.potenza = potenza;
            this.coppia = coppia;
        }
        @Override
        public void visualizzaDettagliComponente() {
            System.out.println("Potenza: "+potenza+" CV\nCoppia: "+coppia+" Nm\n");
        }
    }

    public class Pneumatici implements Printing {
        private String dimensioni;
        private String tipo;
        public Pneumatici(String dimensioni, String tipo) {
            this.dimensioni = dimensioni;
            this.tipo = tipo;
        }
        @Override
        public void visualizzaDettagliComponente() {
            System.out.println("Dimensioni: "+dimensioni+"\nTipo: "+tipo+"\n");
        }
    }

    public class Freni implements Printing {
        private String tipoFreni;
        private String materiale;
        public Freni(String materiale, String tipoFreni) {
            this.materiale = materiale;
            this.tipoFreni = tipoFreni;
        }
        @Override
        public void visualizzaDettagliComponente() {
            System.out.println("Materiale: "+materiale+"\nTipo: "+tipoFreni+"\n");
        }
    }

    public class NonTypeComponente implements Printing {
        @Override
        public void visualizzaDettagliComponente() {
            return;
        }
    }

    private String nomeComponente;
    private String marcaComponente;
    private String modelloComponente;
    private int annoProduzione;
    private Object componente;

    public Componente(String nomeComponente, String marcaComponente, String modelloComponente, int annoProduzione, Object attributo1, Object attributo2) {
        this.nomeComponente = nomeComponente;
        this.marcaComponente = marcaComponente;
        this.modelloComponente = modelloComponente;
        this.annoProduzione = annoProduzione;
        if(nomeComponente=="Motore") {
            this.componente = new Motore((Integer) attributo1,(Integer) attributo2);
        }
        else if(nomeComponente=="Freni") {
            this.componente = new Freni((String)attributo1,(String)attributo2);
        }
        else if(nomeComponente=="Pneumatici") {
            this.componente = new Pneumatici((String) attributo1,(String) attributo2);
        }
    }

    public void visualizzaDettagliComponente() {
        System.out.print(nomeComponente + "\nMarca: " + marcaComponente + "\nModello: " + modelloComponente + "\nAnno Produzione: " + annoProduzione + "\n");
        if (nomeComponente == "Motore") {
            ((Motore) componente).visualizzaDettagliComponente();
        } else if (nomeComponente == "Freni") {
            ((Freni) componente).visualizzaDettagliComponente();
        } else if (nomeComponente == "Pneumatici") {
            ((Pneumatici) componente).visualizzaDettagliComponente();
        }
    }
}
