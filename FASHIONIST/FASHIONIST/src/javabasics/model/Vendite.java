package javabasics.model;

public class Vendite {
    private String id;
    private String idCapo;
    private String idUtente;

    public Vendite(String id, String idCapo, String idUtente) {
        this.id = id;
        this.idCapo = idCapo;
        this.idUtente = idUtente;
    }

    public String getId() {
        return id;
    }

    public String getIdCapo() {
        return idCapo;
    }

    public String getIdUtente() {
        return idUtente;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", ID Capo=" + idCapo + ", ID Utente=" + idUtente;
    }

}
