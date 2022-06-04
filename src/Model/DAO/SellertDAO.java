package Model.DAO;

import java.util.List;

import Entities.Department;
import Entities.Seller;

public interface SellertDAO {

	public void Insert (Seller obj ); 
	public void UpDate (Seller obj);
	public void DeleteById (Integer id );
	public Seller FindById (Integer id); 
	List <Seller> findAllSeller (); 
	List<Seller> findByDepartment(Department department);
	
	
}
