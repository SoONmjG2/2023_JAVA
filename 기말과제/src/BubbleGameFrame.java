import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BubbleGameFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GameFrame();
        });
    }
}

class GameFrame extends JFrame{
    private GamePanel gamePanel;

    public GameFrame() {
        setTitle("버블 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel();
        setLayout(new BorderLayout());
        add(gamePanel, BorderLayout.CENTER);

        //버튼
        JPanel controlPanel = new JPanel();
        JButton startB = new JButton("시작");
        //JButton pauseB = new JButton("일시정지");
        JButton stopB = new JButton("끝");

        startB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gamePanel.startBubble();
            }
        });
        
        //일시정지 버튼 
        //pauseButton.addActionListener(new ActionListener() {
            //public void actionPerformed(ActionEvent e) {
                //gamePanel.pauseBubbles();
            //}
        //});

        stopB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gamePanel.stopBubble();
                dispose();
            }
        });

        controlPanel.add(startB);
      //controlPanel.add(pauseB);
        controlPanel.add(stopB);

        add(controlPanel, BorderLayout.SOUTH);

        setSize(500, 500);
        setVisible(true);
    }
}

class GamePanel extends JPanel {
    private boolean run;
    private Timer timer;
    private int score;
    private JLabel scoreL;

    public GamePanel() {
        setLayout(null);

        // 배경 이미지 설정
        Image background1 = new ImageIcon("sky.jpg").getImage();
        Image background2= new ImageIcon("end.png").getImage();

        // 이미지 마우스 클릭 
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                BubbleClick(e.getX(), e.getY());
            }
        });
        
        //점수
        scoreL = new JLabel("Score: 0");
        scoreL.setBounds(10, 10, 80, 20);
        add(scoreL);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 100점 이상일 때 배경 이미지 변경
        if (score >= 100) {
        	g.drawImage(new ImageIcon("end.png").getImage(), 0, 0, getWidth(), getHeight(), this);
        } else {
        	 g.drawImage(new ImageIcon("sky.jpg").getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void startBubble() {
        run = true;
        score = 0;

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (run) {
                    int x = (int) (Math.random() * getWidth());
                    int y = (int) (Math.random() * getHeight());
                    int randomImage = (int) (Math.random() * 3); // 0: bubble, 1: red, 2: star
                    new BubbleThread(x, y, randomImage).start();
                }
            }
        });

        timer.start();
    }

    public void stopBubble() {
        run = false;
        if (timer != null) {
            timer.stop();
        }
    }

    private void BubbleClick(int x, int y) {
        for (int i = 0; i < getComponentCount(); i++) {
            if (getComponent(i) instanceof JLabel) {
                JLabel bubble = (JLabel) getComponent(i);
                if (bubble.getBounds().contains(x, y)) {
                    int bubbleType = (int) bubble.getClientProperty("type");
                    removeBubble(bubble);
                    upScore(bubbleType);
                    break;
                }
            }
        }
    }

    private void removeBubble(JLabel bubble) {
        SwingUtilities.invokeLater(() -> {
            remove(bubble);
            repaint();
        });
    }

    private void upScore(int bubbleType) {
        int points;

        if (bubbleType == 0) { // Bubble
            points = 1;
        } else if (bubbleType == 1) { // Red
            points = 5;
        } else if (bubbleType == 2) { // Star
            points = 10;
        } else {
            points = 0;
        }

        score += points;
        SwingUtilities.invokeLater(() -> {
            scoreL.setText("Score: " + score);

            // 100점 이상이면 배경 이미지 변경
            if (score >= 100) {
                stopBubble();
                repaint(); 
            }
        });
    }

    class BubbleThread extends Thread {
        private JLabel bubble;

        public BubbleThread(int bubbleX, int bubbleY, int bubbleType) {
            ImageIcon img;
            switch (bubbleType) {
                case 0: // Bubble
                    img = new ImageIcon("bubble.jpg");
                    break;
                case 1: // Red
                    img = reImageIcon("red.jpg", 30, 30);
                    break;
                case 2: // Star
                    img = reImageIcon("star.jpg", 30, 30);
                    break;
                default:
                    img = new ImageIcon("bubble.jpg");
                    break;
            }

            bubble = new JLabel(img);
            bubble.setSize(img.getIconWidth(), img.getIconHeight());
            bubble.setLocation(bubbleX, bubbleY);
            bubble.putClientProperty("type", bubbleType);
            add(bubble);
            repaint();
        }

        private ImageIcon reImageIcon(String imagePath, int width, int height) {
            ImageIcon Image1 = new ImageIcon(imagePath);
            Image Image2 = Image1.getImage();
            Image Image3 = Image2.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            return new ImageIcon(Image3);
        }

        public void run() {
            while (bubble.getY() > 0 && run) {
                int x = bubble.getX();
                int y = bubble.getY() - 5;
                bubble.setLocation(x, y);

                SwingUtilities.invokeLater(() -> {
                    repaint();
                });

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (run) {
                SwingUtilities.invokeLater(() -> {
                    remove(bubble);
                });
            }
        }
    }
}


