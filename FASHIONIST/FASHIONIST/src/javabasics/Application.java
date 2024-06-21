package javabasics;

import java.util.List;
import javabasics.csv.Csv;
import javabasics.input.Input;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javabasics.model.Capi;
import javabasics.model.Vendite;
import javabasics.model.Utenti;

public class Application {

    public static void main(String[] args) throws IOException {

        System.out.println("Benvenuto in Fashionist");

        Csv csv = new Csv();

        InputStream capiInputStream = Application.class.getResourceAsStream("/javabasics/resource/capi.csv");
        InputStream venditeInputStream = Application.class.getResourceAsStream("/javabasics/resource/vendite.csv");
        InputStream utentiInputStream = Application.class.getResourceAsStream("/javabasics/resource/utenti.csv");
        String fileCapi = "./FASHIONIST/FASHIONIST/src/javabasics/resource/capi.csv";
        String fileVendite = "./FASHIONIST/FASHIONIST/src/javabasics/resource/vendite.csv";
        String fileUtenti = "./FASHIONIST/FASHIONIST/src/javabasics/resource/utenti.csv";

        List<Map<String, Capi>> capi = csv.leggiFileCsvCapi(capiInputStream);
        List<Map<String, Vendite>> vendite = csv.leggiFileCsvVendite(venditeInputStream);
        List<Map<String, Utenti>> utenti = csv.leggiFileCsvUtenti(utentiInputStream);
        // List<Map<String, Utenti>> utenti = csv.leggiFileCsvUtenti(fileUtenti);

        // for (Map<String, Capi> row : capi) {
        // System.out.println(row);
        // }

        // for (Map<String, Vendite> row : vendite) {
        // System.out.println(row);
        // }

        // for (Map<String, Utenti> row : utenti) {
        // System.out.println(row);
        // }

        Input input = new Input();
        int userInput;

        do {
            input.printToConsole();
            userInput = input.getInput();

            switch (userInput) {
                case 1:
                    for (Map<String, Capi> row : capi) {
                        System.out.println(row);
                    }
                    break;

                case 2:
                    int inputCapo = input.getInputCapo();
                    int inputIdUtente = input.getInputUtente();

                    Map<String, Capi> myRigaCapo = Csv.verificaIdCapo(inputCapo, capi);
                    Map<String, Utenti> myRigaUtente = Csv.verificaIdUtente(inputIdUtente,
                            utenti);
                    if (myRigaCapo == null || myRigaUtente == null) {
                        break;
                    } else {
                        Csv.setDisponibileNo(capi, myRigaCapo, fileCapi);
                        Csv.aggiungiVendita(vendite, inputCapo, inputIdUtente, fileVendite);
                    }
                    break;

                case 3:

                    int inputVendita = input.getInputVendita();
                    Map<String, Vendite> myRigaVendita = Csv.verificaIdVendita(inputVendita,
                            vendite);

                    String idCapo = "";
                    for (Vendite vendita : myRigaVendita.values()) {
                        idCapo = vendita.getIdCapo();
                        System.out.println(idCapo);
                    }

                    if (myRigaVendita == null) {
                        break;
                    } else {
                        Map<String, Capi> rigaCapo = Csv.trovaRigaPerID(idCapo, capi);
                        Csv.setDisponibileSi(capi, rigaCapo, fileCapi);
                        Csv.rimuoviRigaVendita(myRigaVendita, vendite, fileVendite);
                    }

                    break;

                case 4:
                    String inputNome = input.getInputNome();
                    String inputCognome = input.getInputCognome();
                    String inputData = input.getInputData();
                    String inputIndirizzo = input.getInputIndirizzo();
                    String inputDocumento = input.getInputDocumento();

                    csv.aggiungiUtente(utenti, inputNome, inputCognome, inputData,
                            inputIndirizzo,
                            inputDocumento, fileUtenti);

                    break;

                case 5:
                    csv.creaFileCsv(capi);
                    break;

                case 0:
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }

        } while (userInput != 0);

    }

}
