public class Persona implements Comparable<Persona> {
    private String nome;
    public Persona(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public int compareTo(Persona o) {
        return nome.compareTo(o.getNome());
    }
}