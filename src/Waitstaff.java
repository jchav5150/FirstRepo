import java.util.Scanner;

public class Waitstaff extends Employee {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void setPayRate(double payrate){
        if (payrate > 10.00)
            payRate = 10.00;
        else
            payRate = payrate;
    }

    @Override
    public void setJobTitle(){
    jobTitle = "Waitstaff";
    }


}
