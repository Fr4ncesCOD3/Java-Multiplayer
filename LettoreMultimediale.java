import java.util.Scanner;

/**
 * Classe che gestisce un lettore multimediale con 5 elementi (audio, video o immagini)
 */
public class LettoreMultimediale {
    private static final int NUMERO_ELEMENTI = 5;
    private final ElementoMultimediale[] elementi;
    
    /**
     * Costruttore che inizializza l'array di elementi multimediali
     */
    public LettoreMultimediale() {
        elementi = new ElementoMultimediale[NUMERO_ELEMENTI];
    }
    
    /**
     * Inizializza gli elementi multimediali chiedendo input all'utente
     */
    public void eseguiProgramma() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n=== LETTORE MULTIMEDIALE ===");
            System.out.println("Prima dovrai inserire 5 elementi multimediali, poi potrai riprodurli.");
            System.out.println("- Gli Audio hanno volume (rappresentato da !) e durata");
            System.out.println("- I Video hanno volume (!), luminosità (*) e durata");
            System.out.println("- Le Immagini hanno solo luminosità (*)");
            System.out.println("\nPremi INVIO per iniziare...");
            scanner.nextLine();
            
            inizializza(scanner);
            System.out.println("\n=== RIPRODUZIONE ===");
            System.out.println("Ora puoi riprodurre gli elementi che hai inserito:");
            System.out.println("- Gli Audio ripetono il titolo con i ! del volume per la durata impostata");
            System.out.println("- I Video ripetono il titolo con ! (volume) e * (luminosità) per la durata");
            System.out.println("- Le Immagini mostrano il titolo con gli * della luminosità una sola volta");
            System.out.println("\nPremi INVIO per continuare...");
            scanner.nextLine();
            
            esegui(scanner);
        }
    }
    
    /**
     * Inizializza gli elementi multimediali chiedendo input all'utente
     */
    private void inizializza(Scanner scanner) {
        System.out.println("\n=== INSERIMENTO ELEMENTI ===");
        // Inizializza gli elementi multimediali: per ogni elemento, chiede il tipo e crea l'elemento corrispondente
        for (int i = 0; i < NUMERO_ELEMENTI; i++) {
            try {
                System.out.println("\nElemento " + (i + 1));
                System.out.println("Che tipo di elemento vuoi creare? (1=Audio, 2=Video, 3=Immagine)");
                
                // Validazione input tipo elemento
                while (!scanner.hasNextInt()) {
                    System.out.println("Per favore, inserisci un numero valido (1, 2 o 3)");
                    scanner.next();
                }
                int tipo = scanner.nextInt();
                scanner.nextLine(); // Consuma il newline
                
                // Verifica che il tipo sia valido
                while (tipo < 1 || tipo > 3) {
                    System.out.println("Tipo non valido. Inserisci 1 per Audio, 2 per Video, 3 per Immagine");
                    tipo = scanner.nextInt();
                    scanner.nextLine();
                }
                
                System.out.println("Inserisci il titolo:");
                String titolo = scanner.nextLine();
                
                // Creazione dell'elemento in base al tipo scelto
                switch (tipo) {
                    case 1 -> { // Audio
                        System.out.println("Inserisci la durata:");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Per favore, inserisci un numero valido per la durata");
                            scanner.next();
                        }
                        int durataAudio = scanner.nextInt();
                        
                        System.out.println("Inserisci il volume:");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Per favore, inserisci un numero valido per il volume");
                            scanner.next();
                        }
                        int volumeAudio = scanner.nextInt();
                        elementi[i] = new RegistrazioneAudio(titolo, durataAudio, volumeAudio);
                    }
                    case 2 -> { // Video
                        System.out.println("Inserisci la durata:");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Per favore, inserisci un numero valido per la durata");
                            scanner.next();
                        }
                        int durataVideo = scanner.nextInt();
                        
                        System.out.println("Inserisci il volume:");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Per favore, inserisci un numero valido per il volume");
                            scanner.next();
                        }
                        int volumeVideo = scanner.nextInt();
                        
                        System.out.println("Inserisci la luminosità:");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Per favore, inserisci un numero valido per la luminosità");
                            scanner.next();
                        }
                        int luminositaVideo = scanner.nextInt();
                        elementi[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                    }
                    case 3 -> { // Immagine
                        System.out.println("Inserisci la luminosità:");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Per favore, inserisci un numero valido per la luminosità");
                            scanner.next();
                        }
                        int luminositaImg = scanner.nextInt();
                        elementi[i] = new Immagine(titolo, luminositaImg);
                    }
                }
                scanner.nextLine(); // Consuma eventuali newline residui
                
            } catch (Exception e) {
                System.out.println("Si è verificato un errore. Riprova per questo elemento.");
                scanner.nextLine(); // Pulisce il buffer
                i--; // Ripete l'iterazione corrente
            }
        }
    }
    
    /**
     * Esegue gli elementi multimediali in base alla scelta dell'utente
     */
    private void esegui(Scanner scanner) {
        System.out.println("\nElementi disponibili:");
        for (int i = 0; i < NUMERO_ELEMENTI; i++) {
            String tipo = elementi[i] instanceof RegistrazioneAudio ? "Audio" :
                         elementi[i] instanceof Video ? "Video" :
                         elementi[i] instanceof Immagine ? "Immagine" : "Non inizializzato";
            System.out.printf("%d. %s: %s%n", i + 1, tipo, 
                elementi[i] != null ? elementi[i].getTitolo() : "---");
        }
        
        int scelta;
        do {
            System.out.println("\nScegli un elemento da riprodurre (1-5) o 0 per uscire");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Per favore, inserisci un numero tra 0 e 5");
                scanner.next();
            }
            scelta = scanner.nextInt();

            if (scelta >= 1 && scelta <= NUMERO_ELEMENTI) {
                System.out.println("\n=== RIPRODUZIONE ELEMENTO " + scelta + " ===");
                ElementoMultimediale elemento = elementi[scelta - 1];
                if (elemento == null) {
                    System.out.println("Errore: elemento non inizializzato!");
                } else if (elemento instanceof Riproducibile riproducibile) {
                    riproducibile.play();
                } else if (elemento instanceof Immagine immagine) {
                    immagine.show();
                }
                System.out.println("=== FINE RIPRODUZIONE ===\n");
            } else if (scelta != 0) {
                System.out.println("Errore: scelta non valida! Inserisci un numero tra 0 e 5");
            }
        } while (scelta != 0);
        
        System.out.println("\nGrazie per aver usato il Lettore Multimediale!");
    }
    
    public static void main(String[] args) {
        LettoreMultimediale lettore = new LettoreMultimediale();
        lettore.eseguiProgramma();
    }
}