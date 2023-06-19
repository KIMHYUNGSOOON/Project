

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		
		// 메인 3번 서브 ---------------------------------------
		Frame q1= new Frame("Choice");
		q1.setSize(400, 400);
		q1.setLocation(100, 75);
		TextField t1=new TextField(10);
		TextField t2=new TextField(20);
		TextField t3=new TextField(10);
		TextField t4=new TextField(10);
		
		Label lid1 =new Label("name");
		Label lid2= new Label("tell");
		Label lid3=new Label("address");
		
		Dialog info =new Dialog(q1,"Choice1",true);
		info.setSize(500, 500);
		info.setLocation(100,75);
		info.setLayout(new FlowLayout());
		
		Label msg = new Label("Today menu ",Label.CENTER);
		Button ok =new Button("다시 선택");
		info.add(msg);
		info.add(ok);
		
		//메인 버튼 1번 -----------------------------------------

		Panel p = new Panel();
//		p.setSize(100,75);
//		p.setLocation(100, 100);
		Button b = new Button("1");
		b.setSize(100, 50);
		b.setLocation(100, 75);
		b.setBounds(50, 400, 110, 70);
		
		
		//메인 버튼 1번 서브 -------------------------------------------
		Button s=new Button("Start");
		s.setSize(100, 10);
		s.setLocation(10, 10);
		s.setBounds(50,50, 600, 400);
		
		Button s2=new Button("List");
		s2.setSize(30,30);
		s2.setLocation(20, 20);
		s2.setBounds(50, 470, 600, 100);
		
		Button s3=new Button("keep");
		s3.setSize(50,50);
		s3.setLocation(30,30);
		s3.setBounds(200, 200, 230,30);
		
		Label id =new Label("메뉴 추가하기");
		id.setBounds(30, 0, 30, 10);
		
		Label lid=new Label("추가하기",Label.RIGHT);
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
//				q.add(q);
				q.setVisible(true);
//				Button s=new Button("Start");
//				s.setSize(100, 50);
//				s.setLocation(100, 75);
//				s.setBounds(0, 400, 110, 70);
//				q.add(s);
				
				
			}
		});
		//--------------------------------------------------
		
		
		
		//메인버튼 2번 ---------------------------------------------
		
		Button c = new Button("2");
		c.setSize(100, 50);
		c.setLocation(100, 75);
		c.setBounds(220, 400, 110, 70);

		c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				w.setVisible(true);
//				q.add(q);
			}
		});
		
		//메인버튼 2번 서브 -----------------------------------------
		
		Button l =new Button("뒤로가기");
		l.setSize(10,10);
		l.setLocation(0,0);
		l.setBounds(100, 100, 10,10);
		
		//메인버튼 3번 ---------------------------------------------

		Button d = new Button("3");
		d.setSize(100, 50);
		d.setLocation(100, 75);
		d.setBounds(390, 400, 110, 70);

		d.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				q1.setVisible(true);
				info.setVisible(true);
//				q1.setVisible(true);
//				f.dispose();  //창 끄기
//				q.add(q);
//				info.add(c1);
			}
		});
		
		//메인버튼 4번 ---------------------------------------

		Button e = new Button("4");
		e.setSize(100, 50);
		e.setLocation(100, 75);
		e.setBounds(560, 400, 110, 70);

		e.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
//				q.add(q);
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
		
		q1.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.add(b);
		f.add(c);
		f.add(d);
		f.add(e);
		f.add(p);
		f.setVisible(true);
		q.add(s);
		q.add(s2);
		q.add(s3);
		q.add(id);
		q.add(lid);
		w.add(l);
		q1.add(t1);
		q1.add(t2);
		q1.add(t3);
		q1.add(t4);
	}

}
