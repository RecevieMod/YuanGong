package YuanGongGuanLi;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {
	//�������ݿ�ĵ�����
	public static final String DBDRIVER="oracle.jdbc.driver.OracleDriver";
	//�������ݿ�����ӵ�ַ
	public static final String  DBURL="jdbc:oracle:thin:@localhost:1521:oracle";
	//�������ݿ���û���
	public static final String DBUSER = "scott";
	// ����Oracle���ݿ������
	public static final String DBPASSWORD = "tiger";
	public Connection getConnection() throws Exception{
		Class.forName(DBDRIVER);
		Connection conn=null;
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		return conn;
	}
}
