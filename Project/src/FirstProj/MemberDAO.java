package FirstProj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "C##FIRSTPROJ";
	
	String password = "FIRSTPROJ";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
//	private String TELL;

	//데이터 넣는 곳
	
	public void insertForStatements(String NAME, String TELL, String ADDRESS, String STAR, String PRICE, String BESTMENU,String CHARACTERSS,String KIND) {
	      try {
	         Class.forName(driver);
	         System.out.println("jdbc driver loading success.");
	         Connection conn = DriverManager.getConnection(url, user, password);
	         System.out.println("oracle connection success.\n");
	         Statement stmt = conn.createStatement();

	         String sql3 = "INSERT INTO FOOD VALUES ('" + NAME + "','" + TELL + "','" + ADDRESS + "','" + STAR + "','" + PRICE +"','" + BESTMENU + "','" + CHARACTERSS + "','" + KIND+"')";
	         System.out.println(sql3);

	         boolean b = stmt.execute(sql3);
	         if (!b) {
//	            System.out.println("Insert success.\n");
	         } else {
//	            System.out.println("Insert fail.\n");
	         }

	      } catch (ClassNotFoundException e) {
	         System.out.println(e);
	      } catch (SQLException e) {
	         System.out.println(e);
	      }
	}
	
	public void insertForStatement(String ID, String PASSWORD, String NAME, String TELL) {
	      try {
	         Class.forName(driver);
	         System.out.println("jdbc driver loading success.");
	         Connection conn = DriverManager.getConnection(url, user, password);
	         System.out.println("oracle connection success.\n");
	         Statement stmt = conn.createStatement();

	         String sql2 = "INSERT INTO CUSTUMER VALUES ('" + ID + "','" + PASSWORD + "','" + NAME + "','" + TELL + "')";
	         System.out.println(sql2);

	         boolean b = stmt.execute(sql2);
	         if (!b) {
	            System.out.println("Insert success.\n");
	         } else {
	            System.out.println("Insert fail.\n");
	         }

	      } catch (ClassNotFoundException e) {
	         System.out.println(e);
	      } catch (SQLException e) {
	         System.out.println(e);
	      }
	}
//	
//	public ArrayList<MemberVo>list2(String NAME,String TELL){
//		ArrayList<MemberVo> list2 =new ArrayList<MemberVo>();
//		try {
//			connDB();
//			
//			String query = "SELECT * FROM NAME";
//			if(NAME !=null ) {
//				query +=" where ID='"+NAME+"'";
//			}
//			rs = stmt.executeQuery(query);
//			rs.last();
//			if (rs.getRow() == 0) {
//				System.out.println("0 row selected...");
//			} else {
//				System.out.println(rs.getRow() + " rows selected...");
//				rs.first();
//
//				while (rs.next()) {
//					String NAME1 = rs.getString("NAME");
//					String TELL1 = rs.getString("TELL");
//					MemberVo data = new MemberVo(NAME1, TELL);
//					list2.add(data);
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return list2;
//	}
//	
	
	public ArrayList<MemberVo> list(String name) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM custumer ";
			if (name != null) {
				
				query += " where ID='" +name+ "'";
			}
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + " rows selected...");
				rs.first();

				while (rs.next()) {
					String ID = rs.getString("ID");
					String PASSWORD = rs.getString("PASSWORD");
					MemberVo data = new MemberVo(ID, PASSWORD);
					list.add(data);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}