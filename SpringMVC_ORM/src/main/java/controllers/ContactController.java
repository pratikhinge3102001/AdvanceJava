package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.ContactDAO;
import entities.Contact;

import java.util.List;

@Controller
public class ContactController {
	
	@Autowired
	ContactDAO cdao;
	
	@RequestMapping("/all")
	public ModelAndView getAllContacts()
	{
		List<Contact> clist = cdao.getAll();
		return new ModelAndView("all","clist",clist);
	}
	
	@RequestMapping("/create")
	public ModelAndView showform()
	{
		return new ModelAndView("contactform","con",new Contact());
		
	}
	
	@RequestMapping("/save")
	public ModelAndView saveContact(@ModelAttribute("con") Contact contact)
	{
		System.out.println(contact);
		int cid = cdao.save(contact);
		return new ModelAndView("success", "cid", cid); 
	}
	
	@RequestMapping("/edit")
	public ModelAndView getEdit(@RequestParam("cid") int n)
	{
		Contact con = cdao.getOne(n);
		return new ModelAndView("editcontact","econ",con);
	}
	
	
	@RequestMapping("/update")
	public ModelAndView updateContact(@ModelAttribute("econ") Contact ct) {
	    try {
	        cdao.update(ct);
	        return new ModelAndView("success", "cid", ct.getCid()); // Assuming getCid() returns the contact's ID
	    } catch (RuntimeException e) {
	       
	        return new ModelAndView("error", "errorMessage", e.getMessage());
	    }
	}

	
	@RequestMapping("/delete")
	public ModelAndView deleteContact(@RequestParam("cid") int n) {
		Contact con = cdao.getOne(n);
		cdao.delete(con);
		return new ModelAndView("redirect:/all"); 
	}

}
