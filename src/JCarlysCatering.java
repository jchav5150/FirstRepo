import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    public class JCarlysCatering extends JFrame implements ItemListener, ActionListener{

        FlowLayout flow =new FlowLayout();
        JTextField guestsText = new JTextField(20);
        JLabel guestsLabel = new JLabel("Please Enter number of guests");
        JCheckBox chicken = new JCheckBox("Chicken",false);
        JCheckBox beef = new JCheckBox("Beef",false);
        JCheckBox fish = new JCheckBox("Fish",false);
        JCheckBox mashedPotatoes = new JCheckBox("Mashed Potatoes",false);
        JCheckBox coleslaw = new JCheckBox("Coleslaw",false);
        JCheckBox corn = new JCheckBox("Corn",false);
        JCheckBox iceCream = new JCheckBox("Vanilla Ice Cream",false);
        JCheckBox pie = new JCheckBox("Apple Pie",false);
        JCheckBox pizookie = new JCheckBox("Pizookie",false);
        JLabel mainLabel = new JLabel("Carly's Catering!");
        Font font = new Font("Times New Roman", Font.BOLD, 30);
        JLabel label1 = new JLabel("Select a Main Course:");
        JLabel label2 = new JLabel("");
        JLabel tprice= new JLabel("");
        double price = 0;
        String mainCourse = "";
        String sides = "";
        String dessert = "";
        String output;
        int numSelected = 0;
        final int PRICE_PER_GUEST = 35;
        public JCarlysCatering(){
            super("Menu options");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(flow);
            ButtonGroup entreegrp = new ButtonGroup();
            entreegrp.add(chicken);
            entreegrp.add(beef);
            entreegrp.add(fish);
            ButtonGroup dessertgrp = new ButtonGroup();
            dessertgrp.add(iceCream);
            dessertgrp.add(pie);
            dessertgrp.add(pizookie);
            add(mainLabel);
            mainLabel.setFont(font);
            add(guestsLabel);
            add(guestsText);
            add(label1);
            add(chicken);
            add(beef);
            add(fish);
            add(new JLabel("Select upto 2 side items:"));
            add(mashedPotatoes);
            add(coleslaw);
            add(corn);
            add(new JLabel("Select dessert:"));
            add(iceCream);
            add(pie);
            add(pizookie);
            add(label2);
            add(tprice);
            tprice.setText("Total = $0");
            guestsText.addActionListener(this);
            chicken.addItemListener(this);
            beef.addItemListener(this);
            fish.addItemListener(this);
            mashedPotatoes.addItemListener(this);
            coleslaw.addItemListener(this);
            corn.addItemListener(this);
            iceCream.addItemListener(this);
            pie.addItemListener(this);
            pizookie.addItemListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e){
            Object source = e.getSource();
            if(source == guestsText){
                try{
                    price = Integer.parseInt(guestsText.getText())*PRICE_PER_GUEST;
                }
                catch(Exception exc)
                {
                    price = 0;
                    guestsText.setText("0");
                }
                output = "Total = $" + price + " "+"Menu includes" + mainCourse + sides + dessert +"";
                tprice.setText(output);
            }
        }

        @Override
        public void itemStateChanged(ItemEvent check){
            Object source = check.getSource();
            int select = check.getStateChange();
            if(select == ItemEvent.SELECTED)
                if(source == chicken)
                    mainCourse = "-Chicken-";
                else if(source == beef)
                    mainCourse = "-Beef-";
                else if(source == fish)
                    mainCourse = "-Fish-";
            if(select == ItemEvent.SELECTED)
                if(source == iceCream)
                    dessert = "-Vanilla Ice Cream-";
                else if(source == pie)
                    dessert = "-Apple Pie Slice-";
                else if(source == pizookie)
                    dessert = "-Pizookie-";
            if(source == mashedPotatoes || source == coleslaw || source == corn)
            {
                if(select == ItemEvent.SELECTED)
                    ++numSelected;
                else
                    --numSelected;
                sides = "";
                if(numSelected <= 2)
                {
                    if(mashedPotatoes.isSelected())
                        sides += "-Mashed Potatoes-";
                    if(coleslaw.isSelected())
                        sides += "-Coleslaw-";
                    if(corn.isSelected())
                        sides += "-Corn-";
                }
                else
                {
                    mashedPotatoes.setSelected(false);
                    coleslaw.setSelected(false);
                    corn.setSelected(false);
                }
            }

            try{
                price = Integer.parseInt(guestsText.getText())*PRICE_PER_GUEST;
            }
            catch(Exception e)
            {
                price = 0;
                guestsText.setText("0");
            }
            output = "Total = $" + price + " "+"Menu includes " + mainCourse + sides + dessert +"";
            tprice.setText(output);
        }

        public static void main(String[] args)
        {
            JCarlysCatering frame = new JCarlysCatering();
            frame.setSize(450,400);
            frame.setVisible(true);
        }
    }

