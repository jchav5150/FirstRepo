import java.nio.file.*;
import java.io.*;
public class DisplayRentalFIle {
    public static void main(String[] args){
    Path rFile =
            Paths.get("C:\\Users\\johne\\IdeaProjects\\untitled\\src\\Events.txt");
    String s = "";

try
    {
        InputStream rental = new BufferedInputStream(Files.newInputStream(rFile));
        BufferedReader rentalReader = new BufferedReader(new InputStreamReader(rental));
        System.out.println("\nRentals\n");
        s = rentalReader.readLine();
        while( s != null)
        {
            display(s);
            s = rentalReader.readLine();
        }
        rentalReader.close();
    }
catch(Exception e)
    {
        System.out.println("Message: " + e);
    }
}
    public static void display(String s)
    {
        String[] array = new String[6];
        String delimiter = ",";
        String stringId;
        String equip;
        int hours;
        int minutes;
        int equipType;
        double price;
        array = s.split(delimiter);
        stringId = array[0];
        hours = Integer.parseInt(array[1]);
        minutes = Integer.parseInt(array[2]);
        equipType = Integer.parseInt(array[3]);
        equip = (array[4]);
        price = Double.parseDouble(array[5]);
        System.out.println("#" + stringId + " " + hours +
                " hours and " + minutes + " minutes Equipment: " +
                equipType + " " + equip + " Price $" + price);
    }
}
