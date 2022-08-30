import java.util.Scanner;

public abstract class Employee {

    Scanner scanner = new Scanner(System.in);

    //Variables used for the class*************************************
    private int employeeId;
    private String firstName;
    private String lastName;
    protected double payRate;
    protected String jobTitle;

    //Methods used to manipulate the variables.************************

    public void setEmployeeId(int id){
        employeeId=id;
    }

    public int getEmployeeId(){
        return employeeId;
    }

    public void setFirstName(){
        System.out.println("Please enter New Employee's First Name:");
        firstName = scanner.nextLine();
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(){
        System.out.println("Please enter New Employee's Last Name:");
        lastName = scanner.nextLine();
        //scanner.nextLine();
    }

    public String getLastName(){
        return lastName;
    }

    public abstract void setPayRate(double payrate);

    public double getPayRate(){
        return payRate;
    }

    public abstract void setJobTitle();

    public String getJobTitle(){
        return jobTitle;
    }

}
