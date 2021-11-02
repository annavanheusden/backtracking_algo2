package ADD2;

/**
*
* @author Anna
*/
public class Toewijzing {
    
    private int filosoof;
    private int plaats; 

    public Toewijzing(Filosoof filosoof, int plaats) {
        this.filosoof = filosoof.getPersoon(); 
        this.plaats = plaats; 
    }

    /**
     * @return the filosoof
     */
    public int getFilosoof() {
        return filosoof;
    }

    /**
     * @param filosoof the filosoof to set
     */
    public void setFilosoof(int filosoof) {
        this.filosoof = filosoof;
    }

    /**
     * @return the plaats
     */
    public int getPlaats() {
        return plaats;
    }

    /**
     * @param plaats the plaats to set
     */
    public void setPlaats(int plaats) {
        this.plaats = plaats;
    }

    
}
