import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.GregorianCalendar;

public class Ordine implements Serializable {
    private int id;
    private GregorianCalendar data;
    private Cliente cliente;
    private Veicolo veicolo;
    public Ordine(int id, GregorianCalendar data, Cliente cliente, Veicolo veicolo) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.veicolo = veicolo;
    }

    public int getId() {
        return id;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", data: " + data.toString() + ", cliente: " + cliente.toString() + ", veicolo: " + veicolo.toString();
    }
}
