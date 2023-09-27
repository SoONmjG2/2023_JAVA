import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MyFrame2 extends JPanel implements ItemListener {
	JCheckBox [] buttons = new JCheckBox[4];
	String [] items = {"엔진오일 교환", "자동변속기오일교환", "에어콘필터교환", "타이머교환"};
	int [] prices= {45000,80000,30000,100000};
	int money=0;
	JLabel label;	

	public MyFrame2() {
		super();

		for (int i = 0; i < items.length; i++) {
            JCheckBox checkbox = new JCheckBox(items[i]);
            checkbox.addItemListener(this); 
            buttons[i] = checkbox;
            add(checkbox);
        }

        label = new JLabel("현재까지의 가격은" + money+ "입니다.");
        add(label);
    }

    public void itemStateChanged(ItemEvent e) {
        for (int i = 0; i < items.length; i++) {
            if (e.getSource() == buttons[i]) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    money += prices[i];
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    money -= prices[i];
                }            
            }           
        }

        label.setText("현재까지의 가격은" + money+"입니다.");
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("CheckBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new MyFrame2();
		newContentPane.setVisible(true);
		frame.setContentPane(newContentPane);
		frame.setSize(500,200);
		frame.setVisible(true);		

	}

}