public abstract class ElementoConVolume extends ElementoMultimediale implements Riproducibile {
    protected int volume;
    protected int durata;
    
    public ElementoConVolume(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }
    
    public void alzaVolume() {
        volume++;
    }
    
    public void abbassaVolume() {
        if (volume > 0) volume--;
    }
    
    protected String getVolumePunti() {
        return "!".repeat(volume);
    }
} 