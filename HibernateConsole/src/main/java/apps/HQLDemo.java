package apps;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.*;

import entities.Emp;

public class HQLDemo {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
								
		//create session
		Session session = sf.openSession();	
		
		//SQL - select * from emp
		/*Query q = session.createQuery("from Emp");
		
		List<Emp> emps = q.getResultList();
		
		for(Emp e : emps)
		{
			System.out.println(e.getEname()+" : "+e.getSalary()+" : "+e.getDeptno());
		}*/
		
		//sql = select empid,salary from emp where deptno = ?
				
		/*Query<Object[]> q = session.createQuery("select empid,salary from Emp where deptno = :dno",Object[].class);
		
		q.setParameter("dno", 20);
		
		List<Object[]> emps = q.getResultList();
		
		for(Object [] emp : emps)
		{
			System.out.println(emp[0]+" : "+emp[1]);
		}*/
		
		//Sql query "Update Emp set salary = 25000.0f 
		/*Query q = session.createQuery("update Emp set salary = :newSalary where empid = :empId");
		q.setParameter("newSalary", 25000.0f);
		q.setParameter("empId", 1100);
		Transaction tr = session.beginTransaction();
		int c = q.executeUpdate();
	
		if(c == 1)
		{
			System.out.println("Rows affected: " + c);
		}
		else
		{
			System.out.println("update failed");
			
		}
		tr.commit();
		session.close();
		sf.close();*/
		
		//total count of employees
		
		Query q = session.createQuery("select count(*) from Emp");
		Object totalCount = q.uniqueResult();

		System.out.println("Total number of employees: " + totalCount);
		
		

		
				
				

		
		//native query
		/*
		Query<Object []> q = session.createNativeQuery("select * from emp");

		List<Object []> emps = q.getResultList();
		
		for(Object [] e : emps)
		{
			//Emp e = new Emp(e[0],e)
			System.out.println(e[0]);
		}*/
		
		//named query
		/*Query q = session.getNamedQuery("getByRange");
		q.setParameter("min", 10000.0f);
		q.setParameter("max", 20000.0f);
		List<Emp> emps = q.getResultList();
		for(Emp e : emps)
		{
			System.out.println(e.getEmpid()+" : "+e.getSalary());
		}*/
		
		
		
		
	}

}







