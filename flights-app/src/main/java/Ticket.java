import java.util.Date;
import java.lang.Math;

public abstract class Ticket {
    private Date dateCreated;
    private int num;
    private String passenger;

    // Generate date and time ticket was created
    public Date getDateCreated() {
        return dateCreated;
    }

    // Generate new random ticket number
    public int getNum() {


        return num;
    }

    // Get passenger that owns ticket
    public String getPassenger() {
        return passenger;
    }
}

