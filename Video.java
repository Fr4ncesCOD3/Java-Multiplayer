public class Video extends ElementoConVolume {
    private int luminosita;
    
    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata, volume);
        this.luminosita = luminosita;
    }
    
    public void aumentaLuminosita() {
        luminosita++;
    }
    
    public void diminuisciLuminosita() {
        if (luminosita > 0) luminosita--;
    }
    
    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + getVolumePunti() + "*".repeat(luminosita));
        }
    }
} 