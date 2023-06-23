package sdad;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main extends Frame implements ItemListener {
    private Choice chyear = new Choice(); // 연도 선택
    private Choice chmonth = new Choice(); // 월 선택

    private Label yLabel = new Label("년");
    private Label mLabel = new Label("월");
    private GregorianCalendar gc; // 캘린더
    private int year, month; // 위치 지정
    private Dimension dimen, dimen1;
    private int xpos, ypos;

    private Label[] dayLabel = new Label[7];
    private String day[] = { "일", "월", "화", "수", "목", "금", "토" }; // 날짜 배치용 버튼
    private Button[] days = new Button[42];

    private Panel selectPanel = new Panel();

    private GridLayout grid = new GridLayout(7, 7, 5, 5);

    private Calendar ca = Calendar.getInstance();

    Main() { // 생성자
        this.setTitle("Main");
        this.setSize(700, 700);
        dimen = Toolkit.getDefaultToolkit().getScreenSize();
        dimen1 = this.getSize();
        xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
        ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
        this.setLocation(xpos, ypos);
        this.setResizable(false);
        this.setVisible(true);

        init();

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });
    }

    public void init() {
        select();
        Calendar();
    }

    // 기본 폼 만들기
    public void select() {
        Panel panel = new Panel(grid);
        // year
        for (int i = 2023; i >= 2000; i--) {
            chyear.add(String.valueOf(i));
        }
        // month
        for (int i = 1; i <= 12; i++) {
            chmonth.add(String.valueOf(i));
        }
        // week
        for (int i = 0; i < day.length; i++) {
            dayLabel[i] = new Label(day[i], Label.CENTER);
            panel.add(dayLabel[i]);
            dayLabel[i].setBackground(Color.gray);
        }
        dayLabel[6].setForeground(Color.blue);// 토요일 색상
        dayLabel[0].setForeground(Color.RED);// 일요일 색상

        for (int i = 0; i < 42; i++) {
            days[i] = new Button("");
            if (i % 7 == 6)
                days[i].setForeground(Color.RED);// 일요일 색상
            if (i % 7 == 0)
                days[i].setForeground(Color.BLUE);// 토요일 색상
            panel.add(days[i]);
            days[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    dialog();
                }
            });
        }

        chyear.addItemListener(this);
        chmonth.addItemListener(this);

        selectPanel.setLayout(new FlowLayout());
        selectPanel.add(chyear);
        selectPanel.add(yLabel);
        selectPanel.add(chmonth);
        selectPanel.add(mLabel);

        this.add(selectPanel, "North");
        this.add(panel, "Center");
    }

    // 날짜 배치
    public void Calendar() {
        gc = new GregorianCalendar(Integer.parseInt(chyear.getSelectedItem()),
                Integer.parseInt(chmonth.getSelectedItem()) - 1, 1);

        year = gc.get(Calendar.YEAR);
        month = gc.get(Calendar.MONTH) + 1;
        chyear.select(Integer.parseInt(String.valueOf(year)));
        chmonth.select(Integer.parseInt(String.valueOf(month)));
        for (int i = 0; i < 42; i++) {
            days[i].setLabel("");
            days[i].setEnabled(true);
            days[i].setBackground(Color.WHITE);
        }

        int cnt = gc.get(Calendar.DAY_OF_WEEK) - 1;
        int j = 0;
        int hopping = cnt;
        if (gc.get(Calendar.DAY_OF_WEEK) == 1) {
            hopping = 7;
        }
        for (int i = hopping - 1; i < gc.getActualMaximum(Calendar.DATE) + hopping - 1; i++) {
            j++;
            days[i].setLabel(String.valueOf(j));
        }
        for (int i = 0; i < 42; i++) {
            if (days[i].getLabel().equals(""))
                days[i].setEnabled(false);
        }
    }

    // 다이얼로그 설정
    public void dialog() {
        Dialog dig = new Dialog(this, "Event", true);
        dig.setLayout(new FlowLayout());
        dig.setSize(400, 200);

        Button btnA = new Button("일정등록");
        Button btnB = new Button("일정확인");
        Button btnC = new Button("일정삭제");
        Button btnD = new Button("닫기");
        
        // 일정 등록 버튼
        btnA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent btnEvent) {
                dig.dispose();
                // 여기에 일정 등록 기능을 추가하세요.
            }
        });

        // 일정 확인 버튼
        btnB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent btnEvent) {
                dig.dispose();
                // 여기에 일정 확인 기능을 추가하세요.
            }
        });

        // 일정 삭제 버튼
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent btnEvent) {
                dig.dispose();
                // 여기에 일정 삭제 기능을 추가하세요.
            }
        });

        // 닫기 버튼
        btnD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent btnEvent) {
                dig.dispose();
            }
        });

        dig.add(btnA);
        dig.add(btnB);
        dig.add(btnC);
        dig.add(btnD);
        dig.setVisible(true);
    }

    // 아이템 이벤트 설정
    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == chyear || ie.getSource() == chmonth) {
            Calendar();
        }
    }

    public static void main(String[] args) {
        new Main1();
    }
}