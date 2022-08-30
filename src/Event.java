import java.util.Scanner;
public class Event {
    public static final int LPG = 32; //a concrete low price per guest
    public static final int HPG = 35; //a concrete high price per guest
    private double pricePerGuest;
    private double priceForEvent;
    public static final int LARGE_EVENT = 50;  //a concrete fee for a large event
    private String eventNum;  //holds the event number
    private int numGuests; //holds the # of guests
    private String phone; //holds the ph#
    private int eventType;  //holds the event type as a number.
    private String eventTypes[]= {"wedding","baptism","birthday","corporate","other"};  //the event type numbers follow this array i.e. 0 is wedding, 1 is baptism, 2 is birthday, 3 is corporate, and 4 is other

    public Event() //This is a constructor that is used if no information is given from the user.
    {
        eventNum = ""; //sets the eventNum toa  blank automatically so nothing weird starts in there.
        numGuests = 0;  //sets numGuests to 0 auto so it also starts with nothing else in there.
        phone = ""; //sets phone# to a blank for same reasons as above.
        eventType = eventTypes.length - 1; //This makes the length of the array called eventTypes -1 a variable.  This is used for loops
    }

    public Event(String eventNum, int numGuests) {
        this.eventNum = eventNum;
        setGuests(numGuests);
        setEventNumber(eventNum);
    }

    public Event(String eventNum, int numGuests, int typeEvent) //same constructor as above but is given the variables in the parentheses rather than blanks
    {
        this.eventNum = eventNum; //These just create specificity.
        setGuests(numGuests);

        setEventNumber(eventNum); //This calls method setEventNumber and sends it the variable eventNum as a parameter from above
        setEvent(typeEvent); //this calls the setEvent method and passes the typeEvent as a paramenter
    }

    public static String eventNumber() //This gets the event # from the user and gives it back to eventStats this could probably be in the EventDemo too, but this pulls it for each object created.
    {
        String event; //creates a memory space called event that only fits strings.
        Scanner inputDevice = new Scanner(System.in); //This makes an object that gets input from the keyboard.
        System.out.print("Please enter the event number: >> "); //This is what the user sees.
        event = inputDevice.nextLine(); // This clears the scanner so it ignores the enter key.
        return event; //This gives the event variable back to whatever called it.
    }

    public void setEvent(int num) //This decides if the eventType entered by the user is within the range of the array eventTypes.  Note: typeEvent from setEvent above and num from this method are the same just two different names.
    {
        if (num<0 || num>eventTypes.length) { //takes the variable num given as a parameter and says if num is less than 0 or is greater than eventTypes.length then make the variable eventType to eventTypes.length -1
            eventType=eventTypes.length - 1;  //not sure why i need this line but it doesn't work without it.
        } else {  //Otherwise just leave eventType as num.
            eventType = num;
        }
    }

    public String getEventType(){  //Hmmm...
        return eventTypes[eventType];
    }

    public void setEventNumber(String eventNum)  //Takes the value of eventNum and sets it publicly as a middle man between the actual eventnumber and the outside classes.
    {
        if(eventNum.length() < 4) //if the length of the event# is less than 4 characters long then--
            this.eventNum = "A000"; //change it to "A000"
        else if (eventNum.length()==4)  //if the eventNum is 4 characters long pass it to the next inner if
        {
            if(!Character.isAlphabetic(eventNum.charAt(0)) || !Character.isDigit(eventNum.charAt(1)) //this if statement looks to see if the eventNum is not the right setup.
                    || !Character.isDigit(eventNum.charAt(1))
                    || !Character.isDigit(eventNum.charAt(1)))
                this.eventNum="A000"; //If it is not, it changes the event# to A000 as a default
            else
                this.eventNum=eventNum; //otherwise it let's the passed eventNum variable at the top be changed to what was passed to it.
        }
        else
            this.eventNum=eventNum; //Not sure why i need this, but it doesn't work without it.
    }


    public void setGuests(int gsts) //Does the same as setEventNumber.
    {
        numGuests = gsts;
        if(isLargeEvent())
        {
            pricePerGuest = LPG;
            priceForEvent = numGuests * LPG;
        }
        else
        {
            pricePerGuest = HPG;
            priceForEvent = numGuests * HPG;
        }
    }

    public boolean isLargeEvent()
    {
        boolean isLarge = false;
        if(numGuests >= LARGE_EVENT)
            isLarge = true;
        return isLarge;
    }


    public String getEventNum() //This is amiddle man that gets the eventNum from the private eventNum and sends it out to other classes that ask for it.
    {
        return eventNum;
    }


    public void setPhone() //Sets the phone number to the correct amount of digits.
    {
        String tempPhone=""; //initializes the variable tempPhone to a blank
        Scanner inputDevice = new Scanner(System.in); //creates a scanner to get and send info to the screen
        System.out.println("Please enter a contact number: ");  //asks for contract number
        phone = inputDevice.nextLine(); //takes the input from the user and stores it in the variable phone at the top


        for (int i = 0; i < phone.length(); i++) //for loop takes the length of phone and--
        {
            if(Character.isDigit(phone.charAt(i))) //puts it in this if statement which asks if the character is a number
                tempPhone+=phone.charAt(i);
        }

        if(tempPhone.length() < 10 || tempPhone.length() > 10) //this asks if the phone is ten digits long
            this.phone="0000000000"; //if not change it to ten 0's
        else
            this.phone=tempPhone; //if it is then change tempPhone to this objects phone variable at the top

    }

    public String getPhone() //This gets the private phone variable and sends it to whatever asked for it
    {
        String formattedPhoneNumber=""; //sets up a variable as a blank
        formattedPhoneNumber+="("+phone.substring(0, 3)+")"; //puts the first three numbers in parentheses
        formattedPhoneNumber+=phone.substring(3, 6); //Set aside the next 3 numbers.
        formattedPhoneNumber+="-"; //add the "-" after them.
        formattedPhoneNumber+=
                phone.substring(6, phone.length());

        phone=formattedPhoneNumber; //Now change the variable formattedPhoneNumber to the variable phone

        return phone; //return the new phone variable to whatever asked for this method.
    }

    public int getNumGuests() //Does the same as getEventNum
    {
        return numGuests;
    }
    public double getPricePerGuest()
    {
        return pricePerGuest;
    }
    public double getPriceForEvent()
    {
        return priceForEvent;
    }
}
