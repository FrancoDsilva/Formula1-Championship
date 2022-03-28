package company;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
public class consloe {
    static Formula1ChampionshipManager formula1ChampionshipManager=new Formula1ChampionshipManager();
    static GUI gui=new GUI();


    public static void menu() {
        System.out.println("..........Formula1 Menu..............");
        System.out.println("_____________________________________");
        System.out.println("Press 1 :Add a Driver to a Team");
        System.out.println("Press 2 :Delete Driver and the team");
        System.out.println("Press 3 :Change Existing team");
        System.out.println("Press 4 :Display Statistics");
        System.out.println("Press 5 :Display Table");
        System.out.println("Press 6 :Enter race results");
        System.out.println("Press 7 :Save files");
        System.out.println("Press 8 :Open GUI");
        System.out.println("Press 9 :Exist");
        System.out.println("------------------------------------");
    }

    Scanner input = new Scanner(System.in);

    public void menulsit() {


        menu();
        String instruct;
        instruct = input.next();
        while (instruct!="9") {
            if (instruct.equals("1")) {
                driverinput();   /*calling method for add driver*/
                menulsit();

            } else if (instruct.equals("2")) {
                deleteinput();/*call methods for delete driver*/
                menulsit();

            } else if (instruct.equals("3")) {
               formula1ChampionshipManager.changeteams();/*call methods for exsisiting driver*/
                menulsit();

            } else if (instruct.equals("4")) {
                display_statistics();/*call methods for display driver details*/
                    menulsit();

            } else if (instruct.equals("5")) {
                    formula1ChampionshipManager.displaytable();
                    menulsit();
            } else if (instruct.equals("6")) {
                formula1ChampionshipManager.racedata();
                menulsit();
            } else if (instruct.equals("7")) {
                formula1ChampionshipManager.savedetails();
                menulsit();
            } else if (instruct.equals("8")) {
                //tb.Table();
               // TableGUI.;
                gui.menu_window();
                menulsit();


            } else if (instruct.equals("9")) {
                exit();

            }
            else {
                System.out.println("Wrong Input");
                menulsit();
            }
        }


    }

    private void driverinput() {
        String new_name;
        System.out.print("Enter Driver's Name:");
        new_name = input.next();
        while (true) {
            String samename = "none";
            for (Formula1driver formula1driver : Formula1ChampionshipManager.drivernames) {
                if (formula1driver.getName().equals(new_name)) {
                    samename = "repeated_name";
                    break;
                }
            }
            if (samename == "repeated_name") {
                System.out.println("Name is Already Added.Try a different name....");
                System.out.print("Reenter name:");
                new_name = input.next();

            } else {
                break;
            }
        }
            System.out.print("Enter Driver's Team Name:");
            String driver_team=input.next();


            while (true) {
                String same_team = "none";
                for (Formula1driver formula1driver : Formula1ChampionshipManager.drivernames) {
                    if (formula1driver.getDriverteam().equals(driver_team)) {
                        same_team = "repeated_name";
                        break;
                    }
                }
                if (same_team == "repeated_name") {
                    System.out.println("Team is Already Added.Try a different name....");
                    System.out.print("Reenter name:");
                    driver_team = input.next();

                } else {
                    break;
                }
            }


            System.out.print("Enter Driver Location:");
            String driver_location=input.next();
            Formula1driver f1=new Formula1driver(new_name,driver_location,driver_team);
            formula1ChampionshipManager.addDriver(f1);





    }
    private void deleteinput(){
        String delete_name;
        System.out.print("Enter Driver's Name:");
        delete_name = input.next();
        while (true) {
            String samename = "none";
            for (Formula1driver formula1driver : Formula1ChampionshipManager.drivernames) {
                if (formula1driver.getName().equals(delete_name)) {
                    samename = "repeated_name";
                    break;
                }
            }
            if (!samename.equals("repeated_name") ) {
                System.out.println("There is no name similar to this..");
                System.out.print("Reenter name:");
                delete_name=input.next();



            }
            else {
                break;
            }

        }


       formula1ChampionshipManager.deleteDriver(delete_name);



    }
    private void display_statistics(){
        String data;
        System.out.print("Enter Driver's Name:");
        data = input.next();
        while (true) {
            String samename = "none";
            for (Formula1driver formula1driver : Formula1ChampionshipManager.drivernames) {
                if (formula1driver.getName().equals(data)) {
                    samename = "repeated_name";
                    break;
                }
            }
            if (!samename.equals("repeated_name") ) {
                System.out.println("Name is Already Added.Try a different name....");
                System.out.print("ReEnter name:");
                data = input.next();


            } else {
                break;
            }
        }
        formula1ChampionshipManager.displayStats(data);

    }
    public void exit(){
        System.out.println("Programm Exited...");
        System.exit(-1);

    }



}

