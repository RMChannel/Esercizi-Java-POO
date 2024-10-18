import java.util.Objects;

public class Action {
    private String nome;
    private double importo;
    private int quantità;
    private char type;
    public Action(String nome, double importo, int quantità, char type) {
        this.nome = nome;
        this.importo = importo;
        this.quantità = quantità;
        this.type = type;
    }

    public int getQuantità() {
        return quantità;
    }

    public String getNome() {
        return nome;
    }

    public double getImporto() {
        return importo;
    }

    public char getType() {
        return type;
    }

    public void stampaAzione() {
        System.out.println("Nome: "+nome+" Importo: "+importo+" Quantità: "+quantità+" Tipo: "+type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Double.compare(importo, action.importo) == 0 && quantità == action.quantità && type == action.type && Objects.equals(nome, action.nome);
    }
}
