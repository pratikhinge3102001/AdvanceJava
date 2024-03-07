package apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Emp;
import beans.Trainer;

public class DIApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		
		//Emp e=(Emp)ctx.getBean("emp");
		//System.out.println(e);  //toString()
		
		Trainer tr = (Trainer)ctx.getBean("tr");
		System.out.println(tr);

	}

}
