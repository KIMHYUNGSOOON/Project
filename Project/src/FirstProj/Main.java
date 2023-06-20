package FirstProj;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        //메인 프레임 ------------------------
        Frame f = new Frame("Main");
        f.setSize(700, 700);

        //메인 1번 서브 -------------------------------------
        Frame q = new Frame("Roulette");
        q.setSize(700, 700);

        //메인 2번 서브 ------------------------------------
        Frame w = new Frame("frame 2");
        w.setSize(700,700);
        w.setLocation(100, 75);

        //메인 버튼 1번 -----------------------------------------
        Button b = new Button("1");
        b.setSize(100, 50);
        b.setLocation(100, 75);
        b.setBounds(50, 400, 100, 50);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                q.setVisible(true);
            }
        });

        //메인버튼 2번 ---------------------------------------------
        Button c = new Button("2");
        c.setSize(100, 50);
        c.setLocation(100, 75);
        c.setBounds(220, 400, 100, 50);

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                w.setVisible(true);
            }
        });

        //메인버튼 2번 서브 -----------------------------------------
        Button l = new Button("뒤로가기");
        l.setSize(10, 10);
        l.setLocation(0, 0);
        l.setBounds(100, 100, 10, 10);

        l.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w.setVisible(false);
                f.setVisible(true);
            }
        });

        //메인버튼 3번 ---------------------------------------------
        Button d = new Button("3");
        d.setSize(100, 50);
        d.setLocation(100, 75);
        d.setBounds(390, 400, 100, 50);

        //메인버튼 4번 ---------------------------------------
        Button btn4 = new Button("4");
        btn4.setSize(100, 50);
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
        
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        LunchMenuRoulette frame = new LunchMenuRoulette();
                        frame.setVisible(true);
                    }
                });
            }
        });
        // 버튼 4 클릭시 awt캘린더 메소드를 불러옴
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
        w.setVisible(false);
        w.setLayout(new FlowLayout());
        w.add(l);
    }
}