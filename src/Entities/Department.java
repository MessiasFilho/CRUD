package Entities;

import java.util.Objects;

public class Department {
	private String Name ; 
	private Integer Id ;
	
	
	public Department() {
		
	}

	public Department(String name, Integer id) {
		
		Name = name;
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(Id, other.Id);
	}

	@Override
	public String toString() {
		return "[ Department ]" + " Id= " + Id + " Name= " + Name  ;
	} 
	
	 

	
}
