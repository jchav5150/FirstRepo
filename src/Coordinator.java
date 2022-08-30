import java.util.Scanner;
public class Coordinator extends Employee {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void setPayRate(double payrate){
        if (payrate > 20.00)
            payRate = 20.00;
        else
            payRate = payrate;
    }

    @Override
    public void setJobTitle(){
        jobTitle = "Coordinator";
    }

}
