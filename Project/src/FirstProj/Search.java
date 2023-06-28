package FirstProj;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Search {
	private static MemberDAO  dao= new MemberDAO();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		JFrame main =new JFrame("추천");
		main.setSize(1000,600);
		main.setLocationRelativeTo(null);
		main.setVisible(true); 
		main.setResizable(false);  // 화면 크기 조정
		JButton bt1=new JButton("검색");
		bt1.setBounds(740, 50, 60, 30);
		TextField tf1=new TextField();
		tf1.setBounds(300, 50, 400, 30);
		TextField tf2=new TextField();
		tf2.setBounds(50, 200, 900, 300);
		JButton bt2=new JButton("뒤로가기"); 
		bt2.setBounds(20, 20, 90, 30);
		JButton bt3=new JButton("추가하기");
		bt3.setBounds(880, 520, 90, 30);
		
//		JOptionPane.showInputDialog(null,"message","작성해주세요");
		
		JFrame main2 =new JFrame("추가하기");
		main2.setSize(400,400);
		main2.setResizable(false);
		main2.setLocationRelativeTo(null); //화면 가운데로 출력
		TextField tf3=new TextField();
		tf3.setBounds(10, 30, 20, 20);
		
		
		main.add(tf1);
		main.add(bt1);
		main.add(tf2);
		main.add(bt2);
		main.add(bt3);
		
		
		
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.main(new String[0]);
				main.dispose();
			}
		});
		
		bt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main2.setVisible(true);
				String NAME =JOptionPane.showInputDialog("가게 이름","작성해주세요");
				String TELL =JOptionPane.showInputDialog("전화번호","작성해주세요");
				String ADDRESS =JOptionPane.showInputDialog("주소","작성해주세요");
				String STAR =JOptionPane.showInputDialog("별점","작성해주세요");
				String PRICE =JOptionPane.showInputDialog("가격","작성해주세요");
				String BESTMENU =JOptionPane.showInputDialog("추천메뉴","작성해주세요");
				String CHARACTERSS =JOptionPane.showInputDialog("특징","작성해주세요");
				String KIND =JOptionPane.showInputDialog("분류","작성해주세요");
				main2.dispose();
				dao.insertForStatements(NAME,TELL,ADDRESS,STAR,PRICE,BESTMENU,CHARACTERSS,KIND);
			}
		});
	}
	

}