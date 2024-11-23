public class Utente {
    private int id;
    private String nome;
    private String email;
    public Utente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public boolean equals(Object o) {
        if(o.getClass().equals(this.getClass())) {
            Utente u = (Utente) o;
            return nome.equals(u.getNome()) && email.equals(u.getEmail());
        }
        return false;
    }
    @Override
    public String toString() {
        return this.id + " " + this.nome + " " + this.email;
    }
}
