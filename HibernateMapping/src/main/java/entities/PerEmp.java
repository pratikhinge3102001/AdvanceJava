package entities;

import javax.persistence.*;

@Entity
@Table(name="per_emps")
@PrimaryKeyJoinColumn(name = "eid")
public class PerEmp extends Emp {

	@Column
	float salary;
	@Column
	float bonus;
	public PerEmp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PerEmp( String ename, float salary, float bonus) {
		super( ename);
		this.salary = salary;
		this.bonus = bonus;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	
	
	
}
