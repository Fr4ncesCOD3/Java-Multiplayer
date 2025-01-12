public class RegistrazioneAudio extends ElementoConVolume {
    
    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo, durata, volume);
    }
    
    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + getVolumePunti());
        }
    }
} 