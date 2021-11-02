package ADD2;

import java.util.ArrayList;

/**
*
* @author Anna
*/
public class Opgave {
    
    private ArrayList<Filosoof> invoer;

    public Opgave(ArrayList<Filosoof> filosofen) {
        this.invoer = filosofen;
    }

    /**
     * @return the invoer
     */
    public ArrayList<Filosoof> getFilosofen() {
        return invoer;
    }

    /**
     * @param filosofen the invoer to set
     */
    public void setFilosofen(ArrayList<Filosoof> filosofen) {
        this.invoer = filosofen;
    } 
}
