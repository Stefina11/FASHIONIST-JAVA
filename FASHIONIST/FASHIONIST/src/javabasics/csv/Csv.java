package javabasics.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javabasics.model.Capi;
import javabasics.model.Vendite;
import javabasics.model.Utenti;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Csv {
    // ........................lettura file csv.....................

    // lettura csv capi_

    public static List<Map<String, Capi>> leggiFileCsvCapi(InputStream inputStream) throws IOException {
        List<Map<String, Capi>> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            String[] headers = null;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] values = line.split(";");

                    if (headers == null) {
                        headers = values;
                    } else {
                        if (values.length >= 7 && !values[0].isEmpty()) {

                            Capi capo = new Capi(
                                    values[0],
                                    values[1],
                                    values[2],
                                    values[3],
                                    values[4],
                                    values[5],
                                    values[6]);

                            Map<String, Capi> row = new HashMap<>();
                            row.put("ID", capo); // Memorizza l'ID come chiave separata
                            // row.put(capo.getId(), capo);
                            rows.add(row);
                        }
                    }
                }
            }
        }

        return rows;
    }

    // lettura csv vendite

    public List<Map<String, Vendite>> leggiFileCsvVendite(InputStream inputStream) throws IOException {
        List<Map<String, Vendite>> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            String[] headers = null;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] values = line.split(";");

                    if (headers == null) {
                        headers = values;
                    } else {
                        if (values.length >= 3 && !values[0].isEmpty()) {
                            Vendite vendita = new Vendite(
                                    values[0],
                                    values[1],
                                    values[2]);

                            Map<String, Vendite> row = new HashMap<>();
                            row.put("ID", vendita); // Memorizza l'ID come chiave separata
                            // row.put(capo.getId(), capo);
                            rows.add(row);
                        }
                    }
                }
            }
        }

        return rows;
    }

    // lettura csv utenti
    public List<Map<String, Utenti>> leggiFileCsvUtenti(InputStream inputStream) throws IOException {
        List<Map<String, Utenti>> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            String[] headers = null;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] values = line.split(";");

                    if (headers == null) {
                        headers = values;
                    } else {
                        if (values.length >= 6 && !values[0].isEmpty()) {
                            Utenti utente = new Utenti(
                                    values[0],
                                    values[1],
                                    values[2],
                                    values[3],
                                    values[4],
                                    values[5]);

                            Map<String, Utenti> row = new HashMap<>();
                            row.put("ID", utente); // Memorizza l'ID come chiave separata
                            rows.add(row);
                        }
                    }
                }
            }
        }

        return rows;
    }

    // ---------------------------SCRITTURA FILE CSV---------------------------

    public static void scriviCapi(String fileCapi, List<Map<String, Capi>> capi) throws IOException {
        try (FileWriter writer = new FileWriter(fileCapi)) {
            // Scrivi l'intestazione
            writer.write("ID;Data inserimento;Tipologia;Marca;Taglia;Prezzo;Disponibile\n");

            // Scrivi le righe
            for (Map<String, Capi> riga : capi) {
                List<String> valori = new ArrayList<>();
                for (Capi capo : riga.values()) {
                    valori.add(capo.getId());
                    valori.add(capo.getDate());
                    valori.add(capo.getType());
                    valori.add(capo.getMarca());
                    valori.add(capo.getTaglia());
                    valori.add(capo.getPrezzo());
                    valori.add(capo.getDisp());
                }
                writer.write(String.join(";", valori) + "\n");
            }
        }
    }

    public static void scriviVendite(String fileVendite, List<Map<String, Vendite>> vendite) throws IOException {
        try (FileWriter writer = new FileWriter(fileVendite)) {
            // Scrivi l'intestazione
            writer.write("ID;Id Capo; ID Utente\n");

            // Scrivi le righe
            for (Map<String, Vendite> riga : vendite) {
                List<String> valori = new ArrayList<>();
                for (Vendite vendita : riga.values()) {
                    valori.add(vendita.getId());
                    valori.add(vendita.getIdCapo());
                    valori.add(vendita.getIdUtente());
                }
                writer.write(String.join(";", valori) + "\n");
            }
        }
    }

    public static void scriviUtenti(String fileUtenti, List<Map<String, Utenti>> utenti) throws IOException {
        try (FileWriter writer = new FileWriter(fileUtenti)) {
            // Scrivi l'intestazione
            writer.write("ID;Nome;Cognome;Data di Nascita;Indirizzo;Documento ID\n");

            // Scrivi le righe
            for (Map<String, Utenti> riga : utenti) {
                List<String> valori = new ArrayList<>();
                for (Utenti utente : riga.values()) {
                    valori.add(utente.getId());
                    valori.add(utente.getNome());
                    valori.add(utente.getCognome());
                    valori.add(utente.getData());
                    valori.add(utente.getIndirizzo());
                    valori.add(utente.getIdDoc());
                }
                writer.write(String.join(";", valori) + "\n");
            }
        }
    }

    // --------------------------VERIFICHE ID------------------------------

    public static Map<String, Capi> verificaIdCapo(int id, List<Map<String, Capi>> capi) {

        String idStringa = String.valueOf(id);
        for (Map<String, Capi> capo : capi) {
            // System.out.println("Sto verificando la riga: " + capo);

            for (String key : capo.keySet()) {
                if (key.equals("ID")) {
                    Capi capoCapi = capo.get(key);
                    if (capoCapi != null && capoCapi.getId().equals(idStringa)) {
                        // System.out.println("dati inseriti ok");
                        return capo;
                    }
                }
            }
        }
        System.out.println("dati inseriti errati. Si prega di inserire un valore corretto");

        return null;
    }

    public static Map<String, Utenti> verificaIdUtente(int id, List<Map<String, Utenti>> utenti) {

        String idStringa = String.valueOf(id);
        for (Map<String, Utenti> utente : utenti) {
            // System.out.println("Sto verificando la riga: " + utente);

            for (String key : utente.keySet()) {
                if (key.equals("ID")) {
                    Utenti utenteUtenti = utente.get(key);
                    if (utenteUtenti != null && utenteUtenti.getId().equals(idStringa)) {
                        // System.out.println("dati inseriti ok");
                        return utente;
                    }
                }
            }
        }
        System.out.println("dati inseriti errati. Si prega di inserire un valore corretto");

        return null;
    }

    public static Map<String, Vendite> verificaIdVendita(int id, List<Map<String, Vendite>> vendite) {
        String idStringa = String.valueOf(id);
        for (Map<String, Vendite> vendita : vendite) {
            // System.out.println("Sto verificando la riga: " + vendita);

            for (String key : vendita.keySet()) {
                if (key.equals("ID")) {
                    Vendite venditaVendite = vendita.get(key);
                    if (venditaVendite != null && venditaVendite.getId().equals(idStringa)) {
                        // System.out.println("dati inseriti ok");
                        return vendita;
                    }
                }
            }
        }
        System.out.println("dati inseriti errati. Si prega di inserire un valore corretto");

        return null;
    }

    // ------------------ACQUISTO CAPO------------------------
    public static void setDisponibileNo(List<Map<String, Capi>> capi, Map<String, Capi> riga, String fileCapi) {

        Capi capo = riga.get("ID");
        String disponibilita = capo.getDisp();

        if (disponibilita.equals("SI")) {
            capo.setDisponibilita("NO");
            System.out.println("l'acquisto del capo è avvenuto con successo");
            // System.out.println(capo);

            try {
                scriviCapi(fileCapi, capi);
            } catch (IOException e) {
                System.out.println("Errore durante la scrittura del file: " + e.getMessage());
            }
        } else {
            System.out.println("il capo non è disponibile alla vendita");
        }

    }

    // metodo per aggiungere nuova riga di vendita.

    public static void aggiungiVendita(List<Map<String, Vendite>> vendite, int idCapo, int idUtente,
            String fileVendite) {
        Map<String, Vendite> row = new HashMap<>();
        int newIdVendita = creaNuovoId(vendite);
        String idVendita = String.valueOf(newIdVendita);
        String idCapoStr = String.valueOf(idCapo);
        String idUtenteStr = String.valueOf(idUtente);
        row.put("ID", new Vendite(idVendita, idCapoStr, idUtenteStr));
        vendite.add(row);

        try {
            scriviVendite(fileVendite, vendite);
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }

    // metodo per estrarre tutti gli id della lista vendite
    public static ArrayList<String> estraiIds(List<Map<String, Vendite>> vendite) {
        ArrayList<String> ids = new ArrayList<>();

        for (Map<String, Vendite> riga : vendite) {
            for (Vendite vendita : riga.values()) {
                String id = vendita.getId();
                ids.add(id);
            }
        }
        // System.out.println("Contenuto della lista ids:");
        // for (String id : ids) {
        // System.out.println(id);
        // }
        return ids;
    }

    // metodo per trovare il massimo id di una lista
    public static int trovaIdMax(ArrayList<String> ids) {
        ArrayList<Integer> idsInt = new ArrayList<>();

        for (String id : ids) {
            int idNumerico = Integer.parseInt(id);
            idsInt.add(idNumerico);
        }

        int max = idsInt.get(0);
        for (int idInt : idsInt) {
            if (idInt > max) {
                max = idInt;
            }
        }
        return max;
    }

    // metodo per incrementare e definire il nuovo id
    public static int creaNuovoId(List<Map<String, Vendite>> vendite) {
        ArrayList<String> idVendite = estraiIds(vendite);
        int idMax = trovaIdMax(idVendite);
        int nuovoId = idMax + 1;
        return nuovoId;
    }

    // --------------------------------RESO-------------------------------------------------------
    // metodo per rimuovere riga di vendita

    public static void rimuoviRigaVendita(Map<String, Vendite> rigaVendita, List<Map<String, Vendite>> vendite,
            String fileVendite) {
        List<Map<String, Vendite>> venditeTemp = new ArrayList<>(vendite); // Creo copia di lista vendite
        Iterator<Map<String, Vendite>> iterator = venditeTemp.iterator();
        while (iterator.hasNext()) {
            Map<String, Vendite> venditaTemp = iterator.next();
            if (venditaTemp.equals(rigaVendita)) {
                iterator.remove(); // rimuovo con iterator
                // System.out.println("La vendita " + venditaTemp + " è stata rimossa");
            }
        }
        vendite.clear();
        vendite.addAll(venditeTemp);
        try {
            scriviVendite(fileVendite, vendite);
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }

    //// metodo per trovare idcapo corrispondente sulla lista capi
    public static Map<String, Capi> trovaRigaPerID(String id, List<Map<String, Capi>> lista) {
        for (Map<String, Capi> mappa : lista) {
            for (Map.Entry<String, Capi> entry : mappa.entrySet()) {
                // System.out.println("Verificando capo con ID: " + entry.getValue().getId());
                // // Stampa l'ID del capo
                if (entry.getValue().getId().equals(id)) {
                    // System.out.println("ID trovato in lista");
                    return mappa;
                }
            }
        }
        System.out.println("ID non trovato.");
        return null;
    }

    // metodo per settare di nuovo il si sulla disponibilità del capo
    public static void setDisponibileSi(List<Map<String, Capi>> capi, Map<String, Capi> riga, String fileCapi) {

        Capi capo = riga.get("ID");
        String disponibilita = capo.getDisp();

        if (disponibilita.equals("NO")) {
            capo.setDisponibilita("SI");
            System.out.println("Il capo è di nuovo disponibile alla vendita");
            // System.out.println(capo);

            try {
                scriviCapi(fileCapi, capi);
                ;
            } catch (IOException e) {
                System.out.println("Errore durante la scrittura del file: " +
                        e.getMessage());
            }
        }

    }

    // --------------------------------AGGIUNTA UTENTE-----------------------------

    public static void aggiungiUtente(List<Map<String, Utenti>> utenti, String nome, String cognome, String data,
            String indirizzo,
            String documento, String fileUtenti) {

        Map<String, Utenti> row = new HashMap<>();
        int newIdUtente = creaNuovoIdUtente(utenti);
        String idUtente = String.valueOf(newIdUtente);

        row.put("ID", new Utenti(idUtente, nome, cognome, data, indirizzo, documento));
        utenti.add(row);
        System.out.println("L'utente è stato registrato con successo.");

        try {
            scriviUtenti(fileUtenti, utenti);
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }

    // metodo per estrarre tutti gli id della lista utenti
    public static ArrayList<String> estraiIdsUtenti(List<Map<String, Utenti>> utenti) {
        ArrayList<String> ids = new ArrayList<>();

        for (Map<String, Utenti> riga : utenti) {
            for (Utenti utente : riga.values()) {
                String id = utente.getId();
                ids.add(id);
            }
        }
        // System.out.println("Contenuto della lista ids:");
        // for (String id : ids) {
        // System.out.println(id);
        // }
        return ids;
    }

    // metodo per incrementare e definire il nuovo id
    public static int creaNuovoIdUtente(List<Map<String, Utenti>> utenti) {
        ArrayList<String> idUtenti = estraiIdsUtenti(utenti);
        int idMax = trovaIdMax(idUtenti);
        int nuovoId = idMax + 1;
        return nuovoId;
    }

    // ---------------------------------------------------------------------------------------------------------

    // metodo per creare lista capi disponibili e file csv

    public static void creaFileCsv(List<Map<String, Capi>> lista) throws IOException {
        List<Map<String, Capi>> listaCapiDisponibili = new ArrayList<>();

        for (Map<String, Capi> capo : lista) {
            Capi capoDisp = capo.get("ID");
            String disponibile = capoDisp.getDisp();
            if (disponibile.equals("SI")) {
                listaCapiDisponibili.add(capo);
            }
        }
        // creo file csv
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HHmmss");
        String dataCorrente = sdf.format(new Date());
        String nomeFile = "capi_" + dataCorrente + ".csv";

        try (FileWriter writer = new FileWriter(nomeFile)) {

            writer.append("ID;Data inserimento;Tipologia;Taglia;Prezzo;Marca;Disponibile\n"); // intestazione
            //
            for (Map<String, Capi> riga : listaCapiDisponibili) {
                StringBuilder rigaStringBuilder = new StringBuilder();
                for (Capi valore : riga.values()) {
                    rigaStringBuilder.append(valore.getId()).append(";");
                    rigaStringBuilder.append(valore.getDate()).append(";");
                    rigaStringBuilder.append(valore.getType()).append(";");
                    rigaStringBuilder.append(valore.getMarca()).append(";");
                    rigaStringBuilder.append(valore.getTaglia()).append(";");
                    rigaStringBuilder.append(valore.getPrezzo()).append(";");
                    rigaStringBuilder.append(valore.getDisp()).append(";");
                }
                writer.append(rigaStringBuilder.toString().replaceAll(";$", "")).append("\n");
            }
        }
        // Apre il file CSV creato
        File file = new File(nomeFile);
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
        }
    }

}
