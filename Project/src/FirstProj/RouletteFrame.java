package FirstProj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RouletteFrame extends Frame {
    private JButton spinButton;
    private JButton increaseButton;
    private JButton decreaseButton;
    private JButton backButton;
    
    private boolean spinning;
    private int currentAngle;
    private int numOfSections;
    private int result;
    private int rotationSpeed;
    private JTextField[] memoFields;
    private Map<Integer, String> memoMap;

    public RouletteFrame() {
        setTitle("Roulette");
        setSize(1600, 800);
        setLocationRelativeTo(null);
        setLayout(null);

        backButton = new JButton("뒤로가기");
        backButton.setBounds(50, 50, 90, 55);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Main.main(new String[0]);
            }
        });
        add(backButton);

        numOfSections = 2; // 초기 칸 수
        rotationSpeed = 10; // 룰렛 회전 속도 (angle 증가 값)
        memoFields = new JTextField[numOfSections];
        memoMap = new HashMap<>();
        
        increaseButton = new JButton("+");
        increaseButton.setBounds(1300, 600, 50, 55);
        increaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!spinning) {
                    increaseNumOfSections();
                }
            }
        });
        add(increaseButton);

        decreaseButton = new JButton("-");
        decreaseButton.setBounds(1350, 600, 50, 55);
        decreaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!spinning) {
                    decreaseNumOfSections();
                }
            }
        });
        add(decreaseButton);

        spinButton = new JButton("시작");
        spinButton.setBounds(1400, 600, 113, 55);
        spinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!spinning) {
                    spinning = true;
                    spinRoulette();
                }
            }
        });
        add(spinButton);

        int fieldWidth = 200;
        int fieldHeight = 30;
        int fieldX = 350; // 메모 칸 위치 (오른쪽)
        int fieldY = 50; // 오른쪽 맨 위로 이동

        addMemoFields(numOfSections, fieldX, fieldY, fieldWidth, fieldHeight); // 초기 칸 수에 맞게 메모 칸 추가

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(getWidth(), getHeight()) / 3 - 30;
        double sectionAngle = 360.0 / numOfSections;
        
        for (int i = 0; i < numOfSections; i++) {
            int startAngle = (int) (i * sectionAngle + currentAngle) % 360;
            int endAngle = (int) ((i + 1) * sectionAngle + currentAngle) % 360;

            g.setColor(getSectionColor(i));
            g.fillArc(centerX - radius, centerY - radius, radius * 2, radius * 2, startAngle, (int) sectionAngle);
            g.setColor(Color.BLACK);
            g.drawArc(centerX - radius, centerY - radius, radius * 2, radius * 2, startAngle, (int) sectionAngle);
        }
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("", Font.BOLD, 24));
        g.drawString("", centerX - 40, centerY + 10);
    }

    private Color getSectionColor(int sectionIndex) {
        int hue = (sectionIndex * 360 / numOfSections) % 360;
        return Color.getHSBColor(hue / 360.0f, 1.0f, 1.0f);
    }

    private void increaseNumOfSections() {
        if (numOfSections < 6) {
            numOfSections++;
            addMemoFields(1, 350, 50 + (numOfSections - 1) * 40, 200, 30); // 메모 칸 추가
            repaint();
        }
    }
    
    private void decreaseNumOfSections() {
        if (numOfSections > 2) {
            numOfSections--;
            removeMemoFields(1); // 메모 칸 제거
            repaint();
        }
    }

    private void addMemoFields(int count, int x, int y, int width, int height) {
        JTextField[] newFields = new JTextField[memoFields.length + count];
        for (int i = 0; i < memoFields.length; i++) {
            newFields[i] = memoFields[i];
        }

        for (int i = memoFields.length; i < newFields.length; i++) {
            newFields[i] = new JTextField();
            newFields[i].setBounds(x, y, width, height);
            add(newFields[i]);
            y += height + 10;
        }

        memoFields = newFields;
    }

    private void removeMemoFields(int count) {
        JTextField[] newFields = new JTextField[memoFields.length - count];
        for (int i = 0; i < newFields.length; i++) {
            newFields[i] = memoFields[i];
            remove(memoFields[i + count]);
        }

        memoFields = newFields;
    }

    private void spinRoulette() {
        Random random = new Random();
        //        result = random.nextInt(numOfSections) + 1;
        result = (int) (random.nextDouble() * numOfSections) + 1; // 결과값

        new Thread(new Runnable() {
            public void run() {
                int angle = 0;
                int rotationCount = 0;
                int finalAngle = 360 * 5 + (result - 1) * (360 / numOfSections);

                while (rotationCount < finalAngle) {
                    currentAngle = angle % 360;
                    repaint();
                    try {
                        Thread.sleep(rotationSpeed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    angle += rotationSpeed;
                    rotationCount += rotationSpeed;
                }

                memoMap.clear();
                for (int i = 0; i < numOfSections; i++) {
                    if (memoFields[i] != null) {
                        memoMap.put(i + 1, memoFields[i].getText());
                    }
                }

                String message = "결과: " + result;
                JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE);
                spinning = false;
            }
        }).start();
    }

    public static void main(String[] args) {
        new RouletteFrame();
    }
}