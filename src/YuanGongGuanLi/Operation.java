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
		//执行sql语句
				prepareStatement.executeUpdate();
				//关闭资源
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
//		String str = employee.getHiredate();//接收传输的参数
//		DateFormat df = new SimpleDateFormat(str);//以指定日期格式模板生成格式化的类
//		java.util.Date parse = df.parse(str);//将字符串转换为java.util.Date类型的日期
//		java.sql.Date d1 = new java.sql.Date(parse.getTime());//将java.util.Date类型的日期转化为java.sql.Date类型的日期
//		
			String str = employee.getHiredate();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date hiredate1= new Date(format.parse(str).getTime());
		prepareStatement.setDate(6,hiredate1);
		prepareStatement.setInt(7,employee.getSal());
		prepareStatement.setInt(8,employee.getDeptno());
		prepareStatement.setString(9,employee.getHobby());
		//执行sql语句
		prepareStatement.executeUpdate();
		//关闭资源
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
		//执行sql语句
		prepareStatement.executeUpdate();
		//关闭资源
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
		//执行sql语句
		ResultSet rs = prepareStatement.executeQuery();
		
		//将数据从rs取出，将取出的结果放到容器中
		ArrayList list = new ArrayList();//定义一个list容器用于接收从ResultSet中读取的数据
		while(rs.next()){
			//从ResultSet中获取数据
			int empno1 = rs.getInt(1);
			String ename1 = rs.getString(2);
			String password1 = rs.getString(3);
			String sex1 = rs.getString(4);
			String job1 = rs.getString(5);
			Date hiredate1 = rs.getDate(6);
			int sal1 = rs.getInt(7);
			int deptno1 = rs.getInt(8);
			String hobby1 = rs.getString(9);
			//将从ResultSet中读取的数据封装到Employee对象中
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
			//将对象添加到容器中
			list.add(employee1);
		}
		
		//关闭资源
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
		//执行sql语句
		ResultSet rs = prepareStatement.executeQuery();
		//将数据从rs取出，将取出的结果放到容器中
		ArrayList list = new ArrayList();//定义一个list容器用于接收从ResultSet中读取的数据
		while(rs.next()){
			//从ResultSet中获取数据
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
			//将从ResultSet中读取的数据封装到Employee对象中
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
			//将对象添加到容器中
			list.add(employee);
		}
	
		//关闭资源
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
		//执行sql语句
		ResultSet rs = prepareStatement.executeQuery();
		//将数据从rs取出，将取出的结果放到容器中
		boolean check;
		if(rs.next()){
			 check= true;
		}else{
			 check=false;
		}
	
		//关闭资源
		rs.close();
		prepareStatement.close();
		connection.close();
		return check;
	}
	
	}

