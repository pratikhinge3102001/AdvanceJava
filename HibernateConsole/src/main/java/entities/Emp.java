package entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
//import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="emp")
@NamedQuery(name = "getByRange", query="from Emp where salary > :min and salary < :max")
public class Emp {
	@Id	
	int empid;
	
	//if comm may be null 
	//Float comm;
	
	@Column
	String ename;
	@Column
	int deptno;
	@Column
	float salary;
	@Column
	Date bdate;
	public Emp(int empid, String ename, int deptno, float salary, Date bdate) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.deptno = deptno;
		this.salary = salary;
		this.bdate = bdate;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
	
	
	
	

}
