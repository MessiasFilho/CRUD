package Aplication;

import java.util.Scanner;

import Conect.EXP;
import Model.View.Escolhas;

public class Program {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("CRUD ATIVIDADE \n   ");
		System.out.println(" SELECIONE\n DEPARTAMENTO [1]\n VENDEDORES [2] ");
		Integer esc = sc.nextInt();
	
		switch (esc) {
		case 1 :
			
			System.out.println(" Inserir departamento (1) \n Atualizar Department (2) \n Delete por ID (3) \n Buscar por ID (4) ");
			Integer resp = sc.nextInt();
			Escolhas.DepartamntoEsc(resp);
			break ; 
		
		case 2 : 
			System.out.println(" Inserir Vendedor (1) \n Atualizar Vendedor (2) \n Delete Vendedor por ID (3) \n Buscar Vendedor por ID  (4) \n Buscar Vendedor por departament (5)  ");
			Integer resp2 = sc.nextInt();
			Escolhas.SellerEsc(resp2);
			break ;
			
		default: 
			System.out.println("Invalid");
		
		}
		
	}
	
	

}


	