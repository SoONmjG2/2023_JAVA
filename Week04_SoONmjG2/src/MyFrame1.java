import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class Person {
	String name;
	String tel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel=tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	String address;
	public Person(String name, String tel, String address) {
		super();
		this.name=name;
		this.tel=tel;
		this.address=address;
	}
}

public class MyFrame1 extends JFrame{ 
	ArrayList<Person> list = new ArrayList<>();
	
	public MyFrame1() {
		setTitle("Address Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,360,252);
		JPanel panel= new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel label1= new JLabel("이름");
		label1.setBounds(12, 10, 57, 15);
		panel.add(label1);
		
		JLabel label2= new JLabel("전화번호");
		label2.setBounds(12, 42, 57, 15);
		panel.add(label2);
		
		JTextField text1= new JTextField();
		text1.setBounds(81, 7, 243, 21);
		text1.setColumns(10);
		panel.add(text1);
		
		JTextField text2= new JTextField();
		text2.setBounds(81, 39, 243, 21);
		text2.setColumns(10);
		panel.add(text2);
		
		
		JLabel label3= new JLabel("주소");
		label3.setBounds(12, 79, 57, 15);
		panel.add(label3);
		
		JTextArea textArea=new JTextArea();
		textArea.setBounds(12, 104, 312, 67);
		panel.add(textArea);
		
		JButton button = new JButton("저장");
		button.setBounds(12, 181, 97, 23);
		panel.add(button);
		button.addActionListener(e -> {
			String name= text1.getText();
			String tel=text2.getText();
			String address=textArea.getText();
			list.add(new Person(name,tel,address));
		});
		JButton button2=new JButton("검색");
		button2.setBounds(117, 181, 97, 23);
		panel.add(button2);
		button2.addActionListener(e-> {
			String name=text1.getText();
			for (Person p : list) {
				if (p.getName().equals(name)) {
					text2.setText(p.getTel());
					textArea.setText(p.getAddress());
				}
			}
		});
		JButton button3=new JButton("종료");
		button3.setBounds(227, 181, 97, 23);
		panel.add(button3);
		button3.addActionListener(e-> {
			System.exit(0);
		});
		}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable () {
			public void run() {
				try {
					MyFrame1 frame = new MyFrame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
