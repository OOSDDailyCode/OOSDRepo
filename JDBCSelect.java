import java.sql.*;

public class JDBCSelect {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@10.162.49.8:1521:javajdbc","hr","hr");
        c.setAutoCommit(false);
        Statement s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = s.executeQuery("SELECT * from EMPLOYEES");
        ResultSetMetaData rsmd = rs.getMetaData();
        
        for (int i = 1; i <= rsmd.getColumnCount(); i++)
        {
        	System.out.print(rsmd.getColumnName(i) + "\t");
        }
        System.out.println();
        
        while (rs.next())
        {
        	for (int i = 1; i <= rsmd.getColumnCount(); i++)
        	{
        		System.out.print(rs.getString(i) + "\t");
        	}
        	System.out.println();
        }
        
        rs.moveToInsertRow();
        rs.updateInt(1,90000);
        rs.updateString(2,"Joe");
        rs.updateString(3,"Jones");
        rs.updateString(4,"joe@home.ca");
        rs.updateString(5,"555-5556");
        rs.updateString(6,"Jones");
        rs.updateDouble(7,90000);
        rs.updateDouble(8,.9);
        rs.updateInt(9,100);
        rs.updateInt(10,60);
        rs.insertRow();
        
        c.commit();
        c.close();
	}
	
}
