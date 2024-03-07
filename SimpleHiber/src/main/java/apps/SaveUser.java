package apps;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



import entities.User;

public class SaveUser {

	public static void main(String[] args) throws Exception
	{

		//create session factory
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
						
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
						
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		
		//create session
		Session session = sf.openSession();

		
		
		User user = new User("rishi123" ,"Rishi@123" , "rishi1@gmail.com","Hrishi","6575687465");
		
		Transaction tr = session.beginTransaction();
		
		session.save(user);  //insert query
		
		tr.commit();
		
		session.close();
		
		sf.close();
		
		

	}

}
