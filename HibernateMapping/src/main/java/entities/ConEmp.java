package entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="con_emps")
@PrimaryKeyJoinColumn(name="eid")
public class ConEmp extends Emp {
	
	float hours;
	float charges;
	public ConEmp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConEmp( String ename, float hours, float charges) {
		super( ename);
		this.hours = hours;
		this.charges = charges;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public float getCharges() {
		return charges;
	}
	public void setCharges(float charges) {
		this.charges = charges;
	}
	
	

}
