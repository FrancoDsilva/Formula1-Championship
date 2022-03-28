package company;

import java.io.IOException;

public class main {

    public static void main(String args []) throws IOException {

        Formula1ChampionshipManager fobj=new Formula1ChampionshipManager();
        fobj.recoverstats();/*recover data*/
        consloe c1=new consloe();
        c1.menulsit(); /*Calling console method to show option*/
        new GUI(); /*calling main interface*/




    }
}
