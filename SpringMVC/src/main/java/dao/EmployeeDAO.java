package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EmployeeDTO;

public class EmployeeDAO {

	public Integer getEmpByDept(int dpId) {
		String sql = "SELECT * FROM employees WHERE department_id=?";
		try(
				DBSession session = DBConnector.getSession(); 
				PreparedStatement pstmt = session.prepareStatement(sql);
			) {
				pstmt.setInt(1, dpId);
				try (ResultSet rs = pstmt.executeQuery()){
					List<EmployeeDTO> employees = new ArrayList<>();
					while (rs.next()) {
						employees.add(new EmployeeDTO(
								rs.getInt("employee_id"), 
								rs.getString("first_name"), 
								rs.getString("last_name"),
								rs.getString("email"), 
								rs.getString("phone_number"), 
								rs.getDouble("salary"), 
								rs.getDouble("commission_pct"), 
								rs.getDate("hire_date"), 
								rs.getString("job_id"), 
								rs.getInt("manager_id"), 
								rs.getInt("department_id")));
					}
					if(employees.isEmpty()) {
						return null;						
					} else {
						return (int)employees.size();						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return -1;		
	}
	
	public Object getEmpByDept1(int dpId) {
		String sql = "SELECT * FROM employees WHERE department_id=?";
		List<EmployeeDTO> employees = new ArrayList<>();
		try(
				DBSession session = DBConnector.getSession(); 
				PreparedStatement pstmt = session.prepareStatement(sql);
			) {
				pstmt.setInt(1, dpId);
				try (ResultSet rs = pstmt.executeQuery()){
					while (rs.next()) {
						employees.add(new EmployeeDTO(
								rs.getInt("employee_id"), 
								rs.getString("first_name"), 
								rs.getString("last_name"),
								rs.getString("email"), 
								rs.getString("phone_number"), 
								rs.getDouble("salary"), 
								rs.getDouble("commission_pct"), 
								rs.getDate("hire_date"), 
								rs.getString("job_id"), 
								rs.getInt("manager_id"), 
								rs.getInt("department_id")));
					}
					return employees.isEmpty() ?  null : employees.size();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;	
			}
	}
	
	public List<EmployeeDTO> getEmpByDept2(int dpId) {
		String sql = "SELECT * FROM employees WHERE department_id=?";
		List<EmployeeDTO> employees = new ArrayList<>();
		try(
				DBSession session = DBConnector.getSession(); 
				PreparedStatement pstmt = session.prepareStatement(sql);
			) {
				pstmt.setInt(1, dpId);
				try (ResultSet rs = pstmt.executeQuery()){
					while (rs.next()) {
						employees.add(new EmployeeDTO(
								rs.getInt("employee_id"), 
								rs.getString("first_name"), 
								rs.getString("last_name"),
								rs.getString("email"), 
								rs.getString("phone_number"), 
								rs.getDouble("salary"), 
								rs.getDouble("commission_pct"), 
								rs.getDate("hire_date"), 
								rs.getString("job_id"), 
								rs.getInt("manager_id"), 
								rs.getInt("department_id")));
					}
					return employees.isEmpty() ?  null : employees;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;	
			}
	}
}
