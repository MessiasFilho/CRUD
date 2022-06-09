package Model.View;

import java.util.List;

import Entities.Department;
import Entities.Seller;
import Model.DAO.DepartmentDAO;
import Model.DAO.Factory_DAO;
import Model.DAO.SellertDAO;

public class ViewDates {
	protected static SellertDAO sele = Factory_DAO.getSellerDAO();
	protected static DepartmentDAO depDao = Factory_DAO.getDepartmentDao(); 
	
	public static void bancView () {
		
		System.out.println("Mostrar Departamentos ");
		List <Department > list = depDao.FindAllDeparment(); 
		for(Department s : list) {
			System.out.println(s);
		}
		
		System.out.println(" ");
		System.out.println("Mostrar Vendendores ");
		
		List <Seller> listsel = sele.findAllSeller(); 
		for (Seller x : listsel) {
			System.out.println(x);
		}
				
	}
	
	public static void ViewDepartment () {
		
		System.out.println("Mostrar Departamentos ");
		List <Department > list = depDao.FindAllDeparment(); 
		for(Department s : list) {
			System.out.println(s);
		}
	}
	
	public static void ViewSeller() {
		System.out.println("Mostrar Vendendores ");
		
		List <Seller> listsel = sele.findAllSeller(); 
		for (Seller x : listsel) {
			System.out.println(x);
		}
	}
	
	
	
	
	

}
