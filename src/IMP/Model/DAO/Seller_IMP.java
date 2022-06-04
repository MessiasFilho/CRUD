package IMP.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Conect.Conecxao;
import Conect.EXP;
import Entities.Department;
import Entities.Seller;
import Model.DAO.SellertDAO;

public class Seller_IMP implements SellertDAO {
	
		private Connection conn ; 

		public Seller_IMP  (Connection con  ) {
			conn =con ; 
		}
		
	@Override
	public void Insert(Seller obj) {
		
		PreparedStatement ps = null ; 
		
		try {
			ps = conn.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS ); 
			
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getEmail());
			ps.setDate(3, new java.sql.Date(obj.getDataNasimento().getTime()));
			ps.setDouble(4, obj.getBaseSalrio());
			ps.setInt(5, obj.getDepart().getId());
			
			
			// verificar se linhas foram alteradas 
			
			int linhas = ps.executeUpdate(); 
			
			if (linhas > 0) {
				
				ResultSet rs  = ps.getGeneratedKeys(); 
					if (rs.next() ) {
						int id = rs.getInt(1); 
						obj.setID(id);
					}
					Conecxao.CloseResultSet(rs);
			}else {
				throw new EXP("Erro linha não encontrada "); 
			}
			
			
		}catch (SQLException e) {
			throw new EXP(e.getMessage());
		}
		finally {
			Conecxao.CloseStatement(ps);
		}
		
	}

	@Override
	public void UpDate(Seller obj) {
		// TODO Auto-generated method stub
		
		
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
					+ "WHERE Id = ?");
			
			st.setString(1, obj.getNome());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getDataNasimento().getTime()));
			st.setDouble(4, obj.getBaseSalrio());
			st.setInt(5, obj.getDepart().getId());
			st.setInt(6, obj.getID());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new EXP(e.getMessage());
		}
		finally {
			Conecxao.CloseStatement(st);
		}
		
	}

	@Override
	public void DeleteById(Integer id) {
		// TODO Auto-generated method stub
		
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new EXP(e.getMessage());
		}
		finally {
			Conecxao.CloseStatement(st);
		}
	}
		

	@Override
	public Seller FindById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				Seller obj = instantiateSeller(rs, dep);
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new EXP(e.getMessage());
		}
		finally {
			Conecxao.CloseStatement(st);
			Conecxao.CloseResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAllSeller() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name");
			
			rs = st.executeQuery();
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while (rs.next()) {
				
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Seller obj = instantiateSeller(rs, dep);
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new EXP(e.getMessage());
		}
		finally {
			Conecxao.CloseStatement(st);
			Conecxao.CloseResultSet(rs);
		}
	}
	
	
	
	
	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setID(rs.getInt("Id"));
		obj.setNome(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalrio(rs.getDouble("BaseSalary"));
		obj.setDataNasimento(rs.getDate("BirthDate"));
		obj.setDepart(dep);
		return obj;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			
			st.setInt(1, department.getId());
			
			rs = st.executeQuery();
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while (rs.next()) {
				
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Seller obj = instantiateSeller(rs, dep);
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new EXP(e.getMessage());
		}
		finally {
			Conecxao.CloseStatement(st);
			Conecxao.CloseResultSet(rs);
		}
		
		
	}

}
