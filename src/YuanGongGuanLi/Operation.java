package YuanGongGuanLi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



public class Operation implements Fun {
	@Override
	public void ZhuCe(Employee employee) throws Exception {
		DataConnect dc = new DataConnect();
		Connection connection = dc.getConnection();
		String sql = "insert into emp1(empno,ename,password) values(?,?,?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1,employee.getEmpno());
		prepareStatement.setString(2,employee.getEname());
		prepareStatement.setString(3,employee.getPassword());
		//ִ��sql���
				prepareStatement.executeUpdate();
				//�ر���Դ
				prepareStatement.close();
				connection.close();
	}
	@Override
	public void add(Employee employee) throws Exception {
		
		DataConnect dc = new DataConnect();
		Connection connection = dc.getConnection();
		String sql = "insert into emp1 values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1,employee.getEmpno());
		prepareStatement.setString(2,employee.getEname());
		prepareStatement.setString(3,employee.getPassword());
		prepareStatement.setString(4,employee.getSex());
		prepareStatement.setString(5,employee.getJob());
//		String str = employee.getHiredate();//���մ���Ĳ���
//		DateFormat df = new SimpleDateFormat(str);//��ָ�����ڸ�ʽģ�����ɸ�ʽ������
//		java.util.Date parse = df.parse(str);//���ַ���ת��Ϊjava.util.Date���͵�����
//		java.sql.Date d1 = new java.sql.Date(parse.getTime());//��java.util.Date���͵�����ת��Ϊjava.sql.Date���͵�����
//		
			String str = employee.getHiredate();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date hiredate1= new Date(format.parse(str).getTime());
		prepareStatement.setDate(6,hiredate1);
		prepareStatement.setInt(7,employee.getSal());
		prepareStatement.setInt(8,employee.getDeptno());
		prepareStatement.setString(9,employee.getHobby());
		//ִ��sql���
		prepareStatement.executeUpdate();
		//�ر���Դ
		prepareStatement.close();
		connection.close();
	}

	@Override
	public void delete(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		DataConnect  dc=new DataConnect();
		Connection connection= dc.getConnection();
		String sql="delete from emp1 where empno=?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1,employee.getEmpno());
		prepareStatement.executeUpdate();
		
		prepareStatement.close();
		connection.close();

	}
//
	@Override
	public void update(Employee employee) throws Exception{
		// TODO Auto-generated method stub
		DataConnect dc = new DataConnect();
		Connection connection = dc.getConnection();
		String sql = "update emp1 set ename=?,password=?,sex=?,job=?,hiredate=?,sal=?,deptno=?,hobby=? where empno=?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1,employee.getEname());
		prepareStatement.setString(2,employee.getPassword());
		prepareStatement.setString(3,employee.getSex());
		prepareStatement.setString(4,employee.getJob());	
			String str = employee.getHiredate();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date hiredate1= new Date(format.parse(str).getTime());
		prepareStatement.setDate(5,hiredate1);
		prepareStatement.setInt(6,employee.getSal());
		prepareStatement.setInt(7,employee.getDeptno());
		prepareStatement.setString(8,employee.getHobby());
		prepareStatement.setInt(9,employee.getEmpno());
		//ִ��sql���
		prepareStatement.executeUpdate();
		//�ر���Դ
		prepareStatement.close();
		connection.close();
	}
	@Override
	public ArrayList DengLuCheck(int userid,String password) throws Exception{
		// TODO Auto-generated method stub
		DataConnect dc = new DataConnect();
		Connection connection = dc.getConnection();
		String sql = "select * from emp1 where empno = ? and password = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
		prepareStatement.setInt(1,userid);
		prepareStatement.setString(2,password);
		//ִ��sql���
		ResultSet rs = prepareStatement.executeQuery();
		
		//�����ݴ�rsȡ������ȡ���Ľ���ŵ�������
		ArrayList list = new ArrayList();//����һ��list�������ڽ��մ�ResultSet�ж�ȡ������
		while(rs.next()){
			//��ResultSet�л�ȡ����
			int empno1 = rs.getInt(1);
			String ename1 = rs.getString(2);
			String password1 = rs.getString(3);
			String sex1 = rs.getString(4);
			String job1 = rs.getString(5);
			Date hiredate1 = rs.getDate(6);
			int sal1 = rs.getInt(7);
			int deptno1 = rs.getInt(8);
			String hobby1 = rs.getString(9);
			//����ResultSet�ж�ȡ�����ݷ�װ��Employee������
			Employee employee1 = new Employee();
			employee1.setEmpno(empno1);
			employee1.setEname(ename1);
			employee1.setPassword(password1);
			employee1.setSex(sex1);
			employee1.setJob(job1);
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
				String str=simpleDateFormat.format(hiredate1);
			employee1.setHiredate( str);
			employee1.setSal(sal1);
			employee1.setDeptno(deptno1);
			employee1.setHobby(hobby1);
			//��������ӵ�������
			list.add(employee1);
		}
		
		//�ر���Դ
		rs.close();
		prepareStatement.close();
		connection.close();
		return list;
	}

	@Override
	public ArrayList select(int empno) throws Exception {
		// TODO Auto-generated method stub
		
		DataConnect dc = new DataConnect();
		Connection connection = dc.getConnection();
		String sql = "select * from emp1 where empno = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
		prepareStatement.setInt(1,empno);
		//ִ��sql���
		ResultSet rs = prepareStatement.executeQuery();
		//�����ݴ�rsȡ������ȡ���Ľ���ŵ�������
		ArrayList list = new ArrayList();//����һ��list�������ڽ��մ�ResultSet�ж�ȡ������
		while(rs.next()){
			//��ResultSet�л�ȡ����
			int empno1 = rs.getInt(1);
			String ename1 = rs.getString(2);
			String password1 = rs.getString(3);
			String sex1 = rs.getString(4);
			String job1 = rs.getString(5);
			Date hiredate1 = rs.getDate(6);
			int sal1 = rs.getInt(7);
			int deptno1 = rs.getInt(8);
			String hobby1=rs.getString(9);
			
			SimpleDateFormat str1=new SimpleDateFormat("yyyy-MM-dd");
			String str=str1.format(hiredate1);
			//����ResultSet�ж�ȡ�����ݷ�װ��Employee������
			Employee employee = new Employee();
			employee.setEmpno(empno1);
			employee.setEname(ename1);
			employee.setPassword(password1);
			employee.setSex(sex1);
			employee.setJob(job1);
			employee.setHiredate(str);
			employee.setSal(sal1);
			employee.setDeptno(deptno1);
			employee.setHobby(hobby1);
			//��������ӵ�������
			list.add(employee);
		}
	
		//�ر���Դ
		rs.close();
		prepareStatement.close();
		connection.close();
		return list;
	}
	
	@Override
	public boolean selectZhuCe(int empno) throws Exception {
		// TODO Auto-generated method stub
		
		DataConnect dc = new DataConnect();
		Connection connection = dc.getConnection();
		String sql = "select * from emp1 where empno = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
		prepareStatement.setInt(1,empno);
		//ִ��sql���
		ResultSet rs = prepareStatement.executeQuery();
		//�����ݴ�rsȡ������ȡ���Ľ���ŵ�������
		boolean check;
		if(rs.next()){
			 check= true;
		}else{
			 check=false;
		}
	
		//�ر���Դ
		rs.close();
		prepareStatement.close();
		connection.close();
		return check;
	}
	
	}

