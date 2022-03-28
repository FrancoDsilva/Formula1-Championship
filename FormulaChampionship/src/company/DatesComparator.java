package company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static company.Formula1ChampionshipManager.drivernames;

public class DatesComparator {

    public void sortGUI() {
        ArrayList <String> dateAr=new ArrayList<>();

        for (Formula1driver formula1driver : drivernames){
            dateAr.add(formula1driver.getDatestore());

        }
        for (String counter : dateAr) {
            System.out.println(counter);
        }

        /* Sorting of arraylist using Collections.sort*/
        Collections.sort(dateAr);

    }

}
//references---->https://www.geeksforgeeks.org/comparator-interface-java/

