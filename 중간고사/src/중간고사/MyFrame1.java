package 중간고사;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame1 extends JFrame {

	public MyFrame1() {
		setSize(300,150);
		setTitle("덕성여대 화이팅");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);

		JLabel label1 = new JLabel("학생 등록하기");
		label1.setBounds(12,10,100,15);
		JLabel label2 = new JLabel("이름");
		label2.setBounds(12,40,57,15);
		JTextField text1 = new JTextField(10);
		text1.setBounds(100,40,57,15);
	
		JLabel label3 = new JLabel("학번");	
		label3.setBounds(12,70,57,15);
		JTextField text2 = new JTextField(10);
		text2.setBounds(100,70,57,15);
	
		JLabel label4 = new JLabel("성적");	
		label4.setBounds(12,100,57,15);
		JTextField text3 = new JTextField(10);
		text3.setBounds(100,100,57,15);

		JButton button1 = new JButton("등록하기");
		button1.setBounds(50, 120, 97, 23);
		button1.addActionListener(e -> {
			String name=text1.getText();
			String num=text2.getText();
			String grade=text3.getText();
			System.out.println("이름: "+name+" 학번: "+num+" 성적: "+grade);
		});
		JButton button2 = new JButton("취소");
		button2.setBounds(200, 120, 97, 23);

		panel.add(label1);
		panel.add(label2);
		panel.add(text1);
		panel.add(label3);
		panel.add(text2);
		panel.add(label4);
		panel.add(text3);

		panel.add(button1);
		panel.add(button2);

		setVisible(true);

	}
	public static void main(String[] args) {
		MyFrame1 f = new MyFrame1();
	}
}