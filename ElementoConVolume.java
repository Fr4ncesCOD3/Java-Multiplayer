/**
 * Classe astratta per gli elementi multimediali con volume
 */
public abstract class ElementoConVolume extends ElementoMultimediale implements Riproducibile {
    protected int volume;
    protected int durata;
    
    /**
     * Costruttore per gli elementi con volume
     * @param titolo il titolo dell'elemento
     * @param durata la durata dell'elemento
     * @param volume il volume dell'elemento
     */
    public ElementoConVolume(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }
    
    /**
     * Aumenta il volume dell'elemento
     */
    public void alzaVolume() {
        volume++;
    }
    
    /**
     * Abbatte il volume dell'elemento
     */
    public void abbassaVolume() {
        if (volume > 0) volume--;
    }
    
    /**
     * Ottiene la rappresentazione del volume in punti
     * @return la rappresentazione del volume in punti
     */
    protected String getVolumePunti() {
        return "!".repeat(volume);
    }
} 