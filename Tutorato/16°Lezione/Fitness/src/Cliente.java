public class Cliente {
    private String nome;
    private int età;
    private String obbiettivo;
    private PianoAllenamento pa;
    public Cliente(String nome, int età, String obbiettivo, PianoAllenamento pa) {
        this.nome = nome;
        this.età = età;
        this.obbiettivo = obbiettivo;
        this.pa = pa;
    }

    public Cliente(String nome, int età, String obbiettivo) {
        this.nome = nome;
        this.età = età;
        this.obbiettivo = obbiettivo;
        this.pa = null;
    }

    public String getNome() {
        return nome;
    }

    public int getEtà() {
        return età;
    }

    public String getObbiettivo() {
        return obbiettivo;
    }

    public PianoAllenamento getPa() {
        return pa;
    }
}
