package javabasics.model;

public class Utenti {

    private String id;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String indirizzo;
    private String idDocumento;

    public Utenti(String id, String nome, String cognome, String dataNascita, String indirizzo, String idDocumento) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.indirizzo = indirizzo;
        this.idDocumento = idDocumento;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getData() {
        return dataNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getIdDoc() {
        return idDocumento;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", nome='" + nome + ", cognome=" + cognome + ", data di nascita=" + dataNascita +
                ", indirizzo=" + indirizzo + ", idDocumento=" + idDocumento + '}';

    }

}
