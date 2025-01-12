    /**
 * Classe astratta per gli elementi multimediali
 */
public abstract class ElementoMultimediale {
    protected String titolo;
    
    /**
     * Costruttore per gli elementi multimediali
     * @param titolo il titolo dell'elemento
     */
    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }
    
    /**
     * Ottiene il titolo dell'elemento
     * @return il titolo dell'elemento
     */
    public String getTitolo() {
        return titolo;
    }
} 