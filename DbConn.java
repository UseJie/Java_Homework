package DB;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public final class DbConn
{
	public static  Connection getconn()
	{
		Connection conn = null;
		
		String user   = "root";
		String passwd = "Userjie1119";
		String url = "jdbc:mysql://localhost:3306/supermarketDB";
		
		//已加载完驱动
		try
		{
			conn = DriverManager.getConnection(url,user,passwd);
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}

}
