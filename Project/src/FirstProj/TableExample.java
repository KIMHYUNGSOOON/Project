
package FirstProj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.PatternSyntaxException;

public class TableExample extends JFrame {
    private final JTextField searchField = new JTextField(10);
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final TableRowSorter<DefaultTableModel> sorter;

    public TableExample() {
        setTitle("추천 식당");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 테이블 모델 초기화
        tableModel = new DefaultTableModel();
        tableModel.addColumn("가게이름");
        tableModel.addColumn("전화번호");
        tableModel.addColumn("주소");
        tableModel.addColumn("별점");
        tableModel.addColumn("가격");
        tableModel.addColumn("추천메뉴");
        tableModel.addColumn("특징");
        tableModel.addColumn("분류");

        // 테이블 초기화
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // 검색 필드 초기화
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("종류로 검색:"));
        searchPanel.add(searchField);
        add(searchPanel, BorderLayout.NORTH);

        // 검색 버튼 초기화
        JButton searchButton = new JButton("검색");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByCategory();
            }
        });
        searchPanel.add(searchButton);

        // 테이블 정렬기 초기화
        sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);

        // 데이터 추가
        addRow("조선갈비실록", "02-853-5500", "서울 구로구 경인로 572 201호", "4.47", "15000원", "삼계탕,갈비탕", "매우청결하고 시원하다,하지만 비싸다", "한식");
        addRow("타베루", "0507-1367-2228", "구로구 경인로59길 7 e편한세상6차109호", "4.31", "8000~10000원", "라멘,돈가스", "라멘은 좀아쉽지만 돈가스가 맛있다", "일식");
        addRow("바름김밥", "02-2633-6482", "구로구 신도림로 대림2차상가 102호", "4.7", "5000~10000원", "떡볶이", "신전떡볶이 느낌,양이 매우많다", "분식");
        addRow("고봉민김밥인", "02-853-5500", "구로구 경인로59길 8태영프라자102호", "4.47", "5000원~1000원", "김밥+사이드", "양도 적당하고 음식도 괜찮지만 매장이좁다", "분식");
        addRow("대가칡냉면", "02-2676-7755", "구로구 경인로59길 8 태영상가2층", "4.27", "8000~9500원", "냉면,칼국수", "칼국수와 냉면이 아주 맛있었다", "한식");
        addRow("국수나무", "02-2635-9501", "신도림동 437-1 태영프라자 116호", "4.34", "10000원", "돈가스정식", "맛있지만 매장이 작다", "일식");
        addRow("한솥도시락", "02-2675-4500", "신도림동 648", "4.67", "5000원", "치킨마요덮밥", "매우저렴하고 맛이있지만 자리가 2자리뿐이라 매장에서 먹기힘들다", "한식");
        addRow("밤새먹소", "02-2068-7637", "구로동 603-9", "4.2", "12900원", "소갈비살+냉면", "육삼냉면인데 소갈비살을 직접구워먹을수 있다", "한식");
        addRow("한옥집", "02-2633-6482", "구로구 nc백화점 6층", "4.37", "13800원", "김치찜 정식", "김치가 아주맛있지만 고기가 너무적다", "한식");
        addRow("용호동낙지", "02-6923-2435", "구로동 573", "4.41", "13000원", "낙곱새", "낙지한마리가 통채로 들어간다", "한식");
        addRow("궁채", "0507-1387-3219", "서울 구로구 구로중앙로 152 6층", "3.8", "10000원", "비빔밥", "그냥 비빔밥", "한식");
        addRow("신사부짬뽕", "0507-1313-5142", "구로동 600-14", "4.33", "10000원", "차돌짬뽕", "사이드메뉴가저렴하고,선불이다", "중식");
        addRow("큰맘할매순대국", "02-6011-5353", "구로동 611-1", "4.25", "9000원", "큰맘순대국", "매우 뜨겁다", "한식");
        addRow("마님순대국", "02-2677-8808", "신도림동 400-1", "4.27", "9000원", "순대국", "순대국은 다괜찮다,카레순대국만 피하면된다", "한식");
        addRow("명가한식부페", " 02-2639-8369", "서울특별시 구로구 구로동 611-26(오퍼스지하1층)", "3.8", "6500원", "한식부페", "매우저렴하지만 날마다 느낌이다르다.", "한식");
        addRow("권가네", "0507-1436-0141", "서울 구로구 경인로55길 13 1층", "4.04", "7000원", "돼지불백", "반찬,밥 모두 무한리필이다", "한식");
        addRow("명동칼국수&보쌈만두", "02-6679-9494", "구로동 1258", "4.03", "7000원", "칼국수", "매장이 조금 덥다", "한식");
        addRow("김찌부찌", "02-6679-3779", "구로동 1258 지하1층 A-05호", "4.06", "7000원", "김치찌개,부대찌개", "밥이 돌솥밥이다", "한식");
        addRow("이바돔감자탕", "02-2633-9600", "구로동 603-9", "4.27", "8000원", "뼈해장국", "시래기가 매우많이들어가고 돌솥밥이다", "한식");
        addRow("후니돈까스", "02-3666-9007", "서울 구로구 경인로53길 15 중앙유통단지", "4.01", "8000원", "돈가스", "경양식 돈가스다", "일식");
        addRow("얌샘김밥", "02-2677-3378", "구로동 603-9", "4.09", "8000~10000원", "분식", "매장이작다", "분식");
        
        pack();
        setLocationRelativeTo(null);
    }

    private void addRow(String name, String number, String address, String rating, String price, String recommendedMenu, String feature, String category) {
        Object[] rowData = {name, number, address, rating, price, recommendedMenu, feature, category};
        tableModel.addRow(rowData);
    }

    private void filterByCategory() {
        String searchText = searchField.getText().trim();

        if (searchText.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 7));
            } catch (PatternSyntaxException ex) {
                sorter.setRowFilter(null);
            }
        }
    }

    public static void main(String[] args) {
        TableExample example = new TableExample();
        example.setVisible(true);
    }
}