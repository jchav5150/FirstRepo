import java.util.Scanner;
public class DinnerEventDemo
{

    public static void main(String[] args)
    {
        Scanner scanner= new Scanner(System.in);
        final int SIZE = 4;
        DinnerEvent[] myEvent = new DinnerEvent[SIZE]; //Makes the 8 instances of events in an array.

        for (int i = 0; i < myEvent.length; i++){ //This runs each method for every object in the array.

            System.out.println("Please enter a number corresponding to the event type--");
            System.out.println("type 0 for wedding");
            System.out.println("type 1 for baptism");
            System.out.println("type 2 birthday");
            System.out.println("type 3 for corporate");
            System.out.println("type 4 for other");
            System.out.println("Enter event type: "); //asks the user an event type
            int type = scanner.nextInt();//Intakes what the user enters.
            scanner.nextLine();
            System.out.println("Enter event number: "); //asks the user an event type
            String eventNum = scanner.nextLine();//Intakes what the user enters.
            System.out.println("Enter number of guests: "); //asks the user an event type
            int numGuests = scanner.nextInt();//Intakes what the user enters.
            System.out.println(new DinnerEvent().getMenu());
            System.out.println("Please enter your entree choice: "); //asks the user an event type
            int entree = scanner.nextInt();//Intakes what the user enters.
            System.out.println("Please enter your first side dish: "); //asks the user an event type
            int side1 = scanner.nextInt();//Intakes what the user enters.
            System.out.println("Please enter your second side dish: "); //asks the user an event type
            int side2 = scanner.nextInt();//Intakes what the user enters.
            System.out.println("Please enter your dessert of choice: "); //asks the user an event type
            int dessert = scanner.nextInt();//Intakes what the user enters.

            myEvent[i] = new DinnerEvent(eventNum, numGuests, entree, side1, side2, dessert);
            myEvent[i].setEvent(type);//Takes the type entered by the user and sends it to the setEvent method for the new event created.
            //myEvent[i].setGuests();//Runs the setGuests method in the current event object which asks for how many guests
            //myEvent[i].setEventNumber(getEventNumber()); //this gets the event number from the user, verifies it then sets it for the given object at [i].
            //myEvent[i].getMenu();
        }


        int sortCriteria = 0;
        while (sortCriteria != 4) {
            System.out.println("Please enter the way you would like to sort your results");
            System.out.println("by entering one of the following:");
            System.out.println("1 to sort by event number");
            System.out.println("2 to sort by number of guests");
            System.out.println("3 to sort by event type");
            System.out.println("or 4 to quit: ");
            sortCriteria = scanner.nextInt();
            if (sortCriteria == 1) {
                System.out.println("You have chosen by event number.");
                sortByEvent(myEvent);
                display(myEvent);
            } else if (sortCriteria == 2) {
                System.out.println("You have chosen by number of guests.");
                sortByGuests(myEvent);
                display(myEvent);
            } else if (sortCriteria == 3) {
                System.out.println("You have chosen by event type.");
                sortByType(myEvent);
                display(myEvent);
            } else {
                System.out.println("You have chosen to Quit.  Thank you!");
            }
        }

    }

    public static String getEventNumber()
    {
        String num;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter event number >> ");
        num = input.nextLine();
        return num;
    }
    public static void display(DinnerEvent[] myEvent) {

        for (DinnerEvent event : myEvent) {//This for loop runs for each object in the array
            System.out.println("Event Type: " + event.getEventType());  //This prints out the event type for the given index
            System.out.println("Event Number: " + event.getEventNum());  //This prints out the phone number for the given index
            System.out.println("# of guests: " + event.getNumGuests());  //This prints out the # of guests for the given index
            System.out.println("Entree: " + event.getEntree());
            System.out.println("Side1: " + event.getSide1());
            System.out.println("Side2: " + event.getSide2());
            System.out.println("Dessert: " + event.getDessert());
            System.out.println("**************************************");
        }
    }

    public static void sortByEvent(DinnerEvent[] myEvent) {
            int index;
            DinnerEvent temp;
            for (int i=0; i < myEvent.length; i++) {
                for (int j=i+1; j < myEvent.length; j++) {
                    index = myEvent[i].getEventNum().compareTo(myEvent[j].getEventNum());
                    if (index > 0) {
                        temp = myEvent[i];
                        myEvent[i] = myEvent[j];
                        myEvent[j] = temp;
                    }
                }
            }
    }

    public static void sortByGuests(DinnerEvent[] myEvent) {
        DinnerEvent temp;
        for (int i = 0; i < myEvent.length; i++) {
            for (int j = i + 1; j < myEvent.length; j++) {
                if (myEvent[i].getNumGuests() > myEvent[j].getNumGuests()) {
                    temp = myEvent[i];
                    myEvent[i] = myEvent[j];
                    myEvent[j] = temp;
                }
            }
        }
    }
    public static void sortByType(DinnerEvent[] myEvent) {
            int index;
            DinnerEvent temp;
            for (int i=0; i < myEvent.length; i++)
            {
                for (int j=i+1; j < myEvent.length; j++)
                {
                    index = myEvent[i].getEventType().compareTo(myEvent[j].getEventType());
                    if (index > 0)
                    {
                        temp = myEvent[i];
                        myEvent[i] = myEvent[j];
                        myEvent[j] = temp;
                    }
                }
            }
        }

}
