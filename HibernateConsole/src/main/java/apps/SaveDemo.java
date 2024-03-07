package apps;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Emp;

public class SaveDemo {

	public static void main(String[] args) throws ParseException
	{
		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
				
				
				//create session
				Session session = sf.openSession();

				//LocalDate.parse("2000-09-08").get
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date bdate_p = new java.util.Date(sdf.parse("2001-10-03").getTime());
				java.sql.Date bdate = new java.sql.Date(bdate_p.getTime());
				
				Emp emp = new Emp(1100,"pratik",10,13456,bdate);
				
				Transaction tr = session.beginTransaction();
				
				session.save(emp);  //insert query
				
				tr.commit();
				
				session.close();
				
				sf.close();
				
				System.out.println(emp);

	}

}
