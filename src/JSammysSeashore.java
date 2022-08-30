import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JSammysSeashore extends JFrame implements ItemListener, ActionListener
{
    FlowLayout flowval = new FlowLayout();
    JTextField hoursFieldval = new JTextField(9);
    JLabel hoursLabelval = new JLabel("Please enter hours for rental");
    JCheckBox jetSkiBox1 = new JCheckBox("Jet ski", false);
    JCheckBox pontoonBox1 = new JCheckBox("Pontoon boat", false);
    JCheckBox rowBoatBox1 = new JCheckBox("Rowboat", false);
    JCheckBox canoeBox1 = new JCheckBox("Canoe", false);
    JCheckBox kayakBox1 = new JCheckBox("Kayak", false);
    JCheckBox beachChairBox1 = new JCheckBox("Beach chair", false);
    JCheckBox umbrellaBox1 = new JCheckBox("Umbrella", false);
    JCheckBox lessonBox1= new JCheckBox("Sure!", false);
    JCheckBox noLessonBox1 = new JCheckBox("No, thanks.", true);
    JLabel main = new JLabel("Sammy's Seashore Rentals Equipment");
    Font font1 = new Font("Times New Roman",Font.BOLD, 30);
    Font font21 = new Font("Arial",Font.PLAIN, 25);
    JLabel labelTotalval = new JLabel("Total for Equipment");
    JLabel label11 = new JLabel("Select your rental:");
    JLabel label22 = new JLabel("Add a Lesson?");
    JLabel totalPrice = new JLabel();
    JLabel explainLabel123 = new JLabel();
    int housePriceval = 0;
    int lessonPriceval = 0;
    int equipPriceval = 0;
    int priceval = 0;
    int hours12;
    String outputval = "";
    String equipStringval = "";
    String timeStringval = "";
    String lessonStringval = "";
    public JSammysSeashore()
    {
        super("Menu items");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(flowval);
        ButtonGroup equipmentGroup12 = new ButtonGroup();
        equipmentGroup12.add(jetSkiBox1);
        equipmentGroup12.add(pontoonBox1);
        equipmentGroup12.add(rowBoatBox1);
        equipmentGroup12.add(canoeBox1);
        equipmentGroup12.add(kayakBox1);
        equipmentGroup12.add(beachChairBox1);
        equipmentGroup12.add(umbrellaBox1);
        ButtonGroup lessonGroup12 = new ButtonGroup();
        lessonGroup12.add(lessonBox1);
        lessonGroup12.add(noLessonBox1);
        add(main);
        add(hoursLabelval);
        add(hoursFieldval);
        add(label11);
        add(jetSkiBox1);
        add(pontoonBox1);
        add(rowBoatBox1);
        add(canoeBox1);
        add(kayakBox1);
        add(beachChairBox1);
        add(umbrellaBox1);
        main.setFont(font1);
        label11.setFont(font21);
        label22.setFont(font21);
        totalPrice.setFont(font21);
        add(label22);
        add(lessonBox1);
        add(noLessonBox1);
        add(labelTotalval);
        add(totalPrice);
        totalPrice.setText("$0");
        add(explainLabel123);
        hoursFieldval.addActionListener(this);
        jetSkiBox1.addItemListener(this);
        pontoonBox1.addItemListener(this);
        rowBoatBox1.addItemListener(this);
        kayakBox1.addItemListener(this);
        canoeBox1.addItemListener(this);
        beachChairBox1.addItemListener(this);
        umbrellaBox1.addItemListener(this);
        lessonBox1.addItemListener(this);
        noLessonBox1.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e1)
    {
        Object sourceval = e1.getSource();
        if(sourceval == hoursFieldval)
        {
            try
            {
                hours12 = Integer.parseInt(hoursFieldval.getText());
            }
            catch(Exception exc12)
            {
                hours12 = 0;
                hoursFieldval.setText("invalid entry");
            }
            housePriceval = hours12 * equipPriceval;
            priceval = housePriceval + lessonPriceval;
            timeStringval = "- for " + hours12 + " hours - ";
            outputval = "$" + priceval;
            totalPrice.setText(outputval);
            outputval = "Rental details: " + equipStringval + timeStringval + lessonStringval;
            explainLabel123.setText(outputval);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent check12)
    {
        Object source12 = check12.getItem();
        int select12 = check12.getStateChange();
        final int HIGH_PRICEval = 40;
        final int MED_PRICEval = 20;
        final int LOW_PRICEval = 7;
        final int LESSON_PRICEval = 5;
        if(select12 == ItemEvent.SELECTED)
        {
            if(source12 == jetSkiBox1)
            {
                equipStringval = "- Jet Ski is $" + HIGH_PRICEval + " per hour - " ;
                equipPriceval = HIGH_PRICEval;
            }
            else
            if(source12 == pontoonBox1)
            {
                equipStringval = "- Pontoon boat is $" + HIGH_PRICEval + " per hour - " ;
                equipPriceval = HIGH_PRICEval;
            }
            else if(source12 == rowBoatBox1)
            {
                equipStringval = " - Rowboat is $" + MED_PRICEval + " per hour - " ;
                equipPriceval = MED_PRICEval;
            }
            else if(source12 == canoeBox1)
            {
                equipStringval = "- Canoe is $" + MED_PRICEval + " per hour - " ;
                equipPriceval = MED_PRICEval;
            }
            else if(source12 == kayakBox1)
            {
                equipStringval = " - Kayak is $" + MED_PRICEval + " per hour - " ;
                equipPriceval = MED_PRICEval;
            }
            else if(source12 == beachChairBox1)
            {
                equipStringval = " - Beach Chair is $" + LOW_PRICEval + " per hour - " ;
                equipPriceval = LOW_PRICEval;
            }
            else if(source12 == umbrellaBox1)
            {
                equipStringval = " - Umbrella is $" + LOW_PRICEval + " per hour - " ;
                equipPriceval = LOW_PRICEval;
            }
            else if(source12 == lessonBox1)
            {
                lessonStringval = " - Lesson is $" + LESSON_PRICEval;
                lessonPriceval = LESSON_PRICEval;
            }
            else
            {
                lessonStringval = " - no lesson";
                lessonPriceval = 0;
            }
            housePriceval = hours12 * equipPriceval;
            priceval = housePriceval + lessonPriceval;
            outputval = "$" + priceval;
            totalPrice.setText(outputval);
            outputval = "Rental details information: " + equipStringval + timeStringval + lessonStringval;
            explainLabel123.setText(outputval);
        }
    }

    public static void main(String[] args)
    {
        JSammysSeashore frame12 = new JSammysSeashore();
        frame12.setSize(600, 250);
        frame12.setVisible(true);
    }
}
