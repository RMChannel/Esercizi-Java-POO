package Noleggio;

public class Noleggio {
    private Film film;
    private int ritardo;
    public Noleggio(Film film, int ritardo) {
        this.film = film;
        this.ritardo = ritardo;
    }
    public Noleggio(Film film) {
        this.film = film;
        this.ritardo = 0;
    }
    public Film getFilm() {
        return film;
    }
    public int getRitardo() {
        return ritardo;
    }
    public void setRitardo(int ritardo) {
        this.ritardo = ritardo;
    }
    public double calcolaPenale() {
        return film.calcolaPenaleRitardo(this.ritardo);
    }
}
