package company;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Formula1ChampionshipManager implements ChampionshipManager,Serializable {
    static ArrayList<Formula1driver> drivernames = new ArrayList<>();/*cretead a class call drivenames to add all data*/

    /*Variable*/
    private int firstpos=0;
    private int secondtpos=0;
    private int thirdpos=0;
    private int noOfraces=0;
    private int point=0;
    private File table=new File("file.txt");


    /*getter setters to store given data*/
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getNoOfraces() {
        return noOfraces;
    }

    public void setNoOfraces(int noOfraces) {
        this.noOfraces = noOfraces;
    }

    public int getFirstpos() {
        return firstpos;
    }

    public void setFirstpos(int firstpos) {
        this.firstpos = firstpos;
    }

    public int getSecondtpos() {
        return secondtpos;
    }

    public void setSecondtpos(int secondtpos) {
        this.secondtpos = secondtpos;
    }

    public int getThirdpos() {
        return thirdpos;
    }

    public void setThirdpos(int thirdpos) {
        this.thirdpos = thirdpos;
    }
/*---------------------------------------------------------*/
    static int maximum_no_of_teams=10;
    Scanner input = new Scanner(System.in);

    /*---------------------------add driver method-----------------------------------*/
    @Override
    public void addDriver(Formula1driver formula1driver) {
        if(maximum_no_of_teams==drivernames.size()){
            System.out.println("You reach the maximum number of teams");
        }



        else {
            drivernames.add(formula1driver);

            maximum_no_of_teams=-1;
        }
    }
    /*---------------------------method driver method-----------------------------------*/
    @Override
    public void deleteDriver(String remove) {
        if (drivernames.size() == 0) {
            System.out.println("There are no more drivers");
        } else {
            for (int i = 0; i < drivernames.size(); i++){
                if (drivernames.get(i).getName().equals(remove)){
                    System.out.println("*Deleted*");
                    drivernames.remove(i);

                    maximum_no_of_teams=+1;
                    break;
                }
            }
        }
    }
    /*---------------------------change team  method-----------------------------------*/
    @Override
    public void changeteams() {

        String Exsisting_driver;
        System.out.print("Enter Driver's Name:");
        Exsisting_driver = input.next();
        while (true) {
            String samename = "none";
            for (Formula1driver formula1driver : Formula1ChampionshipManager.drivernames) {
                if (formula1driver.getName().equals(Exsisting_driver)) {
                    samename = "repeated_name";
                    break;
                }
            }

            if (samename == "repeated_name") {
                String Newteam = "none";
                for (Formula1driver formula1driver : Formula1ChampionshipManager.drivernames) {
                    if (formula1driver.getDriverteam().equals(Newteam)) {
                        System.out.println("Please enter a different name");
                    }
                }
                System.out.println("Enter Driver's current team name: ");
                String changingTeam = input.next();

                for (Formula1driver formula1Driver : Formula1ChampionshipManager.drivernames) {
                    if (changingTeam.equals(formula1Driver.getDriverteam())) {
                        System.out.println("Enter driver's new team: ");
                        String newDriver = input.next();




                        if (!newDriver.equals(formula1Driver.getDriverteam())) {
                            System.out.println("Enter Different driver's new team: ");
                            newDriver = input.next();


                        }
                        formula1Driver.setDriverteam(newDriver);


                    }


                }
                break;
            }

        }
    }




    /*---------------------------display driver stats method-----------------------------------*/
    @Override
    public void displayStats(String stats) {
        for (Formula1driver formula1driver:drivernames){
            if (formula1driver.getName().equals(stats)){
                String Table = "| %-12.5s | %-12.5s | %-14.5s | %-12.5s | %-9.5s | %-9.5s | %-9.5s|%-12.5s | %n";
                System.out.format("_________________________________________________________________________________________________________________%n");
                System.out.format("|Driver Name   |Driver Team   |Driver Location |Driver Points |1st pos    |2nd Pos    |3rd pos   |no of race    |%n");
                System.out.format("|______________|______________|________________|______________|___________|___________|__________|______________|%n");

                System.out.format(Table,formula1driver.getName(),formula1driver.getDriverteam(),formula1driver.getLocation(),formula1driver.getPoints(),formula1driver.getNo_of_first_pos(),formula1driver.getNo_of_second_pos(),formula1driver.getNo_of_third_pos(),formula1driver.getNo_of_races());
            }
        }

    }
    /*---------------------------display table method-----------------------------------*/
    @Override
    public void displaytable() {

            String Table = "| %-12.5s | %-12.5s | %-14.5s | %-12.5s | %-9.5s | %-9.5s | %-9.5s|%-12.5s | %n";
            System.out.format("_________________________________________________________________________________________________________________%n");
            System.out.format("|Driver Name   |Driver Team   |Driver Location |Driver Points |1st pos    |2nd Pos    |3rd pos   |no of race    |%n");
            System.out.format("|______________|______________|________________|______________|___________|___________|__________|______________|%n");
            drivernames.sort(new Comparatorclass());
            for (Formula1driver formula1driver:drivernames) {
                System.out.format(Table, formula1driver.getName(), formula1driver.getDriverteam(), formula1driver.getLocation(), formula1driver.getPoints(), formula1driver.getNo_of_first_pos(), formula1driver.getNo_of_second_pos(), formula1driver.getNo_of_third_pos(), formula1driver.getNo_of_races());
        }


    }
    /*---------------------------add race method-----------------------------------*/
    @Override
    public void racedata() {
        System.out.print("Enter day:");

        int day = input.nextInt();

        if (day > 31) {
                System.out.println("Enter day below 31");
                day = input.nextInt();

            }


            System.out.print("Enter month:");
            int month = input.nextInt();
            if (month > 12) {
                System.out.println("Enter month below 12");
                month = input.nextInt();
            }
            System.out.print("Enter Year:");
            int year = input.nextInt();
            if (year < 2021) {
                System.out.println("Enter year above 2020");
                year = input.nextInt();
            }


            System.out.println("Date is" + " " + year + "/" + month + "/" + day);
            String dates=(year+"-"+month+"-"+day);




        for (Formula1driver formula1driver:drivernames){
            formula1driver.setDatestore(dates);
            System.out.println(formula1driver.getDatestore());

            for (int i=0;i<drivernames.size();i++) {
                System.out.print("Enter " + formula1driver.getName() + "'s Position:");
                break;
            }

            int raceposition=input.nextInt();
            formula1driver.setPosition(raceposition);

            if(raceposition==1){

              formula1driver.setPointper(25);
              point=formula1driver.getPoints()+formula1driver.getPointper();
              formula1driver.setPoints(point);

              formula1driver.setFirstposcount(1);
              firstpos=formula1driver.getNo_of_first_pos()+formula1driver.getFirstposcount();
              formula1driver.setNo_of_first_pos(firstpos);

              formula1driver.setRacecount(1);
              noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
              formula1driver.setNo_of_races(noOfraces);

            }else if (raceposition==2){

                formula1driver.setPointper(18);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setSecondposcount(1);
                secondtpos=formula1driver.getNo_of_second_pos()+formula1driver.getSecondposcount();
                formula1driver.setNo_of_second_pos(secondtpos);

                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);



            }else if (raceposition==3){
                formula1driver.setThirdposcount(1);
                thirdpos=formula1driver.getNo_of_third_pos()+formula1driver.getThirdposcount();
                formula1driver.setNo_of_third_pos(thirdpos);

                formula1driver.setPointper(15);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);

                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);


            }else if (raceposition==4){

                formula1driver.setPointper(12);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

            }else if (raceposition==5){

                formula1driver.setPointper(10);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

            }else if (raceposition==6){

                formula1driver.setPointper(8);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

            }else if (raceposition==7){

                formula1driver.setPointper(6);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

            }else if (raceposition==8){

                formula1driver.setPointper(4);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);;

            }else if (raceposition==9){

                formula1driver.setPointper(2);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);

                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

            }else if (raceposition==10){

                formula1driver.setPointper(1);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

            }else {
                System.out.println("Wrong Input....");
            }

        }
    }
    /*---------------------------save data method-----------------------------------*/
    @Override
    public void savedetails(){
        try {
            File tableStatFile = new File("file.txt");
            table.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ObjectOutputStream detailStore = new ObjectOutputStream(new FileOutputStream(table));
                if (drivernames.size() == 0) {
                    System.out.println("---------No Drivers Been Stored In The System---------");
                } else {
                    detailStore.writeObject(drivernames);
                    System.out.println("---The Details You Added Have Been Stored Successfully---");
                }
                detailStore.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
    /*---------------------------recover data method-----------------------------------*/
    @Override
    public void recoverstats() throws FileNotFoundException {
        try {
            File file = new File("file.txt");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ObjectInputStream recoverData = new ObjectInputStream(new FileInputStream(table));
                drivernames = (ArrayList<Formula1driver>) recoverData.readObject();
                recoverData.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.print("");
            }
        }

    }
    /*---------------------------add race method for GUI-----------------------------------*/
    public void GUIaddrace() {
        Random rand = new Random();

        int day = rand.nextInt(31);
        int month = rand.nextInt(12);
        int year = (int) (Math.random() * (2025 - 2020)) + 2020;




       // System.out.println("Date is" + " " + year + "/" + month + "/" + day);


        for (Formula1driver formula1driver:drivernames){

            String dates=(year+"-"+month+"-"+day);
            formula1driver.setDatestore(dates);




            int raceposition=(int) (Math.random() * (10 - 1)) + 1;

            if(raceposition==1){
                formula1driver.setPosition(1);

                formula1driver.setPointper(25);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);

                formula1driver.setFirstposcount(1);
                firstpos=formula1driver.getNo_of_first_pos()+formula1driver.getFirstposcount();
                formula1driver.setNo_of_first_pos(firstpos);

                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

            }else if (raceposition==2){
                formula1driver.setPosition(2);

                formula1driver.setPointper(18);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setSecondposcount(1);
                secondtpos=formula1driver.getNo_of_second_pos()+formula1driver.getSecondposcount();
                formula1driver.setNo_of_second_pos(secondtpos);

                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);



            }else if (raceposition==3){
                formula1driver.setThirdposcount(1);
                thirdpos=formula1driver.getNo_of_third_pos()+formula1driver.getThirdposcount();
                formula1driver.setNo_of_third_pos(thirdpos);

                formula1driver.setPointper(15);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);

                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

                formula1driver.setPosition(3);

            }else if (raceposition==4){

                formula1driver.setPointper(12);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);

                formula1driver.setPosition(4);

                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

            }else if (raceposition==5){

                formula1driver.setPointper(10);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

                formula1driver.setPosition(5);

            }else if (raceposition==6){

                formula1driver.setPointper(8);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

                formula1driver.setPosition(6);

            }else if (raceposition==7){

                formula1driver.setPointper(6);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

                formula1driver.setPosition(7);

            }else if (raceposition==8){

                formula1driver.setPointper(4);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

                formula1driver.setPosition(8);

            }else if (raceposition==9){

                formula1driver.setPointper(2);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);

                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

                formula1driver.setPosition(9);

            }else if (raceposition==10){

                formula1driver.setPointper(1);
                point=formula1driver.getPoints()+formula1driver.getPointper();
                formula1driver.setPoints(point);


                formula1driver.setRacecount(1);
                noOfraces=formula1driver.getNo_of_races()+formula1driver.getRacecount();
                formula1driver.setNo_of_races(noOfraces);

                formula1driver.setPosition(10);

            }else {
                System.out.println("Wrong Input....");
            }

        }
    }
    /*---------------------------position/probability method for GUI-----------------------------------*/
    public void startpos() {
        Random rand = new Random();



        for (Formula1driver formula1driver:drivernames){
            int startpos=(int) (Math.random() * (10 - 1)) + 1;
            formula1driver.setStartpos(startpos);

            if(startpos==1) {
                formula1driver.setProbability("40%");
                int raceposition = (int) (Math.random() * (3 - 1)) + 1;
                if (raceposition == 1) {

                    formula1driver.setPointper(25);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);

                    formula1driver.setFirstposcount(1);
                    firstpos = formula1driver.getNo_of_first_pos() + formula1driver.getFirstposcount();
                    formula1driver.setNo_of_first_pos(firstpos);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);

                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 2) {


                    formula1driver.setPointper(18);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setSecondposcount(1);
                    secondtpos = formula1driver.getNo_of_second_pos() + formula1driver.getSecondposcount();
                    formula1driver.setNo_of_second_pos(secondtpos);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);


                } else if (raceposition == 3) {
                    formula1driver.setThirdposcount(1);
                    thirdpos = formula1driver.getNo_of_third_pos() + formula1driver.getThirdposcount();
                    formula1driver.setNo_of_third_pos(thirdpos);

                    formula1driver.setPointper(15);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);


                } else if (raceposition == 4) {

                    formula1driver.setPointper(12);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 5) {

                    formula1driver.setPointper(10);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                }
                //----------------------------------------------------------------------------------------------------------
                //----------------------------------------------------------------------------------------------------------
            }else if (startpos==2){
                formula1driver.setProbability("30%");
                int raceposition = (int) (Math.random() * (7 - 1)) + 1;
                if (raceposition == 1) {

                    formula1driver.setPointper(25);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);

                    formula1driver.setFirstposcount(1);
                    firstpos = formula1driver.getNo_of_first_pos() + formula1driver.getFirstposcount();
                    formula1driver.setNo_of_first_pos(firstpos);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 2) {

                    formula1driver.setPointper(18);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setSecondposcount(1);
                    secondtpos = formula1driver.getNo_of_second_pos() + formula1driver.getSecondposcount();
                    formula1driver.setNo_of_second_pos(secondtpos);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);


                } else if (raceposition == 3) {
                    formula1driver.setThirdposcount(1);
                    thirdpos = formula1driver.getNo_of_third_pos() + formula1driver.getThirdposcount();
                    formula1driver.setNo_of_third_pos(thirdpos);

                    formula1driver.setPointper(15);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);


                } else if (raceposition == 4) {

                    formula1driver.setPointper(12);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 5) {

                    formula1driver.setPointper(10);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 6) {

                    formula1driver.setPointper(8);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 7) {

                    formula1driver.setPointper(6);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 8) {

                    formula1driver.setPointper(4);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 9) {
                    formula1driver.setPosition(raceposition);
                    formula1driver.setPointper(2);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);

                } else if (raceposition == 10) {

                    formula1driver.setPointper(1);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);

                    formula1driver.setPosition(raceposition);
                }
                //----------------------------------------------------------------------------------------------------------
                //----------------------------------------------------------------------------------------------------------
            }else if(startpos==3 || startpos==4) {
                formula1driver.setProbability("10%");
                int raceposition = (int) (Math.random() * (8 -1)) + 1;
                if (raceposition == 4) {

                    formula1driver.setPointper(12);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 5) {

                    formula1driver.setPointper(10);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 6) {

                    formula1driver.setPointper(8);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 7) {

                    formula1driver.setPointper(6);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 8) {

                    formula1driver.setPointper(4);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 9) {

                    formula1driver.setPointper(2);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 10) {

                    formula1driver.setPointper(1);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);

                    formula1driver.setPosition(raceposition);

                }
                //----------------------------------------------------------------------------------------------------------
                //----------------------------------------------------------------------------------------------------------
            }else if(startpos==5 || startpos==6 || startpos==7 || startpos==8 || startpos==9) {
                formula1driver.setProbability("2%");
                int raceposition = (int) (Math.random() * (10 - 1)) + 1;

                if (raceposition == 8) {

                    formula1driver.setPointper(4);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);

                    formula1driver.setPosition(raceposition);


                } else if (raceposition == 9) {

                    formula1driver.setPointper(2);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);

                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 10) {

                    formula1driver.setPointper(1);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);

                    formula1driver.setPosition(raceposition);

                }
                //----------------------------------------------------------------------------------------------------------
                //----------------------------------------------------------------------------------------------------------
            }else {
                formula1driver.setProbability("0%");
                int raceposition = (int) (Math.random() * (10 - 2)) + 2;
                if (raceposition == 2) {


                    formula1driver.setPointper(18);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setSecondposcount(1);
                    secondtpos = formula1driver.getNo_of_second_pos() + formula1driver.getSecondposcount();
                    formula1driver.setNo_of_second_pos(secondtpos);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);


                } else if (raceposition == 3) {
                    formula1driver.setThirdposcount(1);
                    thirdpos = formula1driver.getNo_of_third_pos() + formula1driver.getThirdposcount();
                    formula1driver.setNo_of_third_pos(thirdpos);

                    formula1driver.setPointper(15);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);


                } else if (raceposition == 4) {

                    formula1driver.setPointper(12);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 5) {

                    formula1driver.setPointper(10);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                }else if (raceposition == 6) {

                    formula1driver.setPointper(8);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 7) {

                    formula1driver.setPointper(6);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 8) {

                    formula1driver.setPointper(4);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 9) {

                    formula1driver.setPointper(2);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);

                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);
                    formula1driver.setPosition(raceposition);

                } else if (raceposition == 10) {

                    formula1driver.setPointper(1);
                    point = formula1driver.getPoints() + formula1driver.getPointper();
                    formula1driver.setPoints(point);


                    formula1driver.setRacecount(1);
                    noOfraces = formula1driver.getNo_of_races() + formula1driver.getRacecount();
                    formula1driver.setNo_of_races(noOfraces);

                    formula1driver.setPosition(raceposition);

                }


            }



            }

        }
    }
    //references----->https://ashraigosa.medium.com/saving-and-reloading-data-with-file-serialization-in-java-74b79630ec81

