package FirstProj;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LunchMenuRoulette extends JFrame {
    private JLabel resultLabel;
    private JButton recommendButton,backButton;
    private String[] menuOptions = {
            "피자",
            "햄버거",
            "자장면",
            "초밥",
            "샐러드",
            "김밥",
            "떡볶이",
            "파스타",
            "카레",
            "치킨",
            "제육볶음"
    };

    public LunchMenuRoulette() {
        setTitle("랜덤추천점심");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        backButton = new JButton("뒤로가기"+new ImageIcon(""));  //버튼 이미지 설정 
        backButton.addActionListener(new ActionListener() {	  // 백버튼을 누르면 실행
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Main.main(new String[0]);						// 메인창이 열림
        	}
        });
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        resultLabel = new JLabel("오늘의 추천메뉴는??");
        resultLabel.setFont(new Font("", Font.BOLD, 13));
        panel.add(resultLabel);
        
        recommendButton = new JButton("돌리기");
        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recommendMenu();
            }
        });
        panel.add(recommendButton);
        panel.add(backButton);
        add(panel);
    }

    private void recommendMenu() {
        Random random = new Random();
        int index = random.nextInt(menuOptions.length);
        String recommendedMenu = menuOptions[index];
        resultLabel.setText("이 메뉴를 추천합니다: " + recommendedMenu);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LunchMenuRoulette frame = new LunchMenuRoulette();
                frame.setVisible(true);
            }
        });
    }
}