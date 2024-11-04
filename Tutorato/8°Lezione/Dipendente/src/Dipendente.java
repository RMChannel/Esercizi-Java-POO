public class Dipendente {
    private String matricola;
    private double stipendio;
    private double straordinario;
    public Dipendente(String matricola, double stipendio, double straordinario) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.straordinario = straordinario;
    }
    public String getMatricola() {
        return matricola;
    }
    public double getStipendio() {
        return stipendio;
    }
    public double getStraordinario() {
        return straordinario;
    }
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }
    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }
    public void setStraordinario(double straordinario) {
        this.straordinario = straordinario;
    }
    public double paga(int ore) {
        return (ore*straordinario)+stipendio;
    }
}