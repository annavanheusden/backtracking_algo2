package ADD2;

import java.util.ArrayList;

/**
*
* @author Anna
*/
public class Oplossing {
    
    private ArrayList<Toewijzing> toewijzingen;
    
    public Oplossing(ArrayList<Toewijzing> toewijzingen) {
        this.toewijzingen = toewijzingen;
    }

    /**
     * @return the toewijzingen
     */
    public ArrayList<Toewijzing> getToewijzingen() {
        return toewijzingen;
    }

    /**
     * @param toewijzingen the toewijzingen to set
     */
    public void setToewijzingen(ArrayList<Toewijzing> toewijzingen) {
        this.toewijzingen = toewijzingen;
    }
}
