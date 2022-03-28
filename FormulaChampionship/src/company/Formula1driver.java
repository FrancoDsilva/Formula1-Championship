package company;

public class Formula1driver extends driver {
    private int no_of_first_pos=0;
    private int no_of_second_pos=0;
    private int no_of_third_pos;
    private int no_of_races;
    private int points;
    private int pointper;
    private int firstposcount;
    private int secondposcount;
    private int thirdposcount;
    private int racecount;
    private String datestore;
    private int Position;
    private int startpos;
    private String probability;

    /*constructor for add driver method*/
    public Formula1driver(String name, String location,String driverteam) {
        super(name, location,driverteam);
    }

    /*constructor for all other methods*/
    public Formula1driver(String name, String location, String driverteam , int no_of_first_pos, int no_of_second_pos, int no_of_third_pos, int no_of_races, int points ,int pointper,int firstposcount,int secondposcount,int thirdposcount,int racecount ,String datestore ,int Position,String probability,int startpos) {
        super(name, location,driverteam);
        this.no_of_first_pos = no_of_first_pos;
        this.no_of_second_pos = no_of_second_pos;
        this.no_of_third_pos = no_of_third_pos;
        this.no_of_races = no_of_races;
        this.points = points;
        this.pointper = pointper;
        this.firstposcount = firstposcount;
        this.secondposcount = secondposcount;
        this.thirdposcount = secondposcount;
        this.racecount=racecount;
        this.datestore=datestore;
        this.Position=Position;
        this.probability=probability;
        this.startpos=startpos;

    }
    /*getters and setters*/
    public int getNo_of_first_pos() {
        return no_of_first_pos;
    }

    public int getNo_of_second_pos() {
        return no_of_second_pos;
    }

    public int getNo_of_third_pos() {
        return no_of_third_pos;
    }

    public int getNo_of_races() {
        return no_of_races;
    }

    public int getPoints() { return points; }

    public int getPointper() { return pointper; }

    public int getFirstposcount() { return firstposcount; }

    public String getDatestore() { return datestore; }

    public void setDatestore(String datestore) { this.datestore = datestore; }

    public void setFirstposcount(int firstposcount) { this.firstposcount = firstposcount; }

    public int getSecondposcount() { return secondposcount; }

    public int getRacecount() { return racecount; }

    public void setRacecount(int racecount) { this.racecount = racecount; }

    public void setSecondposcount(int secondposcount) { this.secondposcount = secondposcount; }

    public String getProbability() { return probability; }

    public int getStartpos() { return startpos; }

    public void setStartpos(int startpos) {this.startpos = startpos; }

    public void setProbability(String probability) { this.probability = probability; }

    public int getThirdposcount() { return thirdposcount; }

    public int getPosition() { return Position; }

    public void setPosition(int position) { Position = position; }

    public void setThirdposcount(int thirdposcount) { this.thirdposcount = thirdposcount; }

    public void setNo_of_first_pos(int no_of_first_pos) {
        this.no_of_first_pos = no_of_first_pos;
    }

    public void setNo_of_second_pos(int no_of_second_pos) {
        this.no_of_second_pos = no_of_second_pos;
    }

    public void setNo_of_third_pos(int no_of_third_pos) {
        this.no_of_third_pos = no_of_third_pos;
    }

    public void setNo_of_races(int no_of_races) {
        this.no_of_races = no_of_races;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setPointper(int pointper) { this.pointper = pointper; }
}
