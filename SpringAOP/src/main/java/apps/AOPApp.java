package apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Student;

public class AOPApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		
		Student st = (Student) ctx.getBean("st");
		//call to business logic method
		System.out.println(st);
		
		//call to business logic method
		System.out.println(st.getName());

	}

}
