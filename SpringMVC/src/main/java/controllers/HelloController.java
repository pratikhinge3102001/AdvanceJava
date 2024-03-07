package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class HelloController {
	
	//no property
	
	
	
	//request processing logic for specified URL
	/*@RequestMapping(path = "/hello",method=RequestMethod.POST)
	public String sayHello() {
		return "hello";
	}
	
	@RequestMapping(path = "/hello",method=RequestMethod.GET)
	public String sayHello1() {
		return "hello";
	}*/
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	
	@RequestMapping("/greet")
	public ModelAndView greet(HttpServletRequest request)
	{
		 String nm = request.getParameter("name");
		 return new ModelAndView("greet", "name", nm);
	}
	
	
	
	@RequestMapping("/info")
	public String getInfo(HttpServletRequest request, ModelMap map)
	{
		map.addAttribute("req_url", request.getRequestURL());
		map.addAttribute("req_method", request.getMethod());
		Enumeration<String>  names = request.getParameterNames();
		int count = 0;
		while(names.hasMoreElements())
		{
			System.out.println(request.getParameter(names.nextElement()) );
			count++;
		}		
		
		map.addAttribute("para_count", count);
		map.addAttribute("host", request.getServerName());
		return "info";
		
	}
	
	

}
