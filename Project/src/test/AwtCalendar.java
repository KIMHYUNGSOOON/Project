package test;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AwtCalendar extends Frame implements ItemListener{
	private Choice chyear =new Choice(); // 연도 선택
	private Choice chmonth =new Choice(); // 월 선택
	
	
	
	private Label yLabel =new Label("년");
	private Label mLabel =new Label("월");
	private GregorianCalendar gc; //캘린더
	private int year,month; //위치 지정 
	private Dimension dimen,dimen1;
	private int xpos,ypos;
	
	private Label[]dayLabel=new Label[7];
	private String day[]= {"일","월","화","수","목","금","토"}; //날짜 배치용 버튼
	private Button[]days=new Button[42];
	
	private Panel selectPanel=new Panel();
	
	private GridLayout grid =new GridLayout(7,7,5,5);
	
	private Calendar ca =Calendar.getInstance();
	
	AwtCalendar(){  //생성자
		this.setTitle("캘린더");
		this.setSize(550,500);
		dimen =Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 =this.getSize();
		xpos =(int)(dimen.getWidth()/2-dimen1.getWidth()/2);
		ypos =(int)(dimen.getHeight()/2-dimen1.getHeight()/2);
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
	//기본 폼 만들기
	public void select() {
		Panel panel=new Panel(grid);
		//year
		for(int i=2023;i>=2000;i--) {
			chyear.add(String.valueOf(i));
		}
		//month
		for(int i=1;i<=12;i++) {
			chmonth.add(String.valueOf(i));
		}
		//week
		for(int i=0;i<day.length;i++) {
			dayLabel[i]=new Label(day[i],Label.CENTER);
			panel.add(dayLabel[i]);
			dayLabel[i].setBackground(Color.gray);
		}
		dayLabel[6].setForeground(Color.blue);//토요일 색상
		dayLabel[0].setForeground(Color.RED);// 일요일 색상
		
		for(int i=0;i<42;i++) {
			days[i]=new Button("");
			if(i%7==6)
				days[i].setForeground(Color.RED);// 일요일 색상
			else if(i%7 ==6)
				days[i].setForeground(Color.BLUE);// 토요일 색상
			else 
				days[i].setForeground(Color.BLACK);// 평일 색상
			panel.add(days[i]);
		}
		selectPanel.add(chyear);selectPanel.add(yLabel);
		selectPanel.add(chmonth);selectPanel.add(mLabel);
		
		this.add(selectPanel,"North");
		this.add(panel,"Center");
		
		String m=(ca.get(Calendar.MONTH)+1)+"";
		String y=ca.get(Calendar.YEAR)+"";
		
		chyear.select(y);
		chmonth.select(m);
		chyear.addItemListener((ItemListener) this);
		chmonth.addItemListener((ItemListener) this);
	}
	//달력 만들기
	public void Calendar() {
	    year = Integer.parseInt(chyear.getSelectedItem());
	    month = Integer.parseInt(chmonth.getSelectedItem());

	    gc = new GregorianCalendar(year, month - 1, 1);
	    int max = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
	    int week = gc.get(Calendar.DAY_OF_WEEK);

	    String today = Integer.toString(ca.get(Calendar.DATE));

	    int buttonIndex = week - 1; // 버튼 인덱스 초기화

	    for (int i = 1; i <= max; i++) {
	        days[buttonIndex].setLabel(String.valueOf(i));
	        days[buttonIndex].setBackground(Color.WHITE);
	        if (today.equals(days[buttonIndex].getLabel())) {
	            days[buttonIndex].setBackground(Color.green);//오늘 날짜
	        }
	        buttonIndex++;
	    }

	    // 나머지 버튼 초기화
	    for (int i = buttonIndex; i < 42; i++) {
	        days[i].setLabel("");
	        days[i].setBackground(Color.WHITE);
	    }
	}
	
	public void itemStateChanged(ItemEvent it) {
		if(it.getStateChange()==ItemEvent.SELECTED) {
			for(int i=0;i<42;i++) {
				days[i].setLabel("");
				days[i].setBackground(Color.WHITE);
			}
			Calendar();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AwtCalendar();
	}

}