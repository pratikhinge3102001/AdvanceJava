package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import entities.Contact;

@Transactional
public class ContactDAO {

	//no setter method, no property element
	@Autowired
	HibernateTemplate template;	
	
	public List<Contact> getAll()
	{
		//select * from contacts	
		return template.loadAll(Contact.class);
	}
	
	public Integer save(Contact c)
	{
		return (Integer)template.save(c);
	}
	
	public Contact getOne(int cid)
	{
		return template.get(Contact.class, cid);
	}

	@Transactional
	public void update(Contact ct) {
	    try {
	        template.update(ct);
	    } catch (HibernateOptimisticLockingFailureException e) {
	        throw new RuntimeException("Concurrent update detected. Please refresh and try again.");
	    }
	}

    public void delete(Contact ct) {
        template.delete(ct);
    }
       
	
    
	
}
