package Entities;

import java.util.Date;
import java.util.Objects;

public class Seller {
	
	private Integer ID ; 
	private String Nome ; 
	private String Email ; 
	private Date DataNasimento ; 
	private Double BaseSalrio ;
	private Department Depart ;  
	
	public Seller() {
		super();
	}

	public Seller(Integer iD, String nome, String email, Date dataNasimento, Double baseSalrio ,  Department depart) {
		
		ID = iD;
		Nome = nome;
		Email = email;
		DataNasimento = dataNasimento;
		BaseSalrio = baseSalrio;
		 Depart = depart; 
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Department getDepart() {
		return Depart;
	}

	public void setDepart(Department depart) {
		Depart = depart;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Date getDataNasimento() {
		return DataNasimento;
	}

	public void setDataNasimento(Date dataNasimento) {
		DataNasimento = dataNasimento;
	}

	public Double getBaseSalrio() {
		return BaseSalrio;
	}

	public void setBaseSalrio(Double baseSalrio) {
		BaseSalrio = baseSalrio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(ID, other.ID);
	}

	@Override
	public String toString() {
		return "\nDepartamento: = "+ Depart.getName() + " ID :" + Depart.getId() +"\n Vendedor [ID=" + ID + "] [Nome=" + Nome + "] [Email=" + Email + "] [DataNasimento=" + DataNasimento
				+ "] [ BaseSalrio=" + BaseSalrio + "]"
				 ; 
	} 
	
	
	
	
		
	
}
