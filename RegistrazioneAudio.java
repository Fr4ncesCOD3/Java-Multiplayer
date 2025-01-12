/**
 * Classe per le registrazioni audio
 */
public class RegistrazioneAudio extends ElementoConVolume {
    
    /**
     * Costruttore per le registrazioni audio
     * @param titolo il titolo della registrazione audio
     * @param durata la durata della registrazione audio
     * @param volume il volume della registrazione audio
     */
    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo, durata, volume);
    }
    
    /**
     * Riproduce la registrazione audio
     */
    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + getVolumePunti());
        }
    }
} 