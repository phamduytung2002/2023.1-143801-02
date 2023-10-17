import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MyCalc extends WindowAdapter implements ActionListener {
    Frame f;
    Label l1;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    Button badd, bsub, bmult, bdiv, bmod, bcalc, bclr, bpts, bneg, bback;
    double xd;
    double num1, num2, check;

    MyCalc() {
        f = new Frame("MY CALCULATOR");
        l1 = new Label();
        l1.setBackground(Color.LIGHT_GRAY);
        l1.setBounds(50, 50, 260, 60);

        b1 = new Button("1");
        b1.setBounds(50, 340, 50, 50);
        // Add more number buttons and position them

        badd = new Button("+");
        badd.setBounds(260, 340, 50, 50);
        // Add more operator buttons and position them

        bclr = new Button("CE");
        bclr.setBounds(50, 130, 65, 50);

        // Add action listeners to buttons
        b1.addActionListener(this);
        // Add action listeners for other buttons

        f.addWindowListener(this);
        f.add(l1);

        // Add other components to the frame

        f.setSize(360, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        String z, zt;

        // Handle number button clicks
        if (e.getSource() == b1) {
            zt = l1.getText();
            z = zt + "1";
            l1.setText(z);
        }
        // Add similar code for other number buttons

        // Handle arithmetic operator buttons
        if (e.getSource() == badd) {
            try {
                num1 = Double.parseDouble(l1.getText());
            } catch (NumberFormatException f) {
                l1.setText("Invalid Format");
                return;
            }
            z = "";
            l1.setText(z);
            check = 1;
        }
        // Add similar code for other operator buttons

        // Handle the equals button for calculation
        if (e.getSource() == bcalc) {
            try {
                num2 = Double.parseDouble(l1.getText());
            } catch (Exception f) {
                l1.setText("ENTER NUMBER FIRST ");
                return;
            }
            if (check == 1)
                xd = num1 + num2;
            // Add similar calculations for other operators
            l1.setText(String.valueOf(xd));
        }

        // Handle the clear button to reset the calculator
        if (e.getSource() == bclr) {
            num1 = 0;
            num2 = 0;
            check = 0;
            xd = 0;
            z = "";
            l1.setText(z);
        }
    }

    public static void main(String args[]) {
        new MyCalc();
    }
}
