package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entities.Contact;

public class ContactJdbcDAO {
	@Autowired
	JdbcTemplate template;
	
	public List<Contact> getAll(){
		return template.query("select * from contacts", new RowMapper<Contact>() {
			//List<Contact> clist = new ArrayList();
			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Contact(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}
			
		});		
	}
	
	public boolean  save(Contact c)
	{
		//template.update("insert into contacts(uid,pass,...) values(?,?,?,?,...)",c.getUid(),c.getPassword(),c.getFname()  );
		return true;
	}
	
	
	
	
	
}
