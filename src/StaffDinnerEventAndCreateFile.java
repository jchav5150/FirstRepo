import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;
//import java.nio.channels.FileChannel;
import java.util.*;

    public class StaffDinnerEventAndCreateFile {
        public static void main(String[] args) {
            Employee[] emps = new Employee[15];
            DinnerEvent[] events = new DinnerEvent[3];
            int count;
            String eventNum;
            int guests;
            DinnerEvent event;
            //int option;
            //int x;
            int y;
            int waitStaff;
            int bartenders;
            int[] menuOption = new int[4];
            eventNum = getEventNumber();
            guests = getGuests();
            for (y = 0; y < menuOption.length; ++y)
                menuOption[y] = getMenu(y);
            event = new DinnerEvent(eventNum, guests, menuOption[0], menuOption[1], menuOption[2], menuOption[3]);
            event.setPhone();
            event.setEvent(getType());
            waitStaff = guests / 10;
            for (count = 0; count < waitStaff; ++count)
                emps[count] = getWaitstaff();
            bartenders = guests / 25;
            for (; count < waitStaff + bartenders; ++count)
                emps[count] = getBartender();
            emps[count] = getCoordinator();
            event.setEmployees(emps);
            ++count;

            System.out.println("\n\nNow display the event");
            displayDetails(event, count);
            writeDataFile(events);
        }


        public static Waitstaff getWaitstaff() {
            Scanner in = new Scanner(System.in);
            Waitstaff ws = new Waitstaff();
            System.out.print("Enter Employee number for waitstaff >> ");
            ws.setEmployeeId(in.nextInt());
            in.nextLine();
            ws.setFirstName();
            ws.setLastName();
            boolean flag = true;
            while(flag){
            System.out.print("Enter pay rate >> ");
            try {
                ws.setPayRate(in.nextDouble());
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid Pay rate.");
                in.nextLine();
                continue;
            }
            flag = false;
        }
            ws.setJobTitle();
            return ws;
        }

        public static Bartender getBartender() {
            Scanner in = new Scanner(System.in);
            Bartender bt = new Bartender();
            System.out.print("Enter Employee number for bartender >> ");
            bt.setEmployeeId(in.nextInt());
            bt.setFirstName();
            bt.setLastName();
            boolean flag = true;
            while (flag) {
                System.out.print("Enter pay rate >> ");
                try {
                    bt.setPayRate(in.nextDouble());
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid Pay rate.");
                    in.nextLine();
                    continue;
                }
               flag = false;
            }
            bt.setJobTitle();
            return bt;
        }

        public static Coordinator getCoordinator() {
            Scanner in = new Scanner(System.in);
            Coordinator co = new Coordinator();
            System.out.print("Enter Employee number for coordinator >> ");
            co.setEmployeeId(in.nextInt());
            co.setFirstName();
            co.setLastName();
            boolean flag = true;
            while (flag) {
                System.out.print("Enter pay rate >> ");
                try {
                    co.setPayRate(in.nextDouble());
                }
                catch (InputMismatchException e){
                    System.out.println("Please enter a valid Pay rate.");
                    in.nextLine();
                    continue;
                }
                flag=false;
            }
            co.setJobTitle();
            return co;
        }

        public static String getEventNumber() {
            String num;
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter event number >> ");
            num = input.nextLine();
            return num;
        }

        public static int getGuests() {
            int guests = 0;
            final int MIN_GUESTS = 5;
            final int MAX_GUESTS = 100;
            Scanner input = new Scanner(System.in);
            boolean loop = true;
            while (loop){
            System.out.print("Enter number of guests >> ");
            try {
                guests = input.nextInt();
                loop = false;
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter a number only with no decimals.");
                input.nextLine();
            }
            }
            while (guests < MIN_GUESTS || guests > MAX_GUESTS) {
                System.out.println("The number of guests must be between " +
                        MIN_GUESTS + " and " + MAX_GUESTS);
                System.out.print("Please renter >> ");
                try {
                    guests = input.nextInt();
                }
                catch(InputMismatchException e){
                    System.out.println("Please enter a number without decimals only.");
                    input.nextLine();
                }
            }
            input.nextLine();
            return guests;
        }


        public static int getType ()
            {
                int eType = 4;
                Scanner input = new Scanner(System.in);
                boolean flag = true;
                while(flag) {
                    System.out.println("Please enter a number corresponding to the event type--");
                    System.out.println("type 0 for wedding");
                    System.out.println("type 1 for baptism");
                    System.out.println("type 2 birthday");
                    System.out.println("type 3 for corporate");
                    System.out.println("type 4 for other");
                    System.out.println("Enter event type: "); //asks the user an event type
                    try {
                        eType = input.nextInt();
                        }
                    catch (InputMismatchException e) {
                        System.out.println("Please enter a number from above only. Please try again.");
                        input.nextLine();
                        continue;
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("That number is not in the options. Please try again.");
                        input.nextLine();
                        continue;
                    }
                    flag = false;
                }
                return eType;
            }

        public static void writeDataFile(DinnerEvent[] e)
        {
            String s;
            String delimiter = ",";
            OutputStream ostream;
            BufferedWriter writer;
            Path file =
                    Paths.get("C:\\Users\\johne\\IdeaProjects\\untitled\\src\\Events.txt");
            try
            {
                ostream = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
                writer = new BufferedWriter(new OutputStreamWriter(ostream));
                for (DinnerEvent dinnerEvent : e) {
                    s = dinnerEvent.getEventNum() + delimiter + dinnerEvent.getEventType() + delimiter +
                            dinnerEvent.getNumGuests() + delimiter + dinnerEvent.getPriceForEvent() +
                            System.getProperty("line.separator");
                    writer.write(s, 0, s.length());
                }
                writer.close();
            }
            catch(Exception x)
            {
                System.out.println("Message: " + x);
            }
        }

        public static void displayDetails(DinnerEvent e, int count)
        {
            Employee[] emps = new Employee[15];
            emps = e.getEmployees();
            System.out.println("\nEvent #" + e.getEventNum());
            System.out.println("The price for an event with " + e.getNumGuests() +
                    " guests at $" + e.getPricePerGuest() + " per guest is $" + e.getPriceForEvent());
            System.out.println("Whether this is a large event is " +
                    (e.getNumGuests() >= e.LARGE_EVENT));
            System.out.println("Contact phone number is: " + e.getPhone());
            System.out.println("The event is type " + e.getEventType());// + " which is the following type: " + e.getEventTypeArray());
            System.out.println("The menu you have chosen is " + e.getEntree()+ " with "+e.getSide1()+" and "+e.getSide2()+". With "+e.getDessert()+" for dessert.");
            System.out.println("\nThe staff includes:");
            for(int x = 0; x < count; ++x)
                System.out.println(emps[x].getEmployeeId() + " " + emps[x].getFirstName()+" "+emps[x].getLastName()+" " + emps[x].getPayRate() + "/hr " + emps[x].getJobTitle());
        }
        public static DinnerEvent getLarger(DinnerEvent e1, DinnerEvent e2)
        {
            DinnerEvent larger = e2;
            if(e1.getNumGuests() >= e2.getNumGuests())
                larger = e1;
            return larger;
        }
        public static String getPhone()
        {
            String phone;
            Scanner input = new Scanner(System.in);
            System.out.print("Enter contact phone number >> ");
            phone = input.nextLine();
            return phone;
        }
        public static int getMenu(int y)
        {
            int choice;
            if(y == 0)
                choice = displayEntreeMenu();
            else if (y == 1 || y == 2)
                choice = displaySidesMenu();
            else choice = displayDessertMenu();
            return choice;
        }
        public static int displayEntreeMenu() {
            Scanner keyboard = new Scanner(System.in);
            int x;
            int choice = 0;
            boolean flag = true;
            while (flag) {
                System.out.println("Please select from the following entrees:");
                for (x = 0; x < DinnerEvent.dinnerOptions.length; ++x)
                    System.out.println(x + " -- " + DinnerEvent.dinnerOptions[x]);
                System.out.print(" >> ");
                try {
                    choice = keyboard.nextInt();
                    if (choice < 0 || choice >= DinnerEvent.dinnerOptions.length) {
                        System.out.println("Please select a number from above.");
                        keyboard.nextLine();
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number from above.");
                    keyboard.nextLine();
                    continue;
                }
                flag = false;
            }
            return choice;

            }
        public static int displaySidesMenu() {
            Scanner keyboard = new Scanner(System.in);
            int x;
            int choice=4;
            boolean flag = true;
            while (flag) {
                System.out.println("Please select from the following sides:");
                for (x = 0; x < DinnerEvent.sideOptions.length; ++x)
                    System.out.println(x + " -- " + DinnerEvent.sideOptions[x]);
                System.out.print(" >> ");
                try {
                    choice = keyboard.nextInt();
                    if (choice < 0 || choice >= DinnerEvent.sideOptions.length) {
                        System.out.println("Please select a number from above.");
                        keyboard.nextLine();
                        continue;
                    }
                }
                catch(InputMismatchException e){
                        System.out.println("Please enter a number from above.");
                        keyboard.nextLine();
                        continue;
                    }
                    flag = false;
                }
                keyboard.nextLine();
                return choice;
            }
        public static int displayDessertMenu()
        {
            Scanner keyboard = new Scanner(System.in);
            int x;
            int choice=4;
            boolean flag = true;
            while (flag) {
                System.out.println("Please select from the following sides:");
                for (x = 0; x < DinnerEvent.dessertOptions.length; ++x)
                    System.out.println(x + " -- " + DinnerEvent.dessertOptions[x]);
                System.out.print(" >> ");
                try {
                    choice = keyboard.nextInt();
                    if (choice < 0 || choice >= DinnerEvent.dessertOptions.length) {
                        System.out.println("Please select a number from above.");
                        keyboard.nextLine();
                        continue;
                    }
                }
                catch(InputMismatchException e){
                    System.out.println("Please enter a number from above.");
                    keyboard.nextLine();
                    continue;
                }
                flag = false;
            }
            keyboard.nextLine();
            return choice;
        }

    }

