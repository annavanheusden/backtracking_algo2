package ADD2;

import java.util.ArrayList;

/**
*
* @author Anna
*/
public class Filosoof {
    
    private int persoon;
    private ArrayList<Integer> nietvrienden;

    public Filosoof(int persoon, ArrayList<Integer> nietvrienden) {
        this.persoon = persoon;
        this.nietvrienden = nietvrienden;
    }

    /**
     * @return the persoon
     */
    public int getPersoon() {
        return persoon;
    }

    /**
     * @param persoon the persoon to set
     */
    public void setPersoon(int persoon) {
        this.persoon = persoon;
    }

    /**
     * @return the nietvrienden
     */
    public ArrayList<Integer> getNietvrienden() {
        return nietvrienden;
    }

    /**
     * @param nietvrienden the nietvrienden to set
     */
    public void setNietvrienden(ArrayList<Integer> nietvrienden) {
        this.nietvrienden = nietvrienden;
    }
}
