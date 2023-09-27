// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it.

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class HelloWorldGUI extends JFrame{

    private JLabel instructor = new JLabel("Nhap ten cua ban");
    private JTextField name  = new JTextField(30);
    private JButton okButton = new JButton("OK");
    private JLabel helloTextArea = new JLabel("");


    HelloWorldGUI() {

        JPanel panel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        panel.add(instructor);
        panel.add(name);
        panel.add(okButton);
        panel.add(helloTextArea);

        this.add(panel);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nameText = name.getText();
                helloTextArea.setText("Hello " + nameText);
            }
        });
    }

    public static void main(String[] args) {
        HelloWorldGUI helloWorldGUI = new HelloWorldGUI();
        helloWorldGUI.setVisible(true);
    }

}