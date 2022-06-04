package IMP.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Conect.Conecxao;
import Conect.EXP;
import Entities.Department;
import Model.DAO.DepartmentDAO;

public class Department_imp implements DepartmentDAO {
	
	private Connection Conn ; 
	
	public Department_imp (Connection conn ) {
		Conn = conn; 
		
	}

	@Override
	public void Insert(Department dep) {
		PreparedStatement ps = null ; 
		
		try {
			ps = Conn.prepareStatement("INSERT INTO department "+ 
			"(Name) " +
			"VALUES " +
			"?",Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, dep.getName());
			
			int line = ps.executeUpdate(); 
			if (line > 0 ) {
				ResultSet rs = ps.getGeneratedKeys(); 
				if (rs.next()) {
					int id = rs.getInt(1); 
					dep.setId(id);
				}
				
			}
			else {
				throw new EXP ("ERRO: no row afected "); 	
			}
			
		}catch (SQLException e ) {
			throw new EXP (e.getMessage());
		}
		finally {
			Conecxao.CloseStatement(ps);
		}
		
	}

	@Override
	public void Update(Department dep) {
		PreparedStatement ps = null ; 
		
		try {
			ps = Conn.prepareStatement("UPDATE department "+ 
										"SET Name = ? "+
										"WHERE Id = ? "); 
			
		ps.setString(1, dep.getName());
		ps.setInt(2, dep.getId());
		
		ps.executeUpdate();  
		
		}catch (SQLException e ) {
			throw new EXP(e.getMessage()); 
		}finally {
			Conecxao.CloseStatement(ps);
		}
		
		
	}

	@Override
	public void DeleteById(Integer id) {
		PreparedStatement ps = null ; 
		try {
			ps = Conn.prepareStatement("DELETE FROM department WHERE Id = ? ");
			
			ps.setInt(1, id);
			ps.executeUpdate(); 
			
		}catch (SQLException e ) {
			throw new EXP(e.getMessage());
		}
		finally {
			Conecxao.CloseStatement(ps);
		}
		
	}

	@Override
	public Department FindById(Integer id) {
		PreparedStatement ps = null ; 
		ResultSet  rs = null ; 
		
		try {
			
			ps = Conn.prepareStatement("SELECT * FROM department WHERE Id = ? ");
			ps.setInt(1, id );
			rs = ps.executeQuery(); 
			if(rs.next()) {
				Department dep = new Department(); 
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("Name"));
				return dep ; 
			}
			
			return null ; 
			
		}catch (SQLException e ) {
			throw new EXP(e.getMessage()); 
		}
		finally {
			Conecxao.CloseStatement(ps);
			Conecxao.CloseResultSet(rs);
		}
		

	}

	@Override
	public List<Department> FindAllDeparment() {
		PreparedStatement ps = null ; 
		ResultSet rs = null ; 
		try {
			ps = Conn.prepareStatement("SELECT * FROM department ORDER BY Name"); 
			
			rs = ps.executeQuery(); 
			List <Department> list = new ArrayList<>(); 
			while (rs.next()) {
				Department dep = new Department() ; 
				dep.setName(rs.getString("Name"));
				dep.setId(rs.getInt("Id"));
				list.add(dep); 
				
			}
			return list ; 		
			
		}catch (SQLException e ) {
			throw new EXP(e.getMessage()); 
		}
		finally {
			Conecxao.CloseStatement(ps);
			Conecxao.CloseResultSet(rs);
		}
		
	}

}
