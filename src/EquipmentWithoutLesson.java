import java.util.Scanner;
public class EquipmentWithoutLesson extends Equipment{

    Scanner scanner = new Scanner(System.in);

    public EquipmentWithoutLesson(int equipNum){
        super(equipNum);
        if (equipNum > EQUIPMENT.length - 5 && equipNum < EQUIPMENT.length)
        {super.equipmentNum = equipNum;}
        else {
            super.equipmentNum = EQUIPMENT.length - 1;
        }
        setSurcharge(getSurcharge());
    }


    public void lessonPolicy(){
        System.out.println("This Rental does not require a lesson.");
    }

}
