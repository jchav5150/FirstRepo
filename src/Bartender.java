import java.util.Scanner;
public class Bartender extends Employee{

    Scanner scanner = new Scanner(System.in);

    @Override
    public void setPayRate(double payrate){
        if (payrate > 14.00)
            payRate = 14.00;
        else
            payRate = payrate;
    }

    @Override
    public void setJobTitle() {
        jobTitle = "Bartender";
    }
}

