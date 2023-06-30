package FirstProj;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Search {
    private static MemberDAO dao = new MemberDAO();

    public static void main(String[] args) {

        JFrame main = new JFrame("추천");
        main.setLayout(null);
        main.setSize(900, 600);
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        main.setResizable(false);

        JButton bt1 = new JButton("검색");
        bt1.setBounds(650, 50, 60, 30);

        TextField tf1 = new TextField();
        tf1.setBounds(250, 50, 400, 30);

        TextArea tf2 = new TextArea();
        tf2.setBounds(50, 200, 800, 300);
        tf2.setEditable(false); // 수정 불가능하도록 설정

        JButton bt2 = new JButton("뒤로가기");
        bt2.setBounds(20, 20, 90, 30);

        JButton bt3 = new JButton("추가하기");
        bt3.setBounds(750, 520, 90, 30);

        JFrame main2 = new JFrame("추가하기");
        main2.setSize(400, 400);
        main2.setResizable(false);
        main2.setLocationRelativeTo(null);
        TextField tf3 = new TextField();
        tf3.setBounds(10, 30, 20, 20);

        main.add(tf1);
        main.add(bt1);
        main.add(tf2);
        main.add(bt2);
        main.add(bt3);
        
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tf1.getText();
                if (name.isEmpty()) {
                    // 검색어가 비어있을 경우 전체 내용을 보여줌
                    ArrayList<FoodVo> list = dao.listAll();
                    if (list.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    
                    StringBuilder sb = new StringBuilder();
                    for (FoodVo member : list) {
                        sb.append("가게명: ").append(member.getNAME()).append("\n");
                        sb.append("전화번호: ").append(member.getTELL()).append("\n");
                        sb.append("주소: ").append(member.getADDRESS()).append("\n");
                        sb.append("별점: ").append(member.getSTAR()).append("\n");
                        sb.append("가격: ").append(member.getPRICE()).append("\n");
                        sb.append("추천 메뉴: ").append(member.getBESTMENU()).append("\n");
                        sb.append("특징: ").append(member.getCHARACTERSS()).append("\n");
                        sb.append("종류: ").append(member.getKIND()).append("\n");
                        sb.append("\n");
                        sb.append("\n");
                    }
                    tf2.setText(sb.toString());
                } else {
                    tf2.setText(""); // 이전에 표시된 결과 초기화

                    ArrayList<FoodVo> list = dao.list2(name);
                    if (list.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    
                    StringBuilder sb = new StringBuilder();
                    for (FoodVo member : list) {
                        sb.append("가게명 : ").append(member.getNAME()).append(", 전화번호 : ").append(member.getTELL()).append(", 주소 : ").append(member.getADDRESS()).append(", 별점 : ").append(member.getSTAR()).append(", 가격 : ").append(member.getPRICE()).append(", 추천 메뉴 : ").append(member.getBESTMENU()).append(", 특징: ").append(member.getCHARACTERSS()).append(", 종류: ").append(member.getKIND()).append("\n");
                    }
                    tf2.setText(sb.toString());
                }
            }
        });

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
                String NAME = JOptionPane.showInputDialog("가게 이름", "작성해주세요");
                if (NAME == null || NAME.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "가게 이름을 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String TELL = JOptionPane.showInputDialog("전화번호", "작성해주세요");
                String ADDRESS = JOptionPane.showInputDialog("주소", "작성해주세요");
                String STAR = JOptionPane.showInputDialog("별점", "작성해주세요");
                String PRICE = JOptionPane.showInputDialog("가격", "작성해주세요");
                String BESTMENU = JOptionPane.showInputDialog("추천메뉴", "작성해주세요");
                String CHARACTERSS = JOptionPane.showInputDialog("특징", "작성해주세요");
                String KIND = JOptionPane.showInputDialog("분류", "작성해주세요");

                main2.dispose();
                dao.insertForStatements(NAME, TELL, ADDRESS, STAR, PRICE, BESTMENU, CHARACTERSS, KIND);
            }
        });
    }
}