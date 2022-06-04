package Model.DAO;

import java.util.List;

import Entities.Department;

public interface DepartmentDAO {
	
	public void Insert (Department dep ); 
	public void Update (Department dep ); 
	public void DeleteById (Integer id);
	public Department FindById (Integer id );
	List<Department > FindAllDeparment (); 
	
	
	
	
}
