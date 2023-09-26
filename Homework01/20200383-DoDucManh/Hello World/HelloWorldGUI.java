import javax.swing.*;

public class HelloWorldGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        JLabel nameLabel = new JLabel("Enter your name: ");
        JTextField nameField = new JTextField(20);
        JButton greetButton = new JButton("Greet");
        JLabel greetingLabel = new JLabel("");
        JPanel panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(greetButton);
        panel.add(greetingLabel);
        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        greetButton.addActionListener(e -> {
            String name = nameField.getText();
            greetingLabel.setText("Hello, " + name + "!");
        });
    }
}
