package YuanGongGuanLi;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {
	//定义数据库的的驱动
	public static final String DBDRIVER="oracle.jdbc.driver.OracleDriver";
	//定义数据库的连接地址
	public static final String  DBURL="jdbc:oracle:thin:@localhost:1521:oracle";
	//定义数据库的用户名
	public static final String DBUSER = "scott";
	// 定义Oracle数据库的密码
	public static final String DBPASSWORD = "tiger";
	public Connection getConnection() throws Exception{
		Class.forName(DBDRIVER);
		Connection conn=null;
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		return conn;
	}
}
