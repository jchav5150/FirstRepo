import java.util.IllegalFormatCodePointException;
import java.util.Scanner;
public class EquipmentWithLesson extends Equipment{

    Scanner scanner = new Scanner(System.in);
    //Fields and Arrays

    //Constructors
   public EquipmentWithLesson(int equipNum){
       super(equipNum);
       if (equipNum<EQUIPMENT.length-5){
           super.equipmentNum = equipNum;
       } else {
           super.equipmentNum = EQUIPMENT.length-1;
       }
setSurcharge(getSurcharge());

   }
    //Methods
    public void lessonPolicy(){
        {
            System.out.println("This Rental requires a lesson by an instructor.");
        }
    }

}
//public class EquipmentWithoutLesson extends Equipment {
    //public EquipmentWithoutLesson(int equipType) {
        //super(equipType);
       // if (equipType > EQUIP_TYPES.length - 5 && equipType < EQUIP_TYPES.length) {
       //     super.equipType = equipType;
        //} else { super.equipType = EQUIP_TYPES.length - 1;
       // }
       // setRentFee(getEQUIP_CHARGES());
    //}
   // String lessonPolicy() { return "This type of rental does not require a lesson"; } }