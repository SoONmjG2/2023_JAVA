import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyFrame3 extends JFrame {
    public MyFrame3() {
        setTitle("Bussiness Card");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 200);
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel label1 = new JLabel("김덕성");
        label1.setBounds(170, 50, 57, 15);
        panel.add(label1);

        JLabel label2 = new JLabel("프로젝트 매니저");
        label2.setBounds(170, 70, 120, 15); 
        panel.add(label2);

        JLabel label3 = new JLabel("덕성주식회사");
        label3.setBounds(170, 90, 120, 15); 
        panel.add(label3);

        ImageIcon icon = new ImageIcon("d:\\car.jpg"); //이미지출력오류해결필요

        // JLabel을 사용하여 이미지 표시
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(30, 70, 100, 100); 
        panel.add(imageLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame3 f = new MyFrame3();
    }
}
