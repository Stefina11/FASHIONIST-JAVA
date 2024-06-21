package javabasics.input;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Input {

    public static void printToConsole() {
        System.out.println(" ");
        System.out.println("Enter 1 = VISUALIZZA CAPI");
        System.out.println("Enter 2 = COMPRA CAPO");
        System.out.println("Enter 3 = RENDI CAPO");
        System.out.println("Enter 4 = AGGIUNGI NUOVO UTENTE");
        System.out.println("Enter 5 = ESPORTA FILE CAPI DISPONIBILI");
        System.out.println("Enter 0 = ESCI");
    }

    public int getInput() {
        System.out.println("inserire il numero dell'azione da intraprendere:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int numberInt = Integer.parseInt(number);
        return numberInt;
    }

    public int getInputCapo() {
        System.out.println("inserire l'id del capo che si vuole acquistare:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int numberInt = Integer.parseInt(number);
        return numberInt;
    }

    public int getInputUtente() {
        System.out.println("inserire l'id dell'utente che effettua l'acquisto:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int numberInt = Integer.parseInt(number);
        return numberInt;
    }

    public int getInputVendita() {
        System.out.println("inserire l'id di vendita del prodotto di cui effettuare il reso:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int numberInt = Integer.parseInt(number);
        return numberInt;
    }

    public String getInputNome() {
        System.out.println("inserire il nome:");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        return nome;
    }

    public String getInputCognome() {
        System.out.println("inserire il cognome:");
        Scanner scanner = new Scanner(System.in);
        String cognome = scanner.nextLine();
        return cognome;
    }

    public String getInputData() {
        System.out.println("Inserire la data di nascita (formato dd/MM/yyyy):");
        Scanner scanner = new Scanner(System.in);
        String dataString = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        Date data = null;

        try {
            data = sdf.parse(dataString);
        } catch (ParseException e) {
            System.out.println("Formato data non valido. Riprova.");
            return getInputData(); // Richiedi nuovamente l'input in caso di formato non valido
        }
        // Converti nuovamente la data in una stringa nel formato desiderato
        SimpleDateFormat sdfOutput = new SimpleDateFormat("dd/MM/yyyy");
        return sdfOutput.format(data);

    }

    public String getInputIndirizzo() {
        System.out.println("inserire l'indirizzo di residenza:");
        Scanner scanner = new Scanner(System.in);
        String indirizzo = scanner.nextLine();
        return indirizzo;
    }

    public String getInputDocumento() {
        System.out.println("inserire il numero di documento:");
        Scanner scanner = new Scanner(System.in);
        String documento = scanner.nextLine();
        return documento;
    }

}
