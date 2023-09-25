import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends JFrame {

    public MyFrame2() {
        setTitle("Mile->Km");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("마일을 입력하시오:");
        JTextField text1 = new JTextField(10);
        JLabel label2 = new JLabel("->");
        JTextField text2 = new JTextField(10);
        JButton button = new JButton("변환");


        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    double miles = Double.parseDouble(text1.getText());
                    double kilometers = miles * 1.60934;
                    text2.setText(String.format("%f",kilometers)+" Km");
            }
        });

        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        panel.add(button);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
    	MyFrame2 f= new MyFrame2();
    }
}