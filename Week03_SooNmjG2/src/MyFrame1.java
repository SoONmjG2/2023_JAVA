import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame1 extends JFrame {

	public MyFrame1() {
		setSize(300,150);
		JPanel panel = new JPanel();
		add(panel);

		JLabel label1 = new JLabel("회원 등록하기");		
		JLabel label2 = new JLabel("이름");	
		JTextField text1 = new JTextField(10);
		JLabel label3 = new JLabel("패스워드");
		JPasswordField pass = new JPasswordField(10);
		JLabel label4 = new JLabel("이메일 주소");	
		JTextField text2 = new JTextField(20);
		JLabel label5 = new JLabel("전화번호");
		JTextField text3 = new JTextField(10);
			
		JButton button1 = new JButton("등록하기");		
		JButton button2 = new JButton("취소");
		
		panel.add(label1);
		panel.add(label2);
		panel.add(text1);
		panel.add(label3);
		panel.add(pass);
		panel.add(label4);
		panel.add(text2);
		panel.add(label5);
		panel.add(text3);
		
		panel.add(button1);
		panel.add(button2);
		
		setVisible(true);

	}
	public static void main(String[] args) {
		MyFrame1 f = new MyFrame1();
	}
}