package YuanGongGuanLi;
import java.util.ArrayList;
public interface Fun {
		void add(Employee employee) throws Exception;
		void update(Employee employee) throws Exception;
		ArrayList select(int empno) throws Exception;
		void delete(Employee employee) throws Exception;
		ArrayList DengLuCheck(int userid,String password) throws Exception;
		void ZhuCe(Employee employee) throws Exception;
		boolean selectZhuCe(int empno) throws Exception; 
}
