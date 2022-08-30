import java.util.Scanner;
public class Rental
{
    public static final int MINUTES_IN_HOUR = 60;
    public static final double HOUR_RATE = 40;
    private String conNum;//contractnumber
    public static final int CONTRACT_NUM_LENGTH = 4;
    private int hours;
    private int extraMinutes;
    private double price;
    private String phone;//contactphone
    protected int equipNum;//still need?

    private Equipment equipObj;//equipment

    private int basePrice;
    public Rental ()
    {
        conNum = "A000";
        phone = "";
        //equipNum = equipment.length - 1;
    }
    public Rental(String conNum, int minutes, int equipType)
    {
        setContractNumber(conNum);
        setHoursAndMinutes(minutes, equipObj.SURCHARGE[equipType]);
        this.equipObj = new EquipmentWithLesson(equipType);
        if (equipType < Equipment.EQUIPMENT.length - 5) {
        } else if ((equipType > Equipment.EQUIPMENT.length - 5) && (equipType < Equipment.EQUIPMENT.length))
        {
            this.equipObj = new EquipmentWithoutLesson(equipType);
        }

    }

    //public Rental(String con, int minutes){
      //  setContractNumber(con);
        //setHoursAndMinutes(minutes);
    //}

    public void setEquipment(int num)
    {
        if (num<0 || num>Equipment.EQUIPMENT.length) {
            equipNum=Equipment.EQUIPMENT.length - 1;
        } else {
            equipNum = num;
        }
    }

    public void setPhone()
    {
        String tempPhone="";
        Scanner inputDevice = new Scanner(System.in);
        System.out.println("Please enter a phone number: ");
        phone = inputDevice.nextLine();

        for (int i = 0; i < phone.length(); i++)
        {
            if(Character.isDigit(phone.charAt(i)))
                tempPhone+=phone.charAt(i);
        }
        if(tempPhone.length() < 10 || tempPhone.length() > 10)
            this.phone="0000000000";
        else
            this.phone=tempPhone;
    }
    public String getPhone()
    {
        String formattedPhoneNumber=""; //puts in the "(" around the first three numbers.
        formattedPhoneNumber+="("+phone.substring(0, 3)+")"; //Tells where to put the "()"
        formattedPhoneNumber+=phone.substring(3, 6); //Set aside the next 3 numbers.
        formattedPhoneNumber+="-"; //add the "-" after them.
        formattedPhoneNumber+=
                phone.substring(6, phone.length());
        phone=formattedPhoneNumber;

        return phone;
    }

    public void setContractNumber(String con)
    {
        //boolean numOk = true;
        if(con.length() != CONTRACT_NUM_LENGTH ||
                !Character.isLetter(con.charAt(0)) ||
                !Character.isDigit(con.charAt(1)) ||
                !Character.isDigit(con.charAt(2)) ||
                !Character.isDigit(con.charAt(3)))
            conNum = "A000";
        else
            conNum = con.toUpperCase();
    }

    public String getConNum()
    {
        return conNum;
    }

    public double getPrice()
    {
        return price;
    }
    public void setHoursAndMinutes(int minutes, int basePrice)
    {
        this.basePrice = basePrice;
        hours = minutes / MINUTES_IN_HOUR;
        extraMinutes = minutes % MINUTES_IN_HOUR;
        if (extraMinutes <= HOUR_RATE) {
            price = hours * HOUR_RATE + extraMinutes + basePrice;
        } else {
            price = hours * HOUR_RATE + HOUR_RATE + basePrice;
        }
    }
    public int getHours()
    {
        return hours;
    }
    public int getExtraMinutes()
    {
        return extraMinutes;
    }

    public String getEquipmentType() {
        return equipObj.getEquipmentName();
    }
    public Equipment getEquipment() {
        return equipObj;
    }
}

