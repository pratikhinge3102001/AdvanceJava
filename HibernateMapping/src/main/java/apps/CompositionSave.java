package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Address;
import entities.Student;

public class CompositionSave {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
								
		//create session
		Session session = sf.openSession();	
		
		//creting entity
		Address add = new Address("Deccan","Pune","411029");
		Student s = new Student("Amit", add);
		
		//saving entity in transaction
		Transaction tr = session.beginTransaction();
		session.save(s);
		tr.commit();
		
		System.out.println("student saved");
		
		session.close();
		
		sf.close();
		
		
		
		
		
		
		
		
		
		

	}

}
