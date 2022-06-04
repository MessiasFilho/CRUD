package Model.View;

import Conect.EXP;

public class Escolhas extends ViewDates {

	private static  TratmentsDepartments  deptrat ; 
	private  static TratmentSeller traSel ; 
	// Departamento
	
	public static void DepartamntoEsc (Integer esc ) {
		
		switch (esc) {
		case 1 : 
			System.out.println(" ===Inserir departamento=== ");
			deptrat = new TratmentsDepartments() ; 
			deptrat.inserirDepartment();
			break ; 
		case 2 : 
			System.out.println("=== UPDate Department ");
			deptrat = new TratmentsDepartments() ; 
			deptrat.UpDateBDByID();
			break;
		case 3 : 
			System.out.println("Delete por ID ");
			deptrat = new TratmentsDepartments() ; 
			deptrat.DeletebyID();
			break; 
		case 4 : 
			System.out.println("Buscar por ID ");
			deptrat = new TratmentsDepartments() ; 
			deptrat.FindByID();
			break ; 
		
		default : 
			throw new EXP("Opção invalida "); 
		
		}
	}
	
	public static void SellerEsc(  int esc  ) {
		switch (esc) {
		case 1 : 
			System.out.println(" ===Inserir Vendedor === ");
			
			traSel = new TratmentSeller(); 
			traSel.inserirSeller();
			break ; 
		case 2 : 
			System.out.println("=== Atualizar Vendedor ");
			traSel = new TratmentSeller(); 
			traSel.UpDateBDByID();
			break;
		case 3 : 
			System.out.println("Delete Vendedor por ID ");
			traSel = new TratmentSeller(); 
			traSel.DeletebyID();
			break; 
		case 4 : 
			System.out.println("Buscar Vendedor por ID  ");
			traSel = new TratmentSeller(); 
			traSel.FindByID();
			break ; 
		case 5 : 
			System.out.println("Buscar Vendedor por departament ");
			traSel = new TratmentSeller(); 
			traSel.findByDepartment();;
			break ;
		default : 
			throw new EXP("Opção invalida "); 
		}
	}
	
}
