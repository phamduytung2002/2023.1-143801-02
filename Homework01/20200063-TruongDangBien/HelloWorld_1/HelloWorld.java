import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld extends Frame implements ActionListener {
    TextField b = new TextField();
    Label d = new Label();

    public HelloWorld() {
        setTitle("Hello World");
        setLayout(new FlowLayout());
        setSize(400, 200);
        setVisible(true);
        Label a = new Label("Nhập tên");
        b.setSize(200, 100);
        Button c = new Button("Confirm");
        c.addMouseListener(new ConfirmButtonListener());
        c.addActionListener(this);
        add(a);
        add(b);
        add(c);
        add(d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        d.setText("Xin chào " + b.getText());
        setVisible(true);

    }

    public static void main(String[] args) {
        HelloWorld demo = new HelloWorld();
    }


}
