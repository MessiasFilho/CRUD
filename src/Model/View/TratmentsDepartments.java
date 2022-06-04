package Model.View;

import java.util.Scanner;

import Conect.EXP;
import Entities.Department;

public class TratmentsDepartments extends ViewDates {
	
	private Department depart ; 
	
	
	public void inserirDepartment () {
		ViewDepartment();
		System.out.println("Inserir novo departamento: ");
		try (Scanner sc =  new Scanner (System.in) ){
			System.out.print("Nome: ");
			String Nome = sc.next(); 
			System.out.print("ID: ");
			Integer id = sc.nextInt(); 
			depart= new Department(Nome,id); 
			depDao.Insert(depart);
			ViewDepartment();
		}catch (Exception e) {
			throw new EXP("Dados invalidos "+e.getMessage()); 
		}
	}
	
	public void UpDateBDByID() {
		
		ViewDepartment();
		System.out.println("Atualizar departamento : ");
		try (Scanner sc =  new Scanner (System.in) ){
			System.out.print("Nome: ");
			String Nome = sc.next(); 
			System.out.print("ID: ");
			Integer id = sc.nextInt(); 
			depart= new Department(Nome,id); 
			depDao.Update(depart);
			ViewDepartment();
		}catch (Exception e) {
			throw new EXP("Dados invalidos "+e.getMessage()); 
		}
		
	}
	
	public void DeletebyID() {
		ViewDepartment();
		System.out.println("Informe a ID a ser deletada ");
		try (Scanner sc =  new Scanner (System.in) ){
			System.out.print("ID ");
			Integer id = sc.nextInt(); 
			
			depDao.DeleteById(id);
			System.out.println();
			ViewDepartment();
			
		}catch (Exception e) {
			throw new EXP("Dados invalidos "+e.getMessage()); 
		}
		
	}
	
	public void FindByID () {
		
		ViewDepartment();
		System.out.println("Informe a ID Deparatmento ");
		try (Scanner sc =  new Scanner (System.in) ){
			System.out.print("ID ");
			Integer id = sc.nextInt(); 
			
			depDao.FindById(id);
			System.out.println();
			ViewDepartment();
			
		}catch (Exception e) {
			throw new EXP("Dados invalidos "+e.getMessage()); 
		}
		
	}
	
	
}
