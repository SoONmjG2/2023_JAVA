import java.awt.event.*;
import javax.swing.*;

public class MyFrame3 extends JFrame {
    int img_x = 150, img_y = 150;
    JButton button;
    JButton leftbutton;
    JButton rightbutton;

    public MyFrame3() {
        setSize(600, 300);
        button = new JButton("");

        ImageIcon icon = new ImageIcon("d:\\car.gif");
        button.setIcon(icon);
        JPanel panel = new JPanel();

        panel.setLayout(null);

        leftbutton = new JButton("왼쪽");
        rightbutton = new JButton("오른쪽");

        leftbutton.setBounds(280, img_y + 200, 100, 30); 
        rightbutton.setBounds(400, img_y + 200, 100, 30); 

        button.setBounds(img_x, img_y, 200, 200);
        panel.add(leftbutton);
        panel.add(rightbutton);
        panel.add(button);
        panel.requestFocus();
        panel.setFocusable(true);

        leftbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_x -= 10;
                button.setBounds(img_x, img_y, 200, 200); 
            }
        });

        rightbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img_x += 10;
                button.setBounds(img_x, img_y, 200, 200); 
            }
        });

        add(panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MyFrame3 f = new MyFrame3();
        
    }
}