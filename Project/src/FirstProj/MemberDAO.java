package FirstProj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
  //----------달력----------------------------------
    
    public void fetchCalendarDataToTextField() {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM CALLENDAR";
            ResultSet rs = stmt.executeQuery(query);

            // 텍스트 필드를 사용하는 UI 프레임워크에서 해당 필드를 참조하여 값을 표시해야 합니다.
            while (rs.next()) {
                String TODAY = rs.getString("TODAY");
                // 여기에서 필요한 작업을 수행하세요. (예: 텍스트 필드에 값을 설정하는 등)
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------
    public void fetchTableDataToTextField() {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String query = "SELECT NAME,TELL,ADDRESS,STAR,PRICE,BESTMENU,CHARACTERSS,KIND FROM CUSTUMER";
            ResultSet rs = stmt.executeQuery(query);
            
            // 텍스트 필드를 사용하는 UI 프레임워크에서 해당 필드를 참조하여 값을 표시해야 합니다.
//             textField.setText(rs.getString("column_name"));
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertForStatements(String TODAY) {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String sql3 = "INSERT INTO FOOD CALLENDAR ('" + TODAY  + "')";
            
            stmt.executeUpdate(sql3);

            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertForStatements(String NAME, String TELL, String ADDRESS, String STAR, String PRICE,
            String BESTMENU, String CHARACTERSS, String KIND) {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String sql3 = "INSERT INTO FOOD VALUES ('" + NAME + "','" + TELL + "','" + ADDRESS + "','" + STAR + "','"
                    + PRICE + "','" + BESTMENU + "','" + CHARACTERSS + "','" + KIND + "')";
            
            stmt.executeUpdate(sql3);

            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertForStatement(String ID, String PASSWORD, String NAME, String TELL) {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String sql2 = "INSERT INTO CUSTUMER VALUES ('" + ID + "','" + PASSWORD + "','" + NAME + "','" + TELL + "')";
            
            stmt.executeUpdate(sql2);

            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<FoodVo> list2(String name) {
        ArrayList<FoodVo> list2 = new ArrayList<FoodVo>();

        try {
            connDB();

            String query = "SELECT * FROM Food ";
            if (name != null) {
                query += " where NAME='" + name + "'";
            }
            
            rs = stmt.executeQuery(query);
//            rs.last();

//            if (rs.getRow() == 0) {
//                System.out.println("0 row selected...");
//            } else {
//                System.out.println(rs.getRow() + " rows selected...");
//                rs.first();

                while (rs.next()) {
                    String NAME = rs.getString("NAME");
                    String TELL = rs.getString("TELL");
                    String ADDRESS =rs.getString("ADDRESS");
                    String STAR = rs.getString("STAR");
                    String PRICE = rs.getString("PRICE");
                    String BESTMENU =rs.getString("BESTMENU");
                    String CHARACTERSS = rs.getString("CHARACTERSS");
                    String KIND = rs.getString("KIND");
                    FoodVo data = new FoodVo(NAME, TELL,ADDRESS,STAR,PRICE,BESTMENU,CHARACTERSS,KIND);
                    list2.add(data);
                }
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list2;
    }
    
    public ArrayList<MemberVo> list(String name) {
        ArrayList<MemberVo> list = new ArrayList<MemberVo>();

        try {
            connDB();

            String query = "SELECT * FROM custumer ";
            if (name != null) {
                query += " where NAME='" + name + "'";
            }
            
            rs = stmt.executeQuery(query);
            rs.last();

            if (rs.getRow() == 0) {
                System.out.println("0 row selected...");
            } else {
                System.out.println(rs.getRow() + " rows selected...");
                rs.first();

                while (rs.next()) {
                    String NAME = rs.getString("NAME");
                    String TELL = rs.getString("TELL");
                    MemberVo data = new MemberVo(NAME, TELL);
                    list.add(data);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeStatement(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public ArrayList<FoodVo> listAll() {
        ArrayList<FoodVo> list = new ArrayList<>();

        // Establish a database connection
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection(); // Replace getConnection() with your own method to establish a database connection

            // Prepare the SQL statement
            String sql = "SELECT * FROM FOOD";
            stmt = conn.prepareStatement(sql);

            // Execute the query
            rs = stmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                // Extract the data from each row
                String name = rs.getString("NAME");
                String tell = rs.getString("TELL");
                String address = rs.getString("ADDRESS");
                String star = rs.getString("STAR");
                String price = rs.getString("PRICE");
                String bestMenu = rs.getString("BESTMENU");
                String characterss = rs.getString("CHARACTERSS");
                String kind = rs.getString("KIND");

                // Create a FoodVo object and add it to the list
                FoodVo food = new FoodVo(name, tell, address, star, price, bestMenu, characterss, kind);
                list.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
        }

        return list;
    }

    // Other methods in the MemberDAO class...
}

