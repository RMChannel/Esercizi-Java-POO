public enum CategoriaMoto {
    SPORTIVA("SPORTIVA","Categoria di moto extraVeloci"),
    CRUISER("CRUISER","Categoria di moto pesanti, grandi, con conseguenti rapporti peso/potenza inferiori e un'attenzione particolare al comfort"),
    TOURING("TOURING","Categoria di motociclette con modifiche stilistiche e/o strutturali rispetto alla serie di produzione principale"),
    ENDURO("ENDURO","Categoria di moto adatte per corse su strade sterrate"),
    NAKED("NAKED","Categoria di moto che ha la caratteristica di esser priva di carenatura, di non aver nessun cupolino (o comunque minimal) e assenza di borse rigide"),
    ;
    private String categoria;
    private String descrizione;
    CategoriaMoto(String categoria, String descrizione) {
        this.categoria = categoria;
        this.descrizione = descrizione;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
