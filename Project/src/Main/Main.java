package Main;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Main");
		f.setSize(700, 700);
		Frame q = new Frame("Roulette");
		q.setSize(700, 700);

		Panel p = new Panel();
//		p.setSize(100,75);
//		p.setLocation(100, 100);
		Button b = new Button("1");
		b.setSize(100, 50);
		b.setLocation(100, 75);
		b.setBounds(50, 400, 110, 70);
		
		
		//점메추 버튼
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
		
		Label lid=new Label("메뉴 추가하기",Label.RIGHT);
		
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

			public void actionPerformed1(ActionEvent e) {
				f.dispose();
//				q.add(q);
				q.setVisible(true);
			}
		});
		Button c = new Button("2");
		c.setSize(100, 50);
		c.setLocation(100, 75);
		c.setBounds(220, 400, 110, 70);

		c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
//				q.add(q);
			}
			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
//				q.add(q);
			}
		});

		Button d = new Button("3");
		d.setSize(100, 50);
		d.setLocation(100, 75);
		d.setBounds(390, 400, 110, 70);

		d.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
//				q.add(q);
			}
			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
//				q.add(q);
			}
		});

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
			public void actionPerformed1(ActionEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
//				q.add(q);
			}
		});

//		p.add(new Button("2"));
//		p.add(new Button("3"));
//		p.add(new Button("4"));

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
	}

}
