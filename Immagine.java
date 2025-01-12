/**
 * Classe per le immagini multimediali
 */
public class Immagine extends ElementoMultimediale {
    private int luminosita;

    /**
     * Costruttore per le immagini
     * @param titolo il titolo dell'immagine
     * @param luminosita la luminosità dell'immagine
     */
    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }
    
    /**
     * Aumenta la luminosità dell'immagine
     */
    public void aumentaLuminosita() {
        luminosita++;
    }
    
    /**
     * Diminuisce la luminosità dell'immagine
     */
    public void diminuisciLuminosita() {
        if (luminosita > 0) luminosita--;
    }
    
    /**
     * Mostra l'immagine
     */
    public void show() {
        System.out.println(titolo + "*".repeat(luminosita));
    }
} 