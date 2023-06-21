package Login;

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
//	public void insertForStatement(String ID, String PASSWORD, String NAME, String TELL) {
//	      try {
//	         Class.forName(driver);
//	         System.out.println("jdbc driver loading success.");
//	         Connection conn = DriverManager.getConnection(url, user, password);
//	         System.out.println("oracle connection success.\n");
//	         Statement stmt = conn.createStatement();
//
//	         String sql2 = "INSERT INTO custumer VALUES ('" + ID + "','" + PASSWORD + "','" + NAME + "',')";
//	         System.out.println(sql2);
//
//	         boolean b = stmt.execute(sql2);
//	         if (!b) {
//	            System.out.println("Insert success.\n");
//	         } else {
//	            System.out.println("Insert fail.\n");
//	         }
//	      }
//	         catch (ClassNotFoundException e) {
//	             System.out.println(e);
//	          } catch (SQLException e) {
//	             System.out.println(e);
//	          }
//
//	       }
	         
	public ArrayList<MemberVo> list(String name) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();

		try {
			connDB();

			String query = "SELECT * FROM emp ";
			if (name != null) {
				query += " where ename='" + name.toUpperCase() + "'";
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
					String empno = rs.getString("empno");
					String ename = rs.getString("ename");
					int sal = rs.getInt("sal");
					MemberVo data = new MemberVo(empno, ename, sal);
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