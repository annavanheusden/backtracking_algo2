package ADD2;

import java.util.ArrayList;
import java.util.Optional;

/**
*
* @author Anna
*/
public class Backtracken {
    
    private static ArrayList<Filosoof> filosofen;
    
    public static Optional<Oplossing> start(Opgave opgave) {
        filosofen = opgave.getFilosofen();
        return toewijzen(new Oplossing(new ArrayList<>()), 1, 0) ;
    }
    
    /**
     * Methode voor recursief toewijzen van filosofen aan plaatsen
     * @param huidigeOplossing
     * @param nummer
     * @param plaats
     * @return 
     */
    public static Optional<Oplossing> toewijzen(Oplossing huidigeOplossing, int nummer, int plaats) {
        if(huidigeOplossing.getToewijzingen().size() == filosofen.size()) {
            return Optional.of(huidigeOplossing);
        }
        else {
            Filosoof filosoof = getFilosoofOpNummer(nummer);
            
            if(!isVrij(plaats, huidigeOplossing)) {
                if(plaats == filosofen.size() - 1) {
                    return backtracken(huidigeOplossing);
                }
                else {
                    return toewijzen(huidigeOplossing, nummer, plaats+1);
                }
            }
            else {
                if(!isVrienden(filosoof, plaats, huidigeOplossing)) {
                    if(plaats == filosofen.size() - 1) {
                        return backtracken(huidigeOplossing);
                    }
                    else {
                        return toewijzen(huidigeOplossing, nummer, plaats+1);
                    }
                }
                else {
                    Toewijzing toewijzing = new Toewijzing(filosoof, plaats);
                    huidigeOplossing.getToewijzingen().add(toewijzing);
                    return toewijzen(huidigeOplossing, nummer+1, 0);
                }
            }
        }
    }
    /**
     * Methode om te controleren of de plaats al dan niet vrij is
     * @param plaats
     * @param huidigeOplossing
     * @return 
     */
    public static boolean isVrij(int plaats, Oplossing huidigeOplossing) {
        for(Toewijzing toewijzing: huidigeOplossing.getToewijzingen()) {
            if(toewijzing.getPlaats() == plaats) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Methode om te controleren of de filosoof op een bepaalde plaats mag zitten
     * @param filosoof
     * @param plaats
     * @param huidigeOplossing
     * @return 
     */
    public static boolean isVrienden(Filosoof filosoof, int plaats, Oplossing huidigeOplossing) {        
        int max = filosofen.size() - 1;
        int plaatsRechts = plaats + 1;
        if(plaatsRechts > max) {
            plaatsRechts = 0;
        }
        int plaatsLinks = plaats - 1;
        if (plaatsLinks < 0) {
            plaatsLinks = max;
        }
        
        Filosoof huidigeFilosoof = filosoof;
        Filosoof linkseFilosoof = getFilosoofOpPlaats(plaatsLinks, huidigeOplossing);
        Filosoof rechtseFilosoof = getFilosoofOpPlaats(plaatsRechts, huidigeOplossing);
        
        if(linkseFilosoof != null) {
            if(huidigeFilosoof.getNietvrienden().contains(linkseFilosoof.getPersoon())) {
                return false;
            }
            else if(linkseFilosoof.getNietvrienden().contains(huidigeFilosoof.getPersoon())){
                return false;
            } 
        }
        if(rechtseFilosoof != null) {
            if(huidigeFilosoof.getNietvrienden().contains(rechtseFilosoof.getPersoon())) {
                return false;
            }
            else if(rechtseFilosoof.getNietvrienden().contains(huidigeFilosoof.getPersoon())) {
                return false;
            } 
        }
               
        
        return true;
    }
    
    /**
     * Methode om filosoof op nummer te zoeken
     * @param nummer
     * @return 
     */
    public static Filosoof getFilosoofOpNummer(int nummer) {
        for(Filosoof f: filosofen) {
            if(f.getPersoon() == nummer) {
                return f;    
            }
        }
        return null;
    }
    
    /**
     * Methode te kijken welke filosoof op bepaalde plaats zit
     * @param plaats
     * @param huidigeOplossing
     * @return 
     */
    public static Filosoof getFilosoofOpPlaats(int plaats, Oplossing huidigeOplossing) {
        for(Toewijzing t: huidigeOplossing.getToewijzingen()) {
            if(t.getPlaats() == plaats) {
                return getFilosoofOpNummer(t.getFilosoof());
            }
        }
        return null;
    }
    
    /**
     * Methode voor backtracken 
     * @param huidigeOplossing
     * @return 
     */
    public static Optional<Oplossing> backtracken(Oplossing huidigeOplossing) {
        if(huidigeOplossing.getToewijzingen().isEmpty()) {
            return Optional.empty();
        }
        
        Toewijzing laatsteToewijzing = huidigeOplossing.getToewijzingen().get(huidigeOplossing.getToewijzingen().size() - 1);
        int nummer = laatsteToewijzing.getFilosoof();
        int plaats = laatsteToewijzing.getPlaats();

        if(plaats == filosofen.size() - 1) {
            huidigeOplossing.getToewijzingen().remove(laatsteToewijzing);
            return backtracken(huidigeOplossing);
        }
        else {
            huidigeOplossing.getToewijzingen().remove(laatsteToewijzing);
            return toewijzen(huidigeOplossing, nummer, plaats+1);    
        }        
    }
}
