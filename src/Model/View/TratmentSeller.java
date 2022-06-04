package Model.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Conect.EXP;
import Entities.Department;
import Entities.Seller;

public class TratmentSeller extends ViewDates {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Seller sel ;
	
	public TratmentSeller() {
		
	}
	
	public void inserirSeller ()   {
		ViewSeller();System.out.println("\n");
		// inserir no banco  de dados  
		try(Scanner sc = new  Scanner (System.in)) {
			System.out.print("Nome: ");
			String nome = sc.next(); 
			System.out.print("Email: ");
			String Email = sc.next(); 
			sc.nextLine(); 
			System.out.print("Data de nasciemto: ");
			String nasci = sc.next();   
			Date nas =  sdf.parse(nasci); 
			System.out.print("Valor Salario: ");
			Double salario =  sc.nextDouble(); 		
			System.out.println("\n informe a ID e o Nome do Deartamnto  ");
			ViewDepartment();
			System.out.print("\n ID: ");
			Integer Id = sc.nextInt(); 
			System.out.print("Nome Departamento: ");
			String nade = sc.next(); 
			Department dep = new Department(nade,Id); 
		
		
			sele.Insert(new Seller(Id , nome,Email,nas,salario, dep));
		
			ViewSeller();
		
		
		}catch (Exception e) {
			throw new EXP("Dado informado invalido");
		}
		
	}
	
	public void UpDateBDByID() {
		ViewSeller();System.out.println("\n");
		// atualizar banco de dados 
		try(Scanner sc = new  Scanner (System.in)) {
		 	System.out.print("Nome: ");
			String nome = sc.next(); 
			System.out.print("Email: ");
			String Email = sc.next(); 
			System.out.print("Data de nasciemto: ");
			String nasci = sc.next();   
			Date nas =  sdf.parse(nasci); 
			System.out.print("Valor Salario: ");
			Double salario =  sc.nextDouble(); 		
			
			System.out.println("\n informe a ID e o Nome do Deartamnto  ");
			ViewDepartment();
			
			System.out.print("Nome Departamento: ");
			String nade = sc.next(); 
			System.out.println("Informe a id que vai ser atualizada ");
			System.out.print("\n ID: ");
			Integer Id = sc.nextInt(); 
			
			Department dep = new Department(nade,Id); 
		
			sele.UpDate(new Seller(Id ,nome,Email,nas,salario, dep));
		
			ViewSeller();
		
		}catch (Exception e) {
			throw new EXP("Dado informado invalido"+e.getMessage());
		}
	}
	
	
	public void DeletebyID() {
		ViewSeller();System.out.println("\n");
		
		System.out.println("Informe a id a ser deletada ");
		try(Scanner sc = new  Scanner (System.in)) {
		System.out.print("ID: ");
		Integer id = sc.nextInt() ; 
		
		sele.DeleteById(id);
		
		ViewSeller();System.out.println("\n");
		
		System.out.println("ID deletada com sucesso !!! ");
		}catch (Exception e) {
			throw new EXP("Dado Invalid "); 
		}
		
	}
	
	public void FindByID () {
		ViewSeller();System.out.println("\n");
		System.out.println("Busca por ID ");
		
		try(Scanner sc = new  Scanner (System.in)) {
			System.out.println("Informe a Id: ");
			Integer id = sc.nextInt(); 
			sel =   sele.FindById(id);
			System.out.println(sel);
			
		}catch (Exception e) {
			throw new EXP("Dado Invalid "); 
		}
		
	}
	
	public void findByDepartment () {
		System.out.println("vendedor por departamento ");
		ViewDepartment();
		try(Scanner sc = new  Scanner (System.in)) {
			System.out.print("Nome do departamento: ");
			String Nome = sc.next(); 
			System.out.print("ID depatamento: ");
			Integer id = sc.nextInt(); 
			Department dep = new Department(Nome ,id );
			  List<Seller> list = sele.findByDepartment(dep); 
			  
			  for (Seller x : list) {
				  System.out.println(x);
			  }
			  
		}catch (Exception e) {
			throw new EXP("Dado Invalid "); 
		}
	}
	
}
