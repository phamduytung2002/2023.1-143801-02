import javax.swing.*;

public class HelloWorldGUI {
    public static void main(String[] args) {
        // Tạo một frame (cửa sổ)
        JFrame frame = new JFrame("Hello World");

        // Tạo một label (nhãn) để hướng dẫn nhập tên
        JLabel nameLabel = new JLabel("Enter your name: ");
        
        // Tạo một ô văn bản để người dùng nhập tên
        JTextField nameField = new JTextField(20);
        
        // Tạo một nút để xác nhận và hiển thị lời chào
        JButton greetButton = new JButton("Greet");

        // Tạo một nhãn để hiển thị lời chào
        JLabel greetingLabel = new JLabel("");

        // Xây dựng giao diện
        JPanel panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(greetButton);
        panel.add(greetingLabel);
        frame.add(panel);

        // Thiết lập kích thước của frame
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Xử lý sự kiện khi nút "Greet" được nhấn
        greetButton.addActionListener(e -> {
            String name = nameField.getText();
            greetingLabel.setText("Hello, " + name + "!");
        });
    }
}
