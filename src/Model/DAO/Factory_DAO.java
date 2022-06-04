package Model.DAO;

import Conect.Conecxao;
import IMP.Model.DAO.Department_imp;
import IMP.Model.DAO.Seller_IMP;

public class Factory_DAO {

	public static  SellertDAO getSellerDAO () {
		return new Seller_IMP(Conecxao.getConnection());
		
	}
	
	public static DepartmentDAO getDepartmentDao () {
		return new  Department_imp (Conecxao.getConnection()); 
	}
}
