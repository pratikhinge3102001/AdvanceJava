package apps;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import entities.Question;
import entities.Subject;

public class Associate {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
								
		//create session
		Session session = sf.openSession();	
		
		//saving master entity
		Subject s = new Subject("web development", "learn to make website");
		Transaction tr = session.beginTransaction();
		session.save(s);
		tr.commit();
		
		Subject subject = session.get(Subject.class, 1);
		Question qi1 = new Question("www longform ?", "world Wide Web" ,"w" , "W" ,"w" ,"world Wide Web",subject);
		Transaction tr1 = session.beginTransaction();
		session.save(qi1);
		tr1.commit();
		
		
		//saving child entity for existing master
		/*Order order = session.get(Order.class, 1);
		OrderItem oi1 = new OrderItem(4, 5, order);
		Transaction tr = session.beginTransaction();
		session.save(oi1);
		tr.commit();
		*/
		
		//saving master and child together
		/*OrderItem oi1 = new OrderItem(10, 2);
		OrderItem oi2 = new OrderItem(11, 3);
		Set<OrderItem> items = new HashSet();
		items.add(oi1);
		items.add(oi2);
		Order order = new Order("bakul", items);
		Transaction tr = session.beginTransaction();
		session.save(order);
		tr.commit();*/
		
		session.clear();
		
		sf.close();
		
			

	}

}

