package company;

import java.io.FileNotFoundException;
import java.io.IOException;

/*Create a interface with methods that in formula championship manager*/
public interface ChampionshipManager {
    void addDriver(Formula1driver formula1driver );
    void deleteDriver(String remove);
    void changeteams();
    void displayStats(String stats);
    void displaytable();
    void racedata();
    void savedetails();
    void recoverstats() throws FileNotFoundException;

}
