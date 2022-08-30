import java.util.Scanner;

public class DinnerEvent extends Event{

    Scanner s = new Scanner(System.in);
    private int entree;
    private int side1;
    private int side2;
    private int dessert;

    final static String[] dinnerOptions ={"Chicken","Beef","Fish"};
    final static String[] sideOptions = {"Mashed Potatoes","Coleslaw","Corn"};
    final static String[] dessertOptions = {"bowl of Vanilla Ice Cream","slice of Apple Pie","Pizookie"};

    Employee[] employees = new Employee[15];

    public DinnerEvent() {

    }

    public DinnerEvent(String eventNum, int numGuests, int entree, int side1, int side2, int dessert){
        super(eventNum, numGuests); //This pulls the numGuests and typeEvent from the Event class.
        this.entree=entree;
        this.side1=side1;
        this.side2=side2;
        this.dessert=dessert;
    }

    public String getMenu () {

        String menu = "<!--- Entrées ---!>\n";
            for(int i=0; i<dinnerOptions.length; i++){
            menu += ( (i) + ") " + dinnerOptions[i] + "\n");
            }

        menu += "\n<!--- Side Dishes ---!>\n";

        for(int i=0; i<sideOptions.length; i++){
            menu += ( (i) + ") " + sideOptions[i] + "\n");
        }

        menu += "\n<!--- Desserts ---!>\n";

        for(int i=0; i<dessertOptions.length; i++){
            menu += ( (i) + ") " + dessertOptions[i] + "\n");
        }

// --- now returning that menu
        return menu;
    }

    public String getEntree() {
        return dinnerOptions[entree];
    }

    public String getSide1() {
        return sideOptions[side1];
    }
    public String getSide2() {
        return sideOptions[side2];
    }
    public String getDessert() {
        return dessertOptions[dessert];
    }

    public void setEmployees(Employee[] staff) {
    employees = staff;
    }
    public Employee[] getEmployees(){
        return employees;
    }
}
