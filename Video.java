/**
 * Classe per i video multimediali
 */
public class Video extends ElementoConVolume {
    private int luminosita;
    
    /**
     * Costruttore per i video
     * @param titolo il titolo del video
     * @param durata la durata del video
     * @param volume il volume del video
     * @param luminosita la luminosità del video
     */
    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata, volume);
        this.luminosita = luminosita;
    }
    
    /**
     * Aumenta la luminosità del video
     */
    public void aumentaLuminosita() {
        luminosita++;
    }
    
    /**
     * Diminuisce la luminosità del video
     */
    public void diminuisciLuminosita() {
        if (luminosita > 0) luminosita--;
    }
    
    /**
     * Riproduce il video
     */
    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + getVolumePunti() + "*".repeat(luminosita));
        }
    }
} 