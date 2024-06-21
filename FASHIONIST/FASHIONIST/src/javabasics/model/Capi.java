package javabasics.model;

public class Capi {

    private String id;
    private String dataInserimento;
    private String tipologia;
    private String marca;
    private String taglia;
    private String prezzo;
    private String disponibilita;

    public Capi(String id, String dataInserimento, String tipologia, String marca, String taglia, String prezzo,
            String disponibilita) {
        this.id = id;
        this.dataInserimento = dataInserimento;
        this.tipologia = tipologia;
        this.marca = marca;
        this.taglia = taglia;
        this.prezzo = prezzo;
        this.disponibilita = disponibilita;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return dataInserimento;
    }

    public String getType() {
        return tipologia;
    }

    public String getMarca() {
        return marca;
    }

    public String getTaglia() {
        return taglia;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public String getDisp() {
        return disponibilita;
    }

    public void setDisponibilita(String disponibilita) {
        this.disponibilita = disponibilita;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", dataInserimento=" + dataInserimento + ", tipologia=" + tipologia + ", marca=" + marca +
                ", taglia=" + taglia + ", prezzo=" + prezzo + ", disponibilita=" + disponibilita + '}';

    }
}
