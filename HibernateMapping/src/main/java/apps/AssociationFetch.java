package apps;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Order;
import entities.OrderItem;

public class AssociationFetch {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
								
		//create session
		Session session = sf.openSession();	
		
		/*Order order = session.get(Order.class, 2);

		System.out.println(order.getCname());
		Set<OrderItem> items = order.getItems();
		for(OrderItem oi : items)
			System.out.println(oi.getPid()+" : "+oi.getQty());
		//System.out.println(order.getItems().size());
		*/
		
		
		OrderItem oi = session.get(OrderItem.class, 2);
		System.out.println(oi.getPid()+" : "+oi.getQty()+" : "+oi.getOrder().getCname());
		
		session.close();
		sf.close();
		
	}
}
