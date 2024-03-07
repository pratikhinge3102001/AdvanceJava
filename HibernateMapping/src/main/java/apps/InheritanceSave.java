package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.*;

public class InheritanceSave {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
								
		//create session
		Session session = sf.openSession();	
		
		
		Emp e1 = new PerEmp("Bakul", 10000, 1000);
		Emp e2 = new ConEmp("Bakul", 10000, 1000);
		
		Transaction tr = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		
		//session.get(PerEmp.class, 1)
		
		tr.commit();
		
		System.out.println("emps saved");
		
		session.close();
		
		sf.close();
		

	}

}
