
package FirstProj;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // 메인 프레임 ------------------------
        Frame f = new Frame("Main");
        f.setLayout(new GridLayout(2, 2));
        f.setSize(450, 400);
        f.setLocationRelativeTo(null);
        // 메인 1번 서브 -------------------------------------
        Frame q = new Frame("Roulette");
        q.setSize(700, 700);

        // 메인 2번 서브 ------------------------------------
//        Frame w = new Frame("frame 2");
//        w.setSize(700, 700);
//        w.setLocation(100, 75);
        
        

        // 메인 버튼 1번 -----------------------------------------
        Button b = new Button("점심 룰렛");
        b.setPreferredSize(new Dimension(150, 150));
        b.setSize(100, 100);
        b.setBounds(200, 200, 100, 100);
        
        
        // 메인 1번버튼을 누르면 점심룰렛 프레임으로 넘어감
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new RouletteFrame().setVisible(true);
            }
        });

        // 메인버튼 2번 ---------------------------------------------
        Button c = new Button("식당 검색");
        c.setPreferredSize(new Dimension(150, 150));
        c.setLocation(100, 75);
        c.setBounds(220, 400, 100, 50);

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Search.main(new String[0]);
//                TableExample frame =new TableExample();
//                new SearchFrame().setVisible(true);
//            	frame.setVisible(true);
                
            }
        });

        // 메인버튼 3번 ---------------------------------------------
        Button d = new Button("추천 점심");
        d.setPreferredSize(new Dimension(150, 150));
        d.setLocation(100, 75);
        d.setBounds(390, 400, 100, 50);

        // 메인버튼 4번 ---------------------------------------
        Button btn4 = new Button("최근 먹은메뉴");
        btn4.setPreferredSize(new Dimension(150, 150));
        btn4.setLocation(100, 75);
        btn4.setBounds(560, 400, 100, 50);
        
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        q.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        //3번 버튼을 누르면 점심룰렛창으로 넘어감
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        LunchMenuRoulette frame = new LunchMenuRoulette();
                        frame.setVisible(true);
                        f.dispose(); 
                    }
                });
            }
        });
        //4번 버튼을 누르면 캘린더창으로 넘어감
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AwtCalendar.main(new String[0]);
            }
        });

        f.setLayout(new FlowLayout());
        f.add(b);
        f.add(c);
        f.add(d);
        f.add(btn4);
        f.setVisible(true);
        q.setVisible(false);
    }
}