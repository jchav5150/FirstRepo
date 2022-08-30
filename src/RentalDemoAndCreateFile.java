import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalDemoAndCreateFile {
    public static void main(String[] args) {

        String contractNum;
        int minutes;
        Rental[] rentals = new Rental[8];
        for (int i = 0; i < rentals.length; ++i) {
            contractNum = getContractNumber();
            minutes = getMinutes();
            rentals[i] = new Rental(contractNum, minutes, getType());
            rentals[i].setPhone();
        }
        for (Rental rental : rentals) {
            displayDetails(rental);
        }
        writeFile(rentals);
    }
    public static String getContractNumber() {
        String num;
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter contract number >> ");
        num = input.nextLine();
        return num;
    }
    public static int getMinutes() {
        int minutes = 0;
        final int LOW_MIN = 60;
        final int HIGH_MIN = 7200;
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("Enter minutes >> ");
            try {
                minutes = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number of minutes only.");
                input.nextLine();
            }
            flag = false;
        }
        while (minutes < LOW_MIN || minutes > HIGH_MIN) {
            System.out.println("Time must be between " + LOW_MIN + " minutes and " + HIGH_MIN + " minutes");
            System.out.print("Please reenter minutes >> ");
            minutes = input.nextInt();
        }
        return minutes;
    }
    public static int getType() {
        int eType = 8;
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Equipment types:");
        for (int i = 0; i < Equipment.EQUIPMENT.length; ++i) {
            System.out.println(" " + i + " " + Equipment.EQUIPMENT[i]);
        }
        while(flag) {
            System.out.print("Enter equipment type >> ");
            try {
                eType = input.nextInt();
            }
            catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("That number is not in the options.  Please enter a number from above.");
                input.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a number from above only. Try again.");
                input.nextLine();
            }
            flag = false;
        }
        return eType;
    }
    public static void displayDetails(Rental r) {
        System.out.println("\nContract #" + r.getConNum());
        System.out.println("For a rental of " + r.getHours() + " hours and " + r.getExtraMinutes() + " minutes,\n at a rate of $" + r.HOUR_RATE + " per hour and $1 per minute,\n the price is $" + r.getPrice());
        System.out.println("Contact phone number is: " + r.getPhone());
        System.out.println("Equipment rented is type #" + r.getEquipmentType() + " " + r.getEquipment().getEQUIP_TYPES());
        r.getEquipment().lessonPolicy();
    }
    public static Rental getLongerRental(Rental r1, Rental r2) {
        Rental longer = new Rental();
        int minutes1;
        int minutes2;
        minutes1 = r1.getHours() * Rental.MINUTES_IN_HOUR + r1.getExtraMinutes(); minutes2 = r2.getHours() * Rental.MINUTES_IN_HOUR + r2.getExtraMinutes();
        if (minutes1 >= minutes2) {
            longer = r1;
        } else {
            longer = r2;
        }
        return longer;
    }
    public static String getPhone() {
        String phone;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter contact phone number >> ");
        phone = input.nextLine();
        return phone;
    }
    public static void writeFile(Rental[] r)
    {
        String s;
        String delimiter = ",";
        OutputStream ostream;
        BufferedWriter writer;
        Path file =
                Paths.get("C:\\Users\\johne\\IdeaProjects\\untitled\\src\\Rentals.txt");

        try
        {
            ostream = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            writer = new BufferedWriter(new OutputStreamWriter(ostream));
            for (Rental rental : r) {
                Equipment e = rental.getEquipment();
                s = rental.getConNum() + delimiter + rental.getHours() +
                        delimiter + rental.getExtraMinutes() +
                        delimiter + e.getEquipmentNum() +
                        delimiter + e.getEquipmentName() +
                        delimiter + rental.getPrice() +
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

}
