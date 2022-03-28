package company;


import java.io.Serializable;

public abstract class driver implements Serializable {
   /*Create private variables*/
    private String name;
    private String location;
    private String driverteam;

    public driver(String name, String location, String driverteam) {/*Constructor*/
        this.name = name;
        this.location = location;
        this.driverteam = driverteam;
    }
    /*Getter Setter for names*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*Getter Setter for locations*/
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /*Getter Setter for Driver teams*/
    public String getDriverteam() {
        return driverteam;
    }

    public void setDriverteam(String driverteam) {
        this.driverteam = driverteam;
    }
}

