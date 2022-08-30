//import java.util.Scanner;
public abstract class Equipment {
    //Scanner scanner = new Scanner(System.in);

    //Fields and arrays for class
    protected int equipmentNum;//equipType
    private String equipmentName;
    private int rentalEquipmentFee;
    final static String EQUIPMENT[] = {"personal watercraft", "pontoon boat", "rowboat", "canoe", "kayak", "beach chair", "umbrella", "other"};
    final static int SURCHARGE[] = {50, 40, 15, 12, 10, 2, 1, 0};

    //Constructors to implement the array

    public Equipment(int equipType) {
        if (equipType < EQUIPMENT.length) {
            equipmentNum = equipType;
        } else {
            equipmentNum = EQUIPMENT.length - 1;
        }
    }

    public String getEQUIP_TYPES() {
        return EQUIPMENT[equipmentNum];
    }
    //Methods to manipulate the fields and arrays

    public abstract void lessonPolicy();

    public void setEquipmentNum(int equipNum) {
        if (equipNum > 7) {
            equipmentNum = 7;
        } else {
            equipmentNum = equipNum;
        }
    }//check

    public int getEquipmentNum() {
        return equipmentNum;
    }//check

    public void setEquipmentName() {

    }

    public String getEquipmentName() {
        return EQUIPMENT[equipmentNum];
    }//check

    public void setSurcharge(int surcharge) {
        surcharge = rentalEquipmentFee;
    }

    public int getSurcharge() {
        return SURCHARGE[equipmentNum];
    }
}


