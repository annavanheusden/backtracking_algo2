package ADD2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
*
* @author Anna
*/
public class Vanheusden_Anna_Backtracking {

    public static void main(String[] args) {
        try {
            Gson gsonIn = new Gson();
            String file = "/Users/Anna/Desktop/backtracking_json_in.txt";
            if (args.length > 0) {
                file = args[0];
            }
            
            Opgave[] opgaven = gsonIn.fromJson(new FileReader(file), Opgave[].class);
            ArrayList<Optional<Oplossing>> oplossingen = new ArrayList<>();
            for(int i = 0; i < opgaven.length; i++) {
                Opgave opgave = opgaven[i];
                Optional<Oplossing> oplossing = Backtracken.start(opgave);
                oplossingen.add(oplossing);
            }            
            
            FileWriter uit = null;
            try {
                GsonBuilder bobDeBouwer = new GsonBuilder();
                bobDeBouwer.setPrettyPrinting();
                Gson gs = bobDeBouwer.create();
                uit = new FileWriter("backtracking_json_uit.txt");
                String uitString = gs.toJson(oplossingen);
                uit.write(uitString);
            } catch (IOException ex) {
                Logger.getLogger(Vanheusden_Anna_Backtracking.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                uit.close();
                } catch (IOException ex) {
                Logger.getLogger(Vanheusden_Anna_Backtracking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Vanheusden_Anna_Backtracking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
